package com.example.hotelclubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ItemDetails extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_details);
		ImageView image=(ImageView) findViewById(R.id.itemreviewBack);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;

		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.itemreviewHeader);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams(wPix, (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  

		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)( hPix*.1));
		image.setLayoutParams(lp);


		ImageView imageView=(ImageView) findViewById(R.id.itemPic);
		imageView.setBackgroundResource(R.drawable.images);
		LinearLayout.LayoutParams zp = new LinearLayout.LayoutParams((int)(wPix),(int)( hPix*.4));
		imageView.setLayoutParams(zp);

		TextView textViewName=(TextView) findViewById(R.id.itemName);
		textViewName.setText("CHEESE BURGER");
		textViewName.setPadding(10, 0, 0, 0);
		textViewName.setGravity(17);
		RelativeLayout.LayoutParams tp = new RelativeLayout.LayoutParams((int)(wPix*.70),(int)( hPix*.1));
		textViewName.setLayoutParams(tp);


		TextView textView=(TextView) findViewById(R.id.itemPrice);		
		textView.setText("CAD 34.5");
		textView.setGravity(17);
		textView.setMinHeight((int) (hPix*.1));




		textView=(TextView) findViewById(R.id.itemdetails);
		textView.setText("It's not clear what the indication was, but senior administration officials told ABC News "
				+ "the missing Malaysian flight continued to ping a satellite on an hourly basis after"
				+ " it lost contact with radar. The Boeing 777 jetliners are equipped with what is called the Airplane Health Management system in "
				+ "which they ping a satellite every hour. The number of pings would indicate how long the plane stayed aloft.");
		zp = new LinearLayout.LayoutParams((int)(wPix),(int)(hPix));
		textView.setLayoutParams(zp);

		image.setOnClickListener(new View.OnClickListener() {
			//@Override
			public void onClick(View v) {
				onBackPressed();
				Intent intent=new Intent(v.getContext(), ListMenuActiviy.class);
				startActivity(intent);         
			}        
		});

		
		
	}
}