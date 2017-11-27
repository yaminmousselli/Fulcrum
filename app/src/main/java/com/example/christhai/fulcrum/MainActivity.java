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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_main);
        super.onResume();
        Button mAssessment = (Button) findViewById(R.id.assessment);
        ImageView mComplete = (ImageView) findViewById(R.id.complete);
        AC = new AssessmentController();
        getParcel();


        Button overallWellness = (Button) findViewById(R.id.overall_trends);

        ImageButton academicBar = (ImageButton) findViewById(R.id.academic_bar);
        ImageButton emotionalBar = (ImageButton) findViewById(R.id.emotional_bar);
        ImageButton physicalBar = (ImageButton) findViewById(R.id.physical_bar);
        ImageButton socialBar = (ImageButton) findViewById(R.id.social_bar);

        ImageView academicIcon = (ImageView) findViewById(R.id.academic_icon);
        ImageView emotionalIcon = (ImageView) findViewById(R.id.emotional_icon);
        ImageView physicalIcon = (ImageView) findViewById(R.id.physical_icon);
        ImageView socialIcon = (ImageView) findViewById(R.id.social_icon);

        if (DC.checkComplete()) {
            mComplete.setVisibility(View.VISIBLE);
            mAssessment.setText("Complete!");
        } else {
            mComplete.setVisibility(View.INVISIBLE);
            mAssessment.setText("Daily Assessment");
        }

        mAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!DC.checkComplete()) {
                    Intent intent = new Intent(getApplicationContext(), daily_assessment.class);
//                    intent.putExtra("AC", AC);
//                    intent.putExtra("questionNum", mQuestionNum);
                    startActivity(intent);
                }
            }
        });

        overallWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OverallWellnessActivity.class);
                startActivity(intent);
            }
        });


        academicBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AcademicTrendsActivity.class);
                startActivity(intent);
            }
        });

        academicIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AcademicTrendsActivity.class);
                startActivity(intent);
            }
        });

        emotionalBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmotionalTrendsActivity.class);
                startActivity(intent);
            }
        });

        emotionalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmotionalTrendsActivity.class);
                startActivity(intent);
            }
        });

        physicalBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicalTrendsActivity.class);
                startActivity(intent);
            }
        });

        physicalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicalTrendsActivity.class);
                startActivity(intent);
            }
        });

        socialBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialTrendsActivity.class);
                startActivity(intent);
            }
        });

        socialIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialTrendsActivity.class);
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
    }


}
