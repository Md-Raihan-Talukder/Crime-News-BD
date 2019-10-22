package com.example.sultanahmed.crimenewsbd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class NewsAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<NewsUnit> newsUnits;

    public NewsAdapter(){

    }

    public NewsAdapter(Activity activity, List<NewsUnit> newsUnits) {
        this.activity = activity;
        this.newsUnits = newsUnits;
    }

    @Override
    public int getCount() {
        return newsUnits.size();
    }

    @Override
    public Object getItem(int position) {
        return newsUnits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.news_list, null);
        }

        NewsUnit fu = newsUnits.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.news_list);
        TextView time=(TextView) convertView.findViewById(R.id.news_time);

        name.setText(fu.getTitle());
        time.setText(fu.getTime());

        return convertView;
    }
}
