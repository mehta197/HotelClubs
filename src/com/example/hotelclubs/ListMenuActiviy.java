package com.example.hotelclubs;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;




public class ListMenuActiviy extends Activity {
	private ArrayList<String> listItem;
	private ArrayList<String> itemNumbers;
	private ArrayList<Integer> integersList;
	private CategoryListAdapter adapterCategoryListAdapter;
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		createList();
		setContentView(R.layout.listing);
		ImageView btn=(ImageView) findViewById(R.id.imgNavBack);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;


		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.lytTitlebar);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams((int)(wPix*.9), (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  


		RelativeLayout.LayoutParams  lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)( hPix*.1));
		btn.setLayoutParams(lp);


		lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)(hPix*.1));
		ImageView  refresh=(ImageView) findViewById(R.id.imgRefresh);
		refresh.setLayoutParams(lp);;  

		adapterCategoryListAdapter = new CategoryListAdapter(this,this.listItem, this.integersList,this.itemNumbers);
		ListView	listView = (ListView) findViewById(R.id.listCat);
		listView.setAdapter(adapterCategoryListAdapter);


		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			}
		});




		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				onBackPressed();
				Intent intent=new Intent(v.getContext(), MainActivity.class);				
				startActivity(intent);	
			}
		});


	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void createList()
	{
		listItem=new ArrayList<String>();
		listItem.add("BREAKFAST");
		listItem.add("LUNCH");
		listItem.add("BEVERAGES");
		listItem.add("ROYAL BEGINNINGS");
		listItem.add("SALADS");


		itemNumbers=new ArrayList<String>();
		itemNumbers.add("25 items");
		itemNumbers.add("13 items");
		itemNumbers.add("30 items");
		itemNumbers.add("10 items");
		itemNumbers.add("12 items");

		this.integersList=new ArrayList<Integer>();
		this.integersList.add(R.drawable.category_icon);

	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
	}
} 