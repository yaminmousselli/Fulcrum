package com.example.christhai.fulcrum;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/** Represents the emotional trends page.
 * @author Team Atlas
 * @version 1.0
*/

public class EmotionalTrendsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotional_trends);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_emotional_trends);
        super.onResume();
        super.getToolbar().setTitle("Emotional Trends");
        GraphView overallWellnessGraph = (GraphView) findViewById(R.id.emotionalWellnessGraph);
        LineGraphSeries<DataPoint> overallWellnessSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 8),
                new DataPoint(1, 7),
                new DataPoint(2, 8),
                new DataPoint(3, 5),
                new DataPoint(4, 6),
                new DataPoint(5, 4),
                new DataPoint(6, 3)
        });
        overallWellnessGraph.getViewport().setXAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinX(-0.5);
        overallWellnessGraph.getViewport().setMaxX(6.5);
        overallWellnessGraph.getViewport().setYAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinY(-0.5);
        overallWellnessGraph.getViewport().setMaxY(10.5);
        overallWellnessSeries.setColor(Color.rgb(204, 0, 0));

        StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(overallWellnessGraph);
        staticLabelsFormatter1.setHorizontalLabels(new String[] {"","","", "11/22 - 11/28", "", "", ""});
        staticLabelsFormatter1.setViewport(overallWellnessGraph.getViewport());
        overallWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);

        overallWellnessGraph.addSeries(overallWellnessSeries);
    }
}
