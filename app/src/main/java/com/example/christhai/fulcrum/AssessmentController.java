package com.example.christhai.fulcrum;

import android.os.Parcel;
import android.os.Parcelable;

/** Represents the back end for the daily assessment page.
 * @author Team Atlas
 * @version 1.0
*/

public class AssessmentController implements Parcelable {
    private String questions [] = {"How well did you cope today?",
            "How did you feel today overall?", "How well do you love yourself today?",
            "How do you feel about your academic performance today?",
            "How stressed do you feel today?",
            "How satisfied were you with your academic productivity today?",
            "How satisfied are you with your physical activity today?",
            "How healthy do you feel today?", "Rate your social life today.",
            "How connected to others did you feel today?"};

    private String  choices [][] = {
            {"Not Coping", "Poorly", "Ok", "Well", "Very Well"},
            {"Terrible", "Bad", "Fair", "Good", "Fantastic"},
            {"Not at all", "Somewhat", "Fairly", "Well", "Completely"},
            {"Very Dissatisfied", "Dissatisfied", "Neutral", "Satisfied", "Very Satisfied"},
            {"Very Stressed", "Stressed", "Ok", "Somewhat Relaxed", "Relaxed"},
            {"Very Dissatisfied", "Dissatisfied", "Neutral", "Very Satisfied", "Satisfied"},
            {"Very Dissatisfied", "Dissatisfied", "Neutral", "Very Satisfied", "Satisfied"},
            {"Very Unhealthy", "Unhealthy", "Ok", "Healthy", "Very Healthy"},
            {"Very Dissatisfied", "Dissatisfied", "Neutral", "Very Satisfied", "Satisfied"},
            {"Distant", "Unconnected", "Ehh...", "Connected", "Very Connected"}
    };

    private int scores[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1 , -1};

    public AssessmentController() {
        for (int i = 0; i < 9; i++) {
            scores[i] = -1;
        }
    }
    public AssessmentController(Parcel in) {
        this.scores = in.createIntArray();
    }

    public String getQuestions(int a) {
        String q = questions[a];
        return q;
    }

    public String getChoice1(int a) {
        String choice = choices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = choices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = choices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = choices[a][3];
        return choice;
    }

    public String getChoice5(int a) {
        String choice = choices[a][4];
        return choice;
    }

    public int getScores(int a) {
        int choice = scores[a];
        return choice;
    }

    public void setScores(int a, int b) {
        scores[a] = b;
    }

    public boolean checkComplete() {
        int complete = 1;
        for (int i = 0; i < 10; i++) {
            int choice = scores[i];
            if (choice < 0) {
                complete = -1;
            }
        }
        return (complete > 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(scores);
    }

    public static final Parcelable.Creator<AssessmentController> CREATOR =
            new Creator<AssessmentController>() {

                @Override
                public AssessmentController createFromParcel(Parcel in) {
                    return new AssessmentController(in);
                }

                @Override
                public AssessmentController[] newArray(int size) {
                    return new AssessmentController[0];
                }
            };
}
