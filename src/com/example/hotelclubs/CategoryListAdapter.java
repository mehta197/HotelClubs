package com.example.hotelclubs;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// adapter class for custom category list
public class CategoryListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<String> contentDescription;
	private ArrayList<Integer> imagePostion;
	private ArrayList<String> subNumbers;



	public CategoryListAdapter(Activity activity,ArrayList<String>stringsList,ArrayList<Integer> integersList,ArrayList<String>subNumbers)
	{
		super();
		this.activity=activity;
		this.contentDescription=stringsList;
		this.imagePostion=integersList;
		this.subNumbers=subNumbers;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return contentDescription.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position,  View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;

		if(convertView == null){
			LayoutInflater inflator = activity.getLayoutInflater();
			convertView = inflator.inflate(R.layout.list_cat, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtText = (TextView) convertView.findViewById(R.id.txtViewListSub);
		holder.txtSubText = (TextView) convertView.findViewById(R.id.SubtextView);
		holder.imgThumb = (ImageView) convertView.findViewById(R.id.imagViewSub);
		holder.imgNext = (ImageView) convertView.findViewById(R.id.nextNav);
		holder.txtText.setText(this.contentDescription.get(position));
		holder.txtSubText.setText(this.subNumbers.get(position));
		holder.imgThumb.setImageResource(this.imagePostion.get(0));
		holder.imgNext.setImageResource(R.drawable.select_icon_brown);

		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				holder.txtText.setTextColor(Color.parseColor("#FFFFFF"));
				holder.txtSubText.setTextColor(Color.parseColor("#000000"));
				holder.imgThumb.setImageResource(R.drawable.category_icon_selected);
				holder.imgNext.setImageResource(R.drawable.nav_next);
				v.setBackgroundResource(R.drawable.bg_1);
				Intent intent=new Intent(v.getContext(),ItemDetails.class);
				((Activity) activity).startActivity(intent);
				activity.finish();
			}
		});

		return convertView;
	}
	static class ViewHolder {
		TextView txtText;
		TextView txtSubText;
		ImageView imgThumb;
		ImageView imgNext;
	}



}
