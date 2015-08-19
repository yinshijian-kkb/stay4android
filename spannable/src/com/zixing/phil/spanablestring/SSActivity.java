package com.zixing.phil.spanablestring;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SSActivity extends Activity {
    
	private ListView lst;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }

	private void init() {
		lst = (ListView)findViewById(R.id.lst_menu);
		lst.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				TextView txt = (TextView) getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
				txt.setText(Styles.styles[arg0]);
				txt.setTextColor(Color.BLACK);
				txt.setBackgroundColor(Color.WHITE);
				return txt;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				return Styles.styles.length;
			}
		});
		lst.setOnItemClickListener(lstItemClickListener);
	}
	
	private ListView.OnItemClickListener lstItemClickListener = new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			Intent intent = new Intent(SSActivity.this,EffectActivity.class);
			intent.putExtra(Styles.STYLE_INDEX, arg2);
			startActivity(intent);
		}
		
	};
}