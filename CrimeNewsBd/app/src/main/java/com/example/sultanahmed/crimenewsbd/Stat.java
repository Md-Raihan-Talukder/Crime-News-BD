package com.example.sultanahmed.crimenewsbd;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Stat extends AppCompatActivity {

    public static String[] division = {"Dhaka","Khulna","Barisal","Shylet","Rajshahi","Rangpur","Chittagong","Mymensingh"};
    int p=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        getSupportActionBar().setTitle("STATISTICS");

        ListView lv = (ListView) findViewById(R.id.listView);

        ArrayList<BarData> list = new ArrayList<>();

        for(int i = 0; i<8 ;i++){
            p=i;
            list.add(generateData(i+1));
        }

        ChartDataAdapter chartDataAdapter = new ChartDataAdapter(getApplicationContext(),list);
        lv.setAdapter(chartDataAdapter);
    }

    private class ChartDataAdapter extends ArrayAdapter<BarData>{
        public ChartDataAdapter(Context context, List<BarData> objects){
            super(context, 0 ,objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            BarData data = getItem(position);

            ViewHolder holder = null;

            if(convertView == null){
                holder = new ViewHolder();

                convertView = getLayoutInflater().from(getContext()).inflate(R.layout.list_item_barchart,null);
                holder.chart = (BarChart) convertView.findViewById(R.id.chart);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }

            data.setValueTextColor(Color.BLACK);
            holder.chart.getDescription().setEnabled(false);
            holder.chart.setDrawGridBackground(false);

            XAxis xAxis = holder.chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);

            YAxis leftAxis = holder.chart.getAxisLeft();
            leftAxis.setLabelCount(5, false);
            leftAxis.setSpaceTop(15f);

            YAxis rightAxis = holder.chart.getAxisRight();
            rightAxis.setLabelCount(5, false);
            rightAxis.setSpaceTop(15f);

            holder.chart.setData(data);
            holder.chart.setFitBars(true);

            holder.chart.animateY(500);

            return convertView;


        }

        private class ViewHolder{
            BarChart chart;
        }
    }

    private BarData generateData(int count){
        ArrayList<BarEntry> entries = new ArrayList<>();

        for(int i=0; i<10; i++){
            entries.add(new BarEntry(i, (float)(Math.random()*70)+30));
        }

        BarDataSet dataSet = new BarDataSet(entries, "" + division[p]);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setBarShadowColor(Color.rgb(203,203,203));

        BarData data = new BarData(dataSet);
        data.setBarWidth(0.9f);
        return data;
    }


}
