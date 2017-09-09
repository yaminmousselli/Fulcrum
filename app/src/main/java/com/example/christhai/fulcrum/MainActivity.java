package com.example.christhai.fulcrum;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/** Represents the home page.
 * @author Team Atlas
 * @version 1.0
*/
public class MainActivity extends AppCompatActivity {


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
}
