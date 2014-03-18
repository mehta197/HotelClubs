package com.example.hotelclubs;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.loading_screen);

		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				Intent main=new Intent().setClass(SplashScreen.this,MainActivity.class);
				startActivity(main);
			}
		};
		Timer t=new Timer();
		t.schedule(task,1000);
	}
}
