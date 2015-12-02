package utils;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<String> {
	private Context mContext;
	private ArrayList<String> mStringArray;
	private String[] mString = null;

	public SpinnerAdapter(Context context, String[] arrayList) {
		super(context, android.R.layout.simple_spinner_item, arrayList);
		mContext = context;
		mString = arrayList;
	}

	public SpinnerAdapter(Context context, ArrayList<String> arrayList) {
		super(context, android.R.layout.simple_spinner_item, arrayList);
		mContext = context;
		mStringArray = arrayList;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// ÐÞ¸ÄSpinnerÕ¹¿ªºóµÄ×ÖÌåÑÕÉ«
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(
					android.R.layout.simple_spinner_dropdown_item, parent,
					false);
		}

		// ´Ë´¦text1ÊÇSpinnerÄ¬ÈÏµÄÓÃÀ´ÏÔÊ¾ÎÄ×ÖµÄTextView
		TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
		if (mString == null) {
			tv.setText(mStringArray.get(position));
		} else {
			tv.setText(mString[position]);
		}

		tv.setTextSize(22f);
		tv.setTextColor(Color.RED);

		return convertView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ÐÞ¸ÄSpinnerÑ¡Ôñºó½á¹ûµÄ×ÖÌåÑÕÉ«
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(
					android.R.layout.simple_spinner_item, parent, false);
		}

		// ´Ë´¦text1ÊÇSpinnerÄ¬ÈÏµÄÓÃÀ´ÏÔÊ¾ÎÄ×ÖµÄTextView
		TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
		// tv.setText(mStringArray[position]);
		if (mString == null) {
			tv.setText(mStringArray.get(position));
		} else {
			tv.setText(mString[position]);
		}
		tv.setTextSize(18f);
		tv.setTextColor(Color.BLUE);
		return convertView;
	}
}
