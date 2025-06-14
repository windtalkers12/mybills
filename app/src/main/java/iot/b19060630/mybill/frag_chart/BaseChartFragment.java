package iot.b19060630.mybill.frag_chart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import iot.b19060630.mybill.R;
import iot.b19060630.mybill.adapter.ChartItemAdapter;
import iot.b19060630.mybill.database.ChartItemBean;
import iot.b19060630.mybill.database.DBManager;


public abstract class BaseChartFragment extends Fragment {
    ListView chartLv;
    public int year,month;
    List<ChartItemBean>mDatas;
    private ChartItemAdapter itemAdapter;
    BarChart barChart;
    TextView chartTv;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.fragment_incom_chart, container, false);
      chartLv=view.findViewById(R.id.frag_chart_lv);
      Bundle bundle=getArguments();
      year=bundle.getInt("year");
      month=bundle.getInt("month");
      mDatas=new ArrayList<>();
      itemAdapter=new ChartItemAdapter(getContext(),mDatas);
      chartLv.setAdapter(itemAdapter);

      addLVHeaderView();
      return view;
    }

    protected void addLVHeaderView(){
        View headerView=getLayoutInflater().inflate(R.layout.item_chartfrag_top, null);
        chartLv.addHeaderView(headerView);
        barChart =headerView.findViewById(R.id.item_chartfrag_chart);
        chartTv = headerView.findViewById(R.id.item_chartfrag_top_tv);
        barChart.getDescription().setEnabled(false);
        barChart.setExtraOffsets(20,20,20,20);
        setAxis(year,month);
        setAxisData(year,month);
    }

    protected abstract void setAxisData(int year, int month);


    protected  void setAxis(int year,int month){
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setLabelCount(31);
        xAxis.setTextSize(12f);

        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int val = (int) value;
                if (val == 0) {
                    return month + "-1";
                }
                if (val == 14) {
                    return month + "-15";
                }
                if (month == 2) {
                    if (val == 27) {
                        return month + "-28";
                    }
                } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (val == 30) {
                        return month + "-31";
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (val == 29) {
                        return month + "-30";
                    }
                }
                return ""; // 그 외 날짜는 표시하지 않음
            }
        });



        setYAxise(year,month);
    }
    protected abstract void setYAxise(int year,int month);
     public void setDate(int year,int month){
        this.year=year;
        this.month=month;
        barChart.clear();
        barChart.invalidate();
        setAxis(year,month);
        setAxisData(year,month);
     }



    void loadData(int year, int month, int kind) {
        List<ChartItemBean> list=DBManager.getChartListFromAccounttb(year, month, kind);
        mDatas.clear();
        mDatas.addAll(list);
        itemAdapter.notifyDataSetChanged();
    }
}