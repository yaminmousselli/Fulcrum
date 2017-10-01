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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/** Represents the home page.
 * @author Team Atlas
 * @version 1.0
*/
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private AssessmentController AC = new AssessmentController();
    private int mQuestionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Button mAssessment = (Button) findViewById(R.id.assessment);
        ImageView mComplete = (ImageView) findViewById(R.id.complete);
        AC = new AssessmentController();
        getParcel();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button overallWellness = (Button) findViewById(R.id.overall_trends);
        Button settings = (Button) findViewById(R.id.settings_temp);

        ImageButton academicBar = (ImageButton) findViewById(R.id.academic_bar);
        ImageButton emotionalBar = (ImageButton) findViewById(R.id.emotional_bar);
        ImageButton physicalBar = (ImageButton) findViewById(R.id.physical_bar);
        ImageButton socialBar = (ImageButton) findViewById(R.id.social_bar);

        TextView academicText = (TextView) findViewById(R.id.academic_trend);
        TextView emotionalText = (TextView) findViewById(R.id.emotional_trend);
        TextView physicalText = (TextView) findViewById(R.id.physical_trend);
        TextView socialText = (TextView) findViewById(R.id.social_trend);

        if (AC.checkComplete()) {
            mComplete.setVisibility(View.VISIBLE);
            mAssessment.setText("Complete!");
        } else {
            mComplete.setVisibility(View.INVISIBLE);
            mAssessment.setText("Daily Assessment");
        }

        mAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AC.checkComplete()) {
                    Intent intent = new Intent(getApplicationContext(), daily_assessment.class);
                    intent.putExtra("AC", AC);
                    intent.putExtra("questionNum", mQuestionNum);
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

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
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

        academicText.setOnClickListener(new View.OnClickListener() {
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

        emotionalText.setOnClickListener(new View.OnClickListener() {
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

        physicalText.setOnClickListener(new View.OnClickListener() {
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

        socialText.setOnClickListener(new View.OnClickListener() {
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
    //Below are methods for the Toolbar.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_daily_assessment:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_overall_wellness:
                intent = new Intent(getApplicationContext(), OverallWellnessActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_settings:
                intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_help_feedback:
                intent = new Intent(getApplicationContext(), HelpFeedbackActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_current_trends:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
        }
    }

}
