package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

        if (AC.checkComplete()) {
            mComplete.setVisibility(View.VISIBLE);
        } else {
            mComplete.setVisibility(View.INVISIBLE);
        }

        mAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),daily_assessment.class);
                intent.putExtra("AC", AC);
                intent.putExtra("questionNum", mQuestionNum);
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
