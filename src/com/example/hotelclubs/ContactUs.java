package com.example.hotelclubs;

import android.support.v4.app.FragmentActivity;  
import android.util.DisplayMetrics;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactUs extends FragmentActivity{

	private GoogleMap mMap;
	private SupportMapFragment mMapFragment;
	@Override
	public void onCreate(Bundle bundle)  {
		super.onCreate(bundle);
		setContentView(R.layout.contact_us);
		ImageView btnBack=(ImageView) findViewById(R.id.contactUsBack);


		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int wPix = dm.widthPixels;
		int hPix = dm.heightPixels;


		RelativeLayout targetItem = (RelativeLayout) findViewById(R.id.lytTitlebar);
		RelativeLayout.LayoutParams adaptLayout = new RelativeLayout.LayoutParams(wPix, (int) ((int)hPix*.1));
		targetItem.setLayoutParams(adaptLayout);  
		adaptLayout = new RelativeLayout.LayoutParams((int)(wPix*.1), (int) ((int)hPix*.1));
		btnBack.setLayoutParams(adaptLayout);
		try{	
			mMapFragment = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maplist));
			mMap = mMapFragment.getMap();

			FrameLayout frameLayout=(FrameLayout) findViewById(R.id.lytMap);

			android.view.ViewGroup.LayoutParams fp = frameLayout.getLayoutParams();
			fp.width = wPix;
			fp.height = (int)(hPix*.6);
			mMap.setMyLocationEnabled(true);
			// For dropping a marker at a point on the Map
			mMap.addMarker(new MarkerOptions().position(new LatLng(45.35708190086541, -75.80015299783554)).title("My Home").snippet("Home Address"));
			// For zooming automatically to the Dropped PIN Location
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45.35708190086541,
					-75.80015299783554), 12.0f));
		}
		catch(Exception e)
		{
			Toast.makeText(ContactUs.this, 
					"Google Play Service is required", Toast.LENGTH_SHORT).show();
		}
		Button button=(Button) findViewById(R.id.btnCall);
		LinearLayout.LayoutParams adaptLayoutLine = new LinearLayout.LayoutParams(wPix, (int) ((int)hPix*.13));
		button.setLayoutParams(adaptLayoutLine);




		// event listener to handle call button when clicked
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent phoneIntent = new Intent(Intent.ACTION_CALL);
				phoneIntent.setData(Uri.parse("tel:6138515658"));

				try {
					startActivity(phoneIntent);
					finish();
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(ContactUs.this, 
							"Call faild, please try again later.", Toast.LENGTH_SHORT).show();
				}

			}
		});


		button=(Button) findViewById(R.id.btnEmail);
		adaptLayoutLine = new LinearLayout.LayoutParams(wPix, (int) ((int)hPix*.13));
		button.setLayoutParams(adaptLayoutLine);
		// event listener to handle email button when clicked
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				// call email client app that installed in android device
				String[] email = new String[]{"jaymehta197@gmail.com"};
				Intent iSend = new Intent(Intent.ACTION_SEND);
				iSend.putExtra(Intent.EXTRA_EMAIL, email);
				iSend.putExtra(Intent.EXTRA_SUBJECT, "");
				iSend.setType("plain/text");
				iSend.putExtra(Intent.EXTRA_TEXT, "");
				startActivity(iSend);
			}
		});

		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
				Intent intent=new Intent(v.getContext(), MainActivity.class);
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


