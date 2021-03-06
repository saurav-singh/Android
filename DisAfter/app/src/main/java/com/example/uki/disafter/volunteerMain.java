package com.example.uki.disafter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class volunteerMain extends Activity {




    private void openActivity(int position){
        switch (position){
            case 0:
                Intent i = new Intent(volunteerMain.this, campaigns.class);
                startActivity(i);
                break;
            case 2:
               Intent i_2 = new Intent(volunteerMain.this, userSettings.class);
                startActivity(i_2);
                break;

            default:
                Toast.makeText(volunteerMain.this, "Cannot open activity", Toast.LENGTH_LONG).show();

        }



    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_main);

        SessionManagement sessionManagement = new SessionManagement(volunteerMain.this);



        sessionManagement.checkLogin(volunteerMain.this);







        // Setting up ListView

        String theList[] = {"Campaigns", "Profile", "Settings"};

        ListView theListView = (ListView)findViewById(R.id.theListView);

        ArrayAdapter theAdapter = new MainActivityAdapter(volunteerMain.this, theList, 1);

        theListView.setAdapter(theAdapter);




        // ListView OnItemClickListener

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                openActivity(position);

            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_volunteer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }







}
