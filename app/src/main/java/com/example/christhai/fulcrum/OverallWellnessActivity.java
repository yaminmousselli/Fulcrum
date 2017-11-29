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

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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


        GraphView individualWellnessGraph = (GraphView) findViewById(R.id.overallWellnessGraph);
        individualWellnessGraph.setTitle("Score: 16/40");
        BarGraphSeries<DataPoint> individualWellnessSeries = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
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
    }


}

