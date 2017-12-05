package com.example.christhai.fulcrum;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.jjoe64.graphview.*;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import java.util.Calendar;
import java.util.Date;
import com.jjoe64.graphview.GridLabelRenderer;
import android.graphics.Color;

/** Represents the home page.
 * @author Team All-Star
 * @version 1.0
*/
public class MainActivity extends BaseActivity {


    private AssessmentController AC = new AssessmentController();
    private DatabaseController DC = new DatabaseController();
    private int mQuestionNum;
    private ExpandableListView submenu;
    private ExpandableListAdapter currAdapter;
    private Menu menu;
    private Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getParcel();
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_main);
        super.onResume();
        Button mAssessment = (Button) findViewById(R.id.assessment);
        ImageView mComplete = (ImageView) findViewById(R.id.complete);
        TextView mOverallScore = (TextView) findViewById(R.id.OverallScoresTextViewHomePage);
        AC = new AssessmentController();
        if (score.isComplete()) {
            GraphView overallWellnessGraph = (GraphView) findViewById(R.id.overallWellnessGraphHomePage);
            LineGraphSeries<DataPoint> overallWellnessSeries = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 20),
                    new DataPoint(1, 15),
                    new DataPoint(2, 33),
                    new DataPoint(3, 37),
                    new DataPoint(4, 27),
                    new DataPoint(5, 20),
                    new DataPoint(6, 16)
            });
            //overallWellnessGraph.getViewport().setXAxisBoundsManual(true);
            overallWellnessGraph.getViewport().setMinX(-0.5);
            overallWellnessGraph.getViewport().setMaxX(6.5);
            //overallWellnessGraph.getViewport().setYAxisBoundsManual(true);
            overallWellnessGraph.getViewport().setMinY(-1);
            overallWellnessGraph.getViewport().setMaxY(41);

            overallWellnessGraph.getViewport().setXAxisBoundsManual(true);
            overallWellnessGraph.getViewport().setYAxisBoundsManual(true);


            StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(overallWellnessGraph);
            staticLabelsFormatter1.setHorizontalLabels(new String[]{"", "", "", "11/23 - 11/29", "", "", ""});
            staticLabelsFormatter1.setViewport(overallWellnessGraph.getViewport());
            overallWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);
            //overallWellnessGraph.getGridLabelRenderer().setNumHorizontalLabels(6);
            //overallWellnessGraph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);

            overallWellnessGraph.addSeries(overallWellnessSeries);


            GraphView individualWellnessGraph = (GraphView) findViewById(R.id.individualWellnessGraphHomePage);
            BarGraphSeries<DataPoint> individualWellnessSeries = new BarGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 0),
                    new DataPoint(1, score.getScoreMap().get("academicScore")),
                    new DataPoint(2, score.getScoreMap().get("emotionalScore")),
                    new DataPoint(3, score.getScoreMap().get("physicalScore")),
                    new DataPoint(4, score.getScoreMap().get("socialScore"))
            });
            individualWellnessSeries.setSpacing(20);
            individualWellnessGraph.getViewport().setXAxisBoundsManual(true);
            individualWellnessGraph.getViewport().setMinX(0.5);
            individualWellnessGraph.getViewport().setMaxX(4.5);
            individualWellnessGraph.getViewport().setYAxisBoundsManual(true);
            individualWellnessGraph.getViewport().setMinY(-0.5);
            individualWellnessGraph.getViewport().setMaxY(10.5);
            StaticLabelsFormatter staticLabelsFormatter2 = new StaticLabelsFormatter(individualWellnessGraph);
            staticLabelsFormatter2.setHorizontalLabels(new String[]{"A", "E", "P", "S", "blah"});
            staticLabelsFormatter2.setViewport(individualWellnessGraph.getViewport());
            individualWellnessGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter2);

            individualWellnessSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
                    switch ((int) data.getX()) {
                        case 1:
                            return Color.rgb(115, 255, 0);
                        case 2:
                            return Color.rgb(204, 0, 0);
                        case 3:
                            return Color.rgb(255, 242, 0);
                        case 4:
                            return Color.rgb(135, 206, 235);

                    }
                    return 99;
                }
            });

            individualWellnessGraph.addSeries(individualWellnessSeries);
        }
        Button overallWellness = (Button) findViewById(R.id.overall_trends);

        ImageButton academicBar = (ImageButton) findViewById(R.id.academic_bar);
        ImageButton emotionalBar = (ImageButton) findViewById(R.id.emotional_bar);
        ImageButton physicalBar = (ImageButton) findViewById(R.id.physical_bar);
        ImageButton socialBar = (ImageButton) findViewById(R.id.social_bar);

        ImageView academicIcon = (ImageView) findViewById(R.id.academic_icon);
        ImageView emotionalIcon = (ImageView) findViewById(R.id.emotional_icon);
        ImageView physicalIcon = (ImageView) findViewById(R.id.physical_icon);
        ImageView socialIcon = (ImageView) findViewById(R.id.social_icon);

        if (score.isComplete()) {

            mComplete.setVisibility(View.VISIBLE);
            mAssessment.setText("Complete!");
        } else {
            mComplete.setVisibility(View.INVISIBLE);
            mAssessment.setText("Daily Assessment");
        }

            mAssessment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!score.isComplete() && score != null) {
                        Intent intent = new Intent(getApplicationContext(), daily_assessment.class);
                        intent.putExtra("AC", AC);
                        intent.putExtra("questionNum", mQuestionNum);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    }
                }
            });

            overallWellness.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), OverallWellnessActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            mOverallScore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), OverallWellnessActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });


            academicBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), AcademicTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            academicIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), AcademicTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            emotionalBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EmotionalTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            emotionalIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EmotionalTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            physicalBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), PhysicalTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            physicalIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), PhysicalTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            socialBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SocialTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });

            socialIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SocialTrendsActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            });
        }

    /**
     * Helper function for AssessmentController persistence through activities.
     */
    private void getParcel() {
        Intent b = getIntent();
        if (b.getParcelableExtra("AC") != null) {
            AC = b.getParcelableExtra("AC");
            mQuestionNum = b.getIntExtra("questionNum", 0);
        }

        if (b.getParcelableExtra("score") != null) {
            score = b.getParcelableExtra("score");
        } else {
            score.loadData();
        }
    }


}
