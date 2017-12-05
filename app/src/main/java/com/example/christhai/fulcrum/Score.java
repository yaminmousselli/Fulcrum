package com.example.christhai.fulcrum;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

import static android.content.ContentValues.TAG;

/**
 * Created by ChrisThai on 11/27/2017.
 */

public class Score implements Parcelable{
    private List<Integer> scores;
    private Date currentDate;
    private HashMap<String, Integer> scoreMap;
    private boolean complete = false;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public Score(){

    }

    public Score(List<Integer> scores, Date currentDate, HashMap<String, Integer> scoreMap, boolean complete) {
        this.scores = scores;
        this.currentDate = currentDate;
        this.scoreMap = scoreMap;
        this.complete = complete;
    }

    public Score(List<Integer> scores, Date currentDate, Integer academicScore,
                 Integer emotionalScore, Integer physicalScore, Integer socialScore) {
        this.scores = scores;
        this.currentDate = currentDate;
        scoreMap = new HashMap<String, Integer>();
        this.scoreMap.put("academicScore",academicScore);
        this.scoreMap.put("emotionalScore",emotionalScore);
        this.scoreMap.put("physicalScore",physicalScore);
        this.scoreMap.put("socialScore",socialScore);
    }

    public Score(int[] list, boolean complete) {
        ArrayList<Integer>scores = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            scores.add(list[i]);
        }
        Date currentDate = Calendar.getInstance().getTime();
        String date = sdf.format(currentDate);
        Integer academicScore = calcAcademic(scores);
        Integer emotionalScore = calcEmotional(scores);
        Integer physicalScore = calcPhysical(scores);
        Integer socialScore = calcSocial(scores);
        this.scores = scores;
        this.currentDate = currentDate;
        this.scoreMap = new HashMap<String, Integer>();
        this.scoreMap.put("academicScore",academicScore);
        this.scoreMap.put("emotionalScore",emotionalScore);
        this.scoreMap.put("physicalScore",physicalScore);
        this.scoreMap.put("socialScore",socialScore);
        this.complete = complete;

    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }


    public HashMap<String, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(HashMap<String, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void loadData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        email = encodeEmail(email);
        final Date currentDate = Calendar.getInstance().getTime();
        final String date = sdf.format(currentDate);
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(email).child(date);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    Score score = dataSnapshot.getValue(Score.class);
                    Score.this.scores = score.getScores();
                    Score.this.currentDate = score.getCurrentDate();
                    Score.this.scoreMap  = score.getScoreMap();
                    Score.this.complete = score.isComplete();
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int i = 0; i < 10; i++) {
                        list.add(2);
                    }
                    Score.this.scores = list;
                }

                System.out.println(Score.this.scores);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "readScore:onCancelled", databaseError.toException());
            }

        });
    }

    private Integer calcAcademic(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 3; i < 6; i++) {
            sum += score.get(i);
        }
        double normal = (sum/12);
        sum = (int) (normal*10);
        int result = (int) sum;
        return result;
    }

    private Integer calcEmotional(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += score.get(i);
        }
        double normal = (sum/12);
        sum = (int) (normal*10);
        int result = (int) sum;
        return result;
    }

    private Integer calcPhysical(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 6; i < 8; i++) {
            sum += score.get(i);
        }
        double normal = (sum/8);
        sum = (int) (normal*10);
        int result = (int) sum;
        return result;
    }

    private Integer calcSocial(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 8; i < 10; i++) {
            sum += score.get(i);
        }
        double normal =(sum/8);
        sum = (int) (normal*10);
        int result = (int) sum;
        return result;
    }

    private String encodeEmail(String email) {
        return email.replaceAll("\\.", ",");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.scores);
        dest.writeLong(this.currentDate != null ? this.currentDate.getTime() : -1);
        dest.writeSerializable(this.scoreMap);
        dest.writeByte(this.complete ? (byte) 1 : (byte) 0);
        dest.writeSerializable(this.sdf);
    }

    protected Score(Parcel in) {
        this.scores = new ArrayList<Integer>();
        in.readList(this.scores, Integer.class.getClassLoader());
        long tmpCurrentDate = in.readLong();
        this.currentDate = tmpCurrentDate == -1 ? null : new Date(tmpCurrentDate);
        this.scoreMap = (HashMap<String, Integer>) in.readSerializable();
        this.complete = in.readByte() != 0;
        this.sdf = (SimpleDateFormat) in.readSerializable();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel source) {
            return new Score(source);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };
}
