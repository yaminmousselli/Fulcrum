package com.example.christhai.fulcrum;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/** Represents the social trends page.
 * @author Team All-Star
 * @version 1.0
*/
public class SocialTrendsActivity extends BaseActivity {

    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_trends);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_social_trends);
        super.onResume();
        super.getToolbar().setTitle("Social Trends");
        GraphView overallWellnessGraph = (GraphView) findViewById(R.id.socialWellnessGraph);
        LineGraphSeries<DataPoint> overallWellnessSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 2),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 3),
                new DataPoint(4, 5),
                new DataPoint(5, 5),
                new DataPoint(6, 6)
        });
        overallWellnessGraph.getViewport().setXAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinX(-0.5);
        overallWellnessGraph.getViewport().setMaxX(6.5);
        overallWellnessGraph.getViewport().setYAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinY(-0.5);
        overallWellnessGraph.getViewport().setMaxY(10.5);
        overallWellnessSeries.setColor(Color.rgb(135, 206, 235));

        StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(overallWellnessGraph);
        staticLabelsFormatter1.setHorizontalLabels(new String[] {"","","", "11/23 - 11/29", "", "", ""});
        staticLabelsFormatter1.setViewport(overallWellnessGraph.getViewport());
        overallWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);

        overallWellnessGraph.addSeries(overallWellnessSeries);
    }
}