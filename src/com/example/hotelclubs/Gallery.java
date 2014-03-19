package com.example.hotelclubs;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Gallery extends Activity{

	public ArrayList<Integer> photos;
	private Photo_Gird gird;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.photo_gallery);


		GridView gridView=(GridView) findViewById(R.id.photolist);
		ImageView btn=(ImageView) findViewById(R.id.photoBack);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;

		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.photoreviewHeader);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams(wPix, (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)( hPix*.1));
		btn.setLayoutParams(lp);


		photoList();
		gird=new Photo_Gird(this, photos,wPix,hPix);
		gridView.setAdapter(gird);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				// Sending image id to FullScreenActivity
				onBackPressed();
				Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
				i.putExtra("nameOfPhoto", arg2);
				// passing array index
				startActivity(i);
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


	public  void photoList()
	{
		photos=new ArrayList<Integer>();

		photos.add(R.drawable.photo_item_3);
		photos.add(R.drawable.photo_item_2);


	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}


