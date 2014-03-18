package com.example.hotelclubs;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity {

	private ArrayList<String> arrayList;
	private ArrayList<Integer>  integersList;
	private GirdViewCustomAdapter customAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.makeList();
		//Getting the size of the device
		ImageView imageView = (ImageView) findViewById(R.id.imgCover);
		//ImageView imageViewHeader = (ImageView) findViewById(R.id.txtCaption);
		ImageView imageViewFooter=(ImageView) findViewById(R.id.footerImage);
		

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		int wPix = dm.widthPixels;
		int hPix =  (int) ((dm.heightPixels)*.40);
		// change menu image width and height
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(wPix, hPix);
		imageView.setLayoutParams(lp);



		int wPixFooter = (int) (dm.widthPixels*.25);
		int hPixFooter = (int) (dm.heightPixels*.1);
		// change menu image width and height
		RelativeLayout.LayoutParams footerSize = new RelativeLayout.LayoutParams(wPixFooter,hPixFooter);
		imageViewFooter.setLayoutParams(footerSize);
		//layout.setLayoutParams(new RelativeLayout.LayoutParams(dm.widthPixels,(int)(dm.heightPixels*.1)));

		customAdapter = new GirdViewCustomAdapter(this,this.arrayList, this.integersList,hPix,wPix);
		GridView	gridView = (GridView) findViewById(R.id.listMainMenu);
		/*LayoutParams layoutParams=gridView.getLayoutParams();
		layoutParams.height=(int)(dm.heightPixels*.5);
		gridView.setLayoutParams(layoutParams);*/
		gridView.setAdapter(customAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				String text=customAdapter.getItem(position).toString();
				if(text.equalsIgnoreCase("Reviews"))
				{

					Intent intent=new Intent(v.getContext(), Reviews.class);
					startActivity(intent);	
				}
				else if(text.equalsIgnoreCase("Menu"))
				{
					Intent intent=new Intent(v.getContext(), ListMenuActiviy.class);
					startActivity(intent);		
				}
				else if(text.equalsIgnoreCase("Contact Us"))
				{
					Intent intent=new Intent(v.getContext(), ContactUs.class);
					startActivity(intent);		
				}
				else if(text.equalsIgnoreCase("GALLERY"))
				{
					Intent intent=new Intent(v.getContext(), Gallery.class);
					startActivity(intent);		
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void makeList()
	{
		this.integersList=new ArrayList<Integer>();
		this.integersList.add(R.drawable.menu_icon);
		this.integersList.add(R.drawable.photos_icon);
		this.integersList.add(R.drawable.deals_icon);
		this.integersList.add(R.drawable.share_icon);
		this.integersList.add(R.drawable.contact_icon);
		this.integersList.add(R.drawable.share_reviews_icon);

		this.arrayList=new ArrayList<String>();
		this.arrayList.add("MENU");
		this.arrayList.add("GALLERY");
		this.arrayList.add("DEALS");
		this.arrayList.add("REVIEWS");
		this.arrayList.add("CONTACT US");
		this.arrayList.add("SHARE");
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}

}
