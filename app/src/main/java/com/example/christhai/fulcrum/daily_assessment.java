package com.example.christhai.fulcrum;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/** Represents the daily assessment page.
 * @author Team Atlas
 * @version 1.0
*/
public class daily_assessment extends AppCompatActivity {

    private AssessmentController AC = new AssessmentController();

    private TextView mQuestionView;
    private TextView mQuestionNumView;

    private RadioGroup mAnswers;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;
    private RadioButton mChoice5;

    private Button mNext;

    private int mQuestionNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_assessment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_daily_assessment);
        AC = new AssessmentController();

        mQuestionView = (TextView) findViewById(R.id.question);
        mQuestionNumView = (TextView) findViewById(R.id.questionNum);

        mAnswers = (RadioGroup) findViewById(R.id.answers);
        mChoice1 = (RadioButton) findViewById(R.id.answer1);
        mChoice2 = (RadioButton) findViewById(R.id.answer2);
        mChoice3 = (RadioButton) findViewById(R.id.answer3);
        mChoice4 = (RadioButton) findViewById(R.id.answer4);
        mChoice5 = (RadioButton) findViewById(R.id.answer5);

        mNext = (Button) findViewById(R.id.next);
        final Button mPrev = (Button) findViewById(R.id.prev);
        Button mSave = (Button) findViewById(R.id.save);

        getParcel();
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestionNum < 9) {
                    updateScores();
                    mQuestionNum++;
                    updateText();
                    mAnswers.clearCheck();
                    checkScores();
                } else if (mQuestionNum == 9) {
                    updateScores();
                    if (AC.checkComplete()) {
                        Bundle b = new Bundle();
                        Intent intent = new Intent();
                        b.putParcelable("AC", AC);
                        b.putInt("questionNum", mQuestionNum);
                        intent.putExtras(b);
                        intent.setClass(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestionNum > 0) {
                    if (mQuestionNum == 9) {
                        mNext.setText("Next");
                    }
                    updateScores();
                    mQuestionNum--;
                    updateText();
                    mAnswers.clearCheck();
                    checkScores();
                }
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScores();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("AC", AC);
                intent.putExtra("questionNum", mQuestionNum);
                startActivity(intent);
            }
        });
    }

    /**
     * Helper function to write new text.
     */
    private void updateText() {
        mQuestionView.setText(AC.getQuestions(mQuestionNum));
        String questionNum = (mQuestionNum + 1) + " out of 10";
        mQuestionNumView.setText(questionNum);
        mChoice1.setText(AC.getChoice1(mQuestionNum));
        mChoice2.setText(AC.getChoice2(mQuestionNum));
        mChoice3.setText(AC.getChoice3(mQuestionNum));
        mChoice4.setText(AC.getChoice4(mQuestionNum));
        mChoice5.setText(AC.getChoice5(mQuestionNum));
        if (mQuestionNum == 9) {
            mNext.setText("Submit");
        }
    }

    /**
     * Helper function to save current answer choice.
     */
    private void updateScores() {
        int choice = mAnswers.getCheckedRadioButtonId();
        AC.setScores(mQuestionNum, choice);
    }

    /**
     * Helper function to retrieve answer choice.
     */
    private void checkScores() {
        int choice = AC.getScores(mQuestionNum);
        mAnswers.check(choice);
    }

    /**
     * Helper function for AssessmentController persistence through activities.
     */
    private void getParcel() {
        Intent b = getIntent();
        if (b.getParcelableExtra("AC") != null) {
            AC = b.getParcelableExtra("AC");
            mQuestionNum = b.getIntExtra("questionNum", 0);
            checkScores();
            updateText();
        }
    }
}
