package com.example.hotelclubs;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class ReviewList extends BaseAdapter
{
	private Activity activity;
	private ArrayList<String> contentDescription; 
	private ArrayList<String> nameList;

	public ReviewList(Activity activity,ArrayList<String>stringsList,ArrayList<String> integersList)
	{
		super();
		this.activity=activity;
		this.contentDescription=stringsList;
		this.nameList=integersList;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contentDescription.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return contentDescription.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class ViewHolder{
		public TextView textDescriptionView;
		public TextView textNameView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		LayoutInflater inflator = activity.getLayoutInflater();
		if(convertView==null)
		{
			holder = new ViewHolder();
			convertView = inflator.inflate(R.layout.review_add, null);
			holder.textDescriptionView = (TextView) convertView.findViewById(R.id.review_description);
			holder.textNameView = (TextView) convertView.findViewById(R.id.review_name);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textNameView.setText(this.nameList.get(position));
		holder.textDescriptionView.setText(this.contentDescription.get(position));

		convertView.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				holder.textNameView.setTextColor(Color.WHITE);
				holder.textDescriptionView.setTextColor(Color.WHITE);
				v.setBackgroundColor(Color.parseColor("#FFA500"));
			}
		});
		return convertView;
	}

}
