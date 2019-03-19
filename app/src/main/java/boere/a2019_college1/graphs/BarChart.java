package boere.a2019_college1.graphs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import boere.a2019_college1.R;

public class BarChart extends AppCompatActivity {
    private CombinedChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        mChart = (CombinedChart) findViewById(R.id.chart);
        //  mChart.setDescription("lala")

        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });

        setData();
    }

    private void setData(){
        LineData line = new LineData();
        ArrayList<Entry> lineEntries = new ArrayList<>();
        for (int i = 0; i<10; i++){
            lineEntries.add(new Entry((float) Math.random() * 15, i));
        }
        LineDataSet lineDataSet = new LineDataSet(lineEntries,"Line DataSet");
        line.addDataSet(lineDataSet);

        BarData bar = new BarData();
        ArrayList<BarEntry> barEntries = new ArrayList<BarEntry>();
        for (int i=0;i<10;i++) {
            barEntries.add(new BarEntry((float) Math.random()*15, i));
        }
        BarDataSet set = new BarDataSet(barEntries, "Bar DataSet");
        bar.addDataSet(set);

        // ADD data to the chart
        //String[] xValues = {"x1","x2","x3","x4","x5","x6","x7","x8","x9","x10"};
        CombinedData data = new CombinedData();
        //data.setData(xValues);
        data.setData(line);
        data.setData(bar);
        mChart.setData(data);
        mChart.invalidate();
    }

}

