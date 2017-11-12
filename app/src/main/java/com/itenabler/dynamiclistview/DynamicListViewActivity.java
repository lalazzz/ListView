/**
 * Copyright (c) 2015 Android ATC.
 * 
 * Author: Android ATC Training Team.
 * 
 * Source code in this project is provided for trainers of  
 * course AND-401 titled "Android Application Development".
 * 
 * The is the source code for Lab 3 of the text book.
 * 
 */

package com.itenabler.dynamiclistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DynamicListViewActivity extends Activity {

	private EditText item;
	private Button add;
	private ListView dynamicListView;
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dynamic_listview_activity);

		item = (EditText) findViewById(R.id.myEditText);
		add = (Button) findViewById(R.id.myAddButton);
		dynamicListView = (ListView) findViewById(R.id.myListView);

		// Initialize the list and add item
		list = new ArrayList<String>(); //Dynamic list to use .add or .remove to edit the array
		list.add("Android ATC");
		// Initialize the arrayAdapter
		adapter = new ArrayAdapter<String>(DynamicListViewActivity.this, android.R.layout.simple_list_item_1, list);
		// Setting the adapter to the listView
		dynamicListView.setAdapter(adapter);

		// Add item to the listView on click button (add)
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Add editText Value to the list
				list.add(item.getText().toString());
				// Apply Changes on the adapter to refresh the listView
				adapter.notifyDataSetChanged();
				// Clear the editText for the new Item
				item.setText("");
			}
		});


		// Delete item on the long click on the item
		dynamicListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            // Right click for mobile is the long click in the device
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0,
                                           View arg1, int position, long arg3) {
                // Remove the item from list
                list.remove(position);
                // Apply changes on the adapter to refresh the listView
                adapter.notifyDataSetChanged();
                return true;
            }
        });


		//Creating one click simulatiion to see the toast message.
		dynamicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(DynamicListViewActivity.this, "This is the position you click on the list : " + list.indexOf(position),Toast.LENGTH_SHORT).show();
                Toast.makeText(DynamicListViewActivity.this, "This is the position you click on the list : " + list.get(position), Toast.LENGTH_SHORT).show();

                //Another lesson for setitemclickListener.
            }
		});

	}

}
