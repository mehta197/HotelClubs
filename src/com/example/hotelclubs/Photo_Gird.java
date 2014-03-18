package com.example.hotelclubs;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Photo_Gird extends BaseAdapter
{
	private Activity activity;

	private ArrayList<Integer> photoNumberList;
	private int height;
	private int width;

	public Photo_Gird(Activity activity,ArrayList<Integer> photoNumberList, int wPix, int hPix)
	{
		super();
		this.activity=activity;
		width=wPix;
		height=hPix;
		this.photoNumberList=photoNumberList;
	}
	
	

	public Photo_Gird(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity=activity;
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return photoNumberList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return photoNumberList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class ViewHolder{
		public ImageView photos;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		LayoutInflater inflator = activity.getLayoutInflater();
		if(convertView==null)
		{
			
			holder = new ViewHolder();
			convertView = inflator.inflate(R.layout.gallery_icon, null);
			
			holder.photos=(ImageView) convertView.findViewById(R.id.gallery_icons);
			holder.photos.setLayoutParams(new RelativeLayout.LayoutParams((int)(width*.3),(int)(height*.3)));
			holder.photos.setScaleType(ImageView.ScaleType.CENTER_CROP);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.photos.setBackgroundResource(this.photoNumberList.get(position));
		
		return convertView;
	}

}
