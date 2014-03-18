package com.example.hotelclubs;



import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;





public class Reviews extends Activity{
	static ArrayList<String> content=new ArrayList<String>();
	static ArrayList<String> name=new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reviews);
		
		ImageView btn=(ImageView) findViewById(R.id.reviewBack);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(wPix,(int)( hPix*.1));
		TextView  textView=(TextView) findViewById(R.id.addReviewstext);
		textView.setLayoutParams(lp);

		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.reviewHeader);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams((int)(wPix*.9), (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  


		lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)( hPix*.1));
		btn.setLayoutParams(lp);


		lp = new RelativeLayout.LayoutParams((int)(wPix*.1),(int)(hPix*.1));
		ImageView  refresh=(ImageView) findViewById(R.id.imgRefresh);
		refresh.setLayoutParams(lp);

		setReview();
		ListView reviewList=(ListView) findViewById(R.id.reviewlist);
		ReviewList list=new ReviewList(this, content, name);
		reviewList.setAdapter(list);
		
		textView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//DO you work here
				Intent intent=new Intent(v.getContext(), AddReviews.class);
				//Intent intent = new Intent(v.getContext(), MyListActivity.class);
				startActivity(intent);	
			}
		});

		btn.setOnClickListener(new View.OnClickListener() {
			//@Override
			public void onClick(View v) {
				onBackPressed();
			
				Intent intent=new Intent(v.getContext(), MainActivity.class);
				startActivity(intent);         
			}        
		});
		
		
		
	}


	public void setReview()
	{
		content.add("Net income attributable to shareholders was $43.4 million, or 35 cents per "
				+ "basic share, for the three months ended Dec. 31, versus $7.1"
				+ " million or six cents year over year");

		content.add("Net income attributable to shareholders was $43.4 million, or 35 cents per "
				+ "basic share, for the three months ended Dec. 31, versus $7.1"
				+ " million or six cents year over year");


		content.add("Net income attributable to shareholders was $43.4 million, or 35 cents per "
				+ "basic share, for the three months ended Dec. 31, versus $7.1"
				+ " million or six cents year over year");

		content.add("Net income attributable to shareholders was $43.4 million, or 35 cents per "
				+ "basic share, for the three months ended Dec. 31, versus $7.1"
				+ " million or six cents year over year");

		content.add("Net income attributable to shareholders was $43.4 million, or 35 cents per "
				+ "basic share, for the three months ended Dec. 31, versus $7.1"
				+ " million or six cents year over year");

		name.add("Jay");
		name.add("Ameya");
		name.add("Taranjeet");
		name.add("Aman");
		name.add("Suba");

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}