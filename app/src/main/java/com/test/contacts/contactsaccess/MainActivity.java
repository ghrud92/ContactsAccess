package com.test.contacts.contactsaccess;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insertBtn = (Button) findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     Toast.makeText(getApplicationContext(), "inset Button",
                             Toast.LENGTH_LONG).show();
                 }
             }
        );

        Button modifyBtn = (Button) findViewById(R.id.modifyBtn);
        modifyBtn.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     Toast.makeText(getApplicationContext(), "modify Button",
                             Toast.LENGTH_LONG).show();
                 }
             }
        );

        Button deleteBtn = (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     Toast.makeText(getApplicationContext(), "delete Button",
                             Toast.LENGTH_LONG).show();
                 }
             }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
