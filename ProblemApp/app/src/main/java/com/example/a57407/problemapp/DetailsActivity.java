package com.example.a57407.problemapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    Detail_ItemAdapter itemAdapter;
    Context thiscontext;
    ListView myListView;
    TextView progressTextView;
    Map<String,Double> fruitmap = new LinkedHashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

/*        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.detiallistView);
        progressTextView = (TextView)findViewById(R.id.progressTextView);
        thiscontext = this;

        progressTextView.setText("");
*/
    }
    private class GetData extends AsyncTask<String,String,String>{

        String msg = "";

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://"+
                DbStrings.DATABASE_URL+"/"+
                DbStrings.DATABASE_NAME;

        protected void onPreExecute(){
            progressTextView.setText("connecting to database");
        }
        @Override
        protected String doInBackground(String... strings) {
            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,DbStrings.USERNAME,DbStrings.PASSWORD);

                stmt = conn.createStatement();
                String sql = "SELECT * FROM fruits";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    String name = rs.getString("names");
                    double price = rs.getDouble("price");

                    fruitmap.put(name,price);
                }
            } catch (ClassNotFoundException e) {
                msg = "An exception was thrown for JDBC";
                e.printStackTrace();
            } catch (SQLException e) {
                msg = "A class not found exception was thrown";
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String msg){
            progressTextView.setText(this.msg);
            if(fruitmap.size()>0){
                itemAdapter = new Detail_ItemAdapter(thiscontext,fruitmap);
                myListView.setAdapter(itemAdapter);
            }
        }
    }
}
