package com.example.christhai.fulcrum;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.DatePicker;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;

/** Represents the overall wellness trends page.
 * @author Team Atlas
 * @version 1.0
*/

public class OverallWellnessActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_wellness);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_overall_wellness);
        super.onResume();
        super.getToolbar().setTitle("Overall Wellness");


        DatePicker datePicker = (DatePicker) findViewById(R.id.overall_wellness_date_picker);
        final int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        /*datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                //Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                if(day == 28) {

                } else if (day == 27) {

                } else if (day == 26) {

                }
            }
        }); */



        final GraphView individualWellnessGraph = (GraphView) findViewById(R.id.overallWellnessGraph);
        individualWellnessGraph.setTitle("Score: 15/40");
        final BarGraphSeries<DataPoint> individualWellnessSeries = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 9),
                new DataPoint(2, 2),
                new DataPoint(3, 3),
                new DataPoint(4, 1)
        });
        individualWellnessSeries.setSpacing(20);
        individualWellnessGraph.getViewport().setXAxisBoundsManual(true);
        individualWellnessGraph.getViewport().setMinX(0.5);
        individualWellnessGraph.getViewport().setMaxX(4.5);
        individualWellnessGraph.getViewport().setYAxisBoundsManual(true);
        individualWellnessGraph.getViewport().setMinY(-0.5);
        individualWellnessGraph.getViewport().setMaxY(10.5);
        StaticLabelsFormatter staticLabelsFormatter2 = new StaticLabelsFormatter(individualWellnessGraph);
        staticLabelsFormatter2.setHorizontalLabels(new String[] {"A","E","P", "S", "blah"});
        staticLabelsFormatter2.setViewport(individualWellnessGraph.getViewport());
        individualWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter2);

        individualWellnessSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                switch ((int)data.getX()) {
                    case 1:  return Color.rgb(115, 255, 0);
                    case 2:  return Color.rgb(204, 0, 0);
                    case 3:  return Color.rgb(255, 242, 0);
                    case 4:  return Color.rgb(135, 206, 235);

                }
                return 99;
            }
        });

        individualWellnessGraph.addSeries(individualWellnessSeries);


        final BarGraphSeries<DataPoint> individualWellnessSeries2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 7),
                new DataPoint(2, 3),
                new DataPoint(3, 4),
                new DataPoint(4, 4)
        });
        individualWellnessSeries2.setSpacing(20);

        individualWellnessSeries2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                switch ((int)data.getX()) {
                    case 1:  return Color.rgb(115, 255, 0);
                    case 2:  return Color.rgb(204, 0, 0);
                    case 3:  return Color.rgb(255, 242, 0);
                    case 4:  return Color.rgb(135, 206, 235);

                }
                return 99;
            }
        });


        final BarGraphSeries<DataPoint> individualWellnessSeries3 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 5),
                new DataPoint(2, 5),
                new DataPoint(3, 6),
                new DataPoint(4, 7)
        });
        individualWellnessSeries3.setSpacing(20);

        individualWellnessSeries3.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                switch ((int)data.getX()) {
                    case 1:  return Color.rgb(115, 255, 0);
                    case 2:  return Color.rgb(204, 0, 0);
                    case 3:  return Color.rgb(255, 242, 0);
                    case 4:  return Color.rgb(135, 206, 235);

                }
                return 99;
            }
        });


        final BarGraphSeries<DataPoint> individualWellnessSeries4 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 4),
                new DataPoint(2, 7),
                new DataPoint(3, 8),
                new DataPoint(4, 9)
        });
        individualWellnessSeries4.setSpacing(20);

        individualWellnessSeries4.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                switch ((int)data.getX()) {
                    case 1:  return Color.rgb(115, 255, 0);
                    case 2:  return Color.rgb(204, 0, 0);
                    case 3:  return Color.rgb(255, 242, 0);
                    case 4:  return Color.rgb(135, 206, 235);

                }
                return 99;
            }
        });

        //individualWellnessGraph.removeAllSeries();
        //individualWellnessGraph.addSeries(individualWellnessSeries2);


        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                //Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                if(datePicker.getDayOfMonth() == 29) {
                    individualWellnessGraph.removeAllSeries();
                    individualWellnessGraph.addSeries(individualWellnessSeries);
                    individualWellnessGraph.setTitle("Score: 15/40");
                } else if (datePicker.getDayOfMonth() == 28) {
                    individualWellnessGraph.removeAllSeries();
                    individualWellnessGraph.addSeries(individualWellnessSeries2);
                    individualWellnessGraph.setTitle("Score: 18/40");
                } else if (datePicker.getDayOfMonth() == 27) {
                    individualWellnessGraph.removeAllSeries();
                    individualWellnessGraph.addSeries(individualWellnessSeries3);
                    individualWellnessGraph.setTitle("Score: 23/40");
                } else if (datePicker.getDayOfMonth() == 26) {
                    individualWellnessGraph.removeAllSeries();
                    individualWellnessGraph.addSeries(individualWellnessSeries4);
                    individualWellnessGraph.setTitle("Score: 28/40");
                } else {
                    individualWellnessGraph.removeAllSeries();
                    individualWellnessGraph.setTitle("Score: N/A");
                }
            }
        });
    }


}

