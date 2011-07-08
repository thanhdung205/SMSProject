package com.BulkSMS;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainProgram extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayListMenu array = new ArrayListMenu();
        array.GetMenu();
        MenuItemAdapter ap = new MenuItemAdapter(this,R.layout.mainlist,array.arraylist);
        ListView list = (ListView) findViewById(R.id.menulist);
       list.setAdapter(ap);

    }
}