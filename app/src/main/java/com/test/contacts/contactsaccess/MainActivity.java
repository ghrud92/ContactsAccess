package com.test.contacts.contactsaccess;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    protected String[] names = {"abc", "def", "ghi"};
    protected String[] numbers = {"0106745","16546","6351864"};
    protected int[] ids = {1,2,3};

    TextView txt;
    ListView list;
    ContentValues cv;
    Uri u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.text);
        list = (ListView)findViewById(R.id.list);
        Uri uri = getTheUri();
        grantUriPermission("ContactsContract.CommonDataKinds.Phone.CONTENT_URI", uri, 2);
        insertContacts(names, numbers, ids);

        Button insertBtn = (Button) findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                             Toast.makeText(getApplicationContext(), "inset Button",
                                                     Toast.LENGTH_LONG).show();
                                            //insertContacts(names,numbers,ids);
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

    public static Uri getTheUri() {
        return Uri.parse("content://com.android.contacts/contacts");
    }

    protected void insertContacts(String[] names, String[] numbers, int[] ids) {
        ContentValues cv = new ContentValues();
        //this.grantUriPermission("com.test.contacts.contactsaccess", Uri.parse("content://com.android.contacts/contacts"), MODE_WORLD_WRITEABLE);
        this.grantUriPermission("com.example.contactsdemo", Uri.parse("content://com.android.contacts/contacts"), MODE_WORLD_WRITEABLE);
        for(int i = 0; i<names.length; i++) {
            cv.put(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,names[i]);
            cv.put(ContactsContract.CommonDataKinds.Phone.NUMBER,numbers[i]);
            cv.put(ContactsContract.CommonDataKinds.Phone._ID,ids[i]);
            u = getContentResolver().insert(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cv);
        }
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
