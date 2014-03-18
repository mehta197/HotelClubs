package com.example.hotelclubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AddReviews extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_reviews_edit);
		ImageView image=(ImageView) findViewById(R.id.addreviewBack);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(wPix,(int)( hPix*.1));
		Button  btn=(Button) findViewById(R.id.submitReviews);
		btn.setLayoutParams(lp);

		lp = new RelativeLayout.LayoutParams((int)(wPix*.15),(int)( hPix*.1));
		ImageView  refresh=(ImageView) findViewById(R.id.addimgRefresh);
		refresh.setLayoutParams(lp);

		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.addReviewHeader);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams((int)(wPix*.9), (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  

		lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)( hPix*.1));
		image.setLayoutParams(lp);

		TextView reviewText=(TextView) findViewById(R.id.EditTextFeedbackBody);
		final String reviews=reviewText.getText().toString();
		TextView reviewName=(TextView) findViewById(R.id.EditTextName);
		final String reviewNameText=reviewName.getText().toString();

		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Reviews.content.add(reviews);
				Reviews.name.add(reviewNameText);
				Intent intent=new Intent(v.getContext(), Reviews.class);
				startActivity(intent);	
			}
		});

		image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
				Intent intent=new Intent(v.getContext(), Reviews.class);
				startActivity(intent);	
			}
		});

	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}
