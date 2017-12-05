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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.R.attr.data;

/** Represents the overall wellness trends page.
 * @author Team All-Star
 * @version 1.0
*/

public class OverallWellnessActivity extends BaseActivity {

    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_wellness);
        getParcel();
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
        final BarGraphSeries<DataPoint> individualWellnessSeries = new BarGraphSeries<>(new DataPoint[]{
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


        final BarGraphSeries<DataPoint> individualWellnessSeries2 = new BarGraphSeries<>(new DataPoint[]{
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


        final BarGraphSeries<DataPoint> individualWellnessSeries3 = new BarGraphSeries<>(new DataPoint[]{
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


        final BarGraphSeries<DataPoint> individualWellnessSeries4 = new BarGraphSeries<>(new DataPoint[]{
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

        //individualWellnessGraph.removeAllSeries();
        //individualWellnessGraph.addSeries(individualWellnessSeries2);


        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                //Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String email = user.getEmail();
                email = encodeEmail(email);
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date currentDate = calendar.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                String date = sdf.format(currentDate);
                System.out.println("The Date is " + date);
                DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference()
                        .child("Users").child(email).child(date);
                mDatabaseReference.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final GraphView individualWellnessGraph = (GraphView) findViewById(R.id.overallWellnessGraph);
                        int academic = 0;
                        int emotional = 0;
                        int physical = 0;
                        int social = 0;
                        if (dataSnapshot.getChildrenCount() > 0) {

                            Score score = dataSnapshot.getValue(Score.class);
                            HashMap<String, Integer> scoreMap = score.getScoreMap();
                            academic = scoreMap.get("academicScore");
                            emotional = scoreMap.get("emotionalScore");
                            physical = scoreMap.get("physicalScore");
                            social = scoreMap.get("socialScore");
                        }
                        int sum = academic + emotional + physical + social;
                        individualWellnessGraph.setTitle("Score:" + sum + "/40");
                        final BarGraphSeries<DataPoint> individualWellnessSeries = new BarGraphSeries<>(new DataPoint[]{
                                new DataPoint(0, 0),
                                new DataPoint(1, academic),
                                new DataPoint(2, emotional),
                                new DataPoint(3, physical),
                                new DataPoint(4, social)
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
                        individualWellnessGraph.removeAllSeries();
                        individualWellnessGraph.addSeries(individualWellnessSeries);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
            }


            private String encodeEmail(String email) {
                return email.replaceAll("\\.", ",");
            }
        });

    }

    private void getParcel() {
        Intent b = getIntent();

        if (b.getParcelableExtra("score") != null) {
            score = b.getParcelableExtra("score");

        }
    }
}