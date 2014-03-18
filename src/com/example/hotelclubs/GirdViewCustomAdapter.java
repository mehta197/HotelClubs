package com.example.hotelclubs;

import java.util.ArrayList;

import com.google.android.gms.internal.hp;

import android.app.Activity;
import android.net.wifi.WpsInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class GirdViewCustomAdapter extends BaseAdapter
{
	private Activity activity;
	private ArrayList<String> contentDescription; 
	private ArrayList<Integer> imagePostiont;
	private int height;
	private int weight;
	public GirdViewCustomAdapter(Activity activity,ArrayList<String>stringsList,ArrayList<Integer> integersList, int hPix, int wPix)
	{
		super();
		this.height=hPix;
		this.weight=wPix;
		this.activity=activity;
		this.contentDescription=stringsList;
		this.imagePostiont=integersList;
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
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		LayoutInflater inflator = activity.getLayoutInflater();
		if(convertView==null)
		{
			holder = new ViewHolder();
			convertView = inflator.inflate(R.layout.gird_view, null);
			holder.textView = (TextView) convertView.findViewById(R.id.textView1);
			holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
			if(position%2==1)
				convertView.setBackgroundColor(R.drawable.alt);
			
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(this.contentDescription.get(position));
		holder.imageView.setImageResource(this.imagePostiont.get(position));
		

		return convertView;
	}

}
