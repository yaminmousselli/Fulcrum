package com.example.christhai.fulcrum;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/** Represents the physical trends page.
 * @author Team All-Star
 * @version 1.0
*/
public class PhysicalTrendsActivity extends BaseActivity {

    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_trends);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_physical_trends);
        super.onResume();
        super.getToolbar().setTitle("Physical Trends");
        GraphView overallWellnessGraph = (GraphView) findViewById(R.id.physicalWellnessGraph);
        LineGraphSeries<DataPoint> overallWellnessSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 1),
                new DataPoint(5, 4),
                new DataPoint(6, 2)
        });
        overallWellnessGraph.getViewport().setXAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinX(-0.5);
        overallWellnessGraph.getViewport().setMaxX(6.5);
        overallWellnessGraph.getViewport().setYAxisBoundsManual(true);
        overallWellnessGraph.getViewport().setMinY(-0.5);
        overallWellnessGraph.getViewport().setMaxY(10.5);
        overallWellnessSeries.setColor(Color.rgb(255, 242, 0));

        StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(overallWellnessGraph);
        //Have 8 strings below for seven data points to center the text
        staticLabelsFormatter1.setHorizontalLabels(new String[]{"", "", "", "Scores over last 7 days", "", "", "", ""});
        staticLabelsFormatter1.setViewport(overallWellnessGraph.getViewport());
        overallWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);

        overallWellnessGraph.addSeries(overallWellnessSeries);
    }
    private void getParcel() {
        Intent b = getIntent();

        if (b.getParcelableExtra("score") != null) {
            score = b.getParcelableExtra("score");

        }
    }
}
