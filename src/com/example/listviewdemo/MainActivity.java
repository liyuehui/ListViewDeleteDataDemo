package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView  mListView;
	private Button bt;
	private BaseAdapter mAdapter;
	private List<String> list;

	private List<String> deleteList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		list = new ArrayList<String>();
		list.add("itme1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		
		deleteList = new ArrayList<String>();
		
		mListView = (ListView) findViewById(R.id.listView);
		bt = (Button) findViewById(R.id.bt);
		mAdapter = new MyAdapter();
		mListView.setAdapter(mAdapter);
		
		//点击删除按钮 删除选中项
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				for(int i =0 ;i < deleteList.size(); i++){
					if(list.contains(deleteList.get(i))){
						list.remove(deleteList.get(i));
					}
				}
				
				mAdapter.notifyDataSetChanged();
			}
		});
		
	}
	
	

	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View view = View.inflate(MainActivity.this,R.layout.item_view, null);
			TextView tv = (TextView) view.findViewById(R.id.textView);
			CheckBox ch = (CheckBox) view.findViewById(R.id.check);
			tv.setText(list.get(position));
			
			ch.setOnCheckedChangeListener(new OnCheckedChangeListener(){

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(isChecked){
						if(!deleteList.contains(list.get(position)))
							deleteList.add(list.get(position));
						
					}else{
						if(deleteList.contains(list.get(position)))
						deleteList.remove(list.get(position));
					}
				}
				
			});
			
			
			return view;
		}
		
	}

}
