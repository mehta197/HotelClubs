package com.example.hotelclubs;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FullImageActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.photo_details);
		photoList();
		Bundle b=getIntent().getExtras();
		int photoName=b.getInt("nameOfPhoto");
		ImageView imageView=(ImageView) findViewById(R.id.photoThumbNail);
		imageView.setBackgroundResource(photos.get(photoName));
		ImageView btn=(ImageView) findViewById(R.id.photoBack);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;
		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.photoreviewHeader);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams(wPix, (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);
		RelativeLayout.LayoutParams zp = new RelativeLayout.LayoutParams((int) (wPix*.1), (int) ((int)hPix*.1));
		btn.setLayoutParams(zp);


		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
				Intent intent=new Intent(v.getContext(), Gallery.class);
				startActivity(intent);	
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
	}
	private ArrayList<Integer> photos=new ArrayList<Integer>();
	public  void photoList()
	{
		photos=new ArrayList<Integer>();

		photos.add(R.drawable.photo_item_3);
		photos.add(R.drawable.photo_item_2);


	}

}