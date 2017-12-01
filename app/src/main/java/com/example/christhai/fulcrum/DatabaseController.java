package com.example.christhai.fulcrum;

import android.util.Log;

import com.example.christhai.fulcrum.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by ChrisThai on 11/26/2017.
 */

public class DatabaseController {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    public DatabaseController() {

    }
    public void testPushUser() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        User test = new User("Chris", "Thai", "Christian.thai3@gmail.com","66", "155", 1 ,"Answer");
        String email = encodeEmail(test.getEmail());
        Date currentDate = Calendar.getInstance().getTime();
        String date = sdf.format(currentDate);
        ArrayList<Integer> score = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            score.add(-1);
        }
        mDatabase.child("test").child(email).setValue(test);
        System.out.println("DEBUG STATEMENT" + date);
        mDatabase.child("test").child(email).child(date).setValue(score);
        mDatabase.goOffline();
    }
    public void pushUser(User user)  {
        mDatabase  = FirebaseDatabase.getInstance().getReference();
        String email = encodeEmail(user.getEmail());
        mDatabase.child("Users").child(email).setValue(user);
        mDatabase.goOffline();
    }

    public void pushScores(AssessmentController ac, boolean complete) {
        ArrayList<Integer>scores = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            scores.add(ac.getScores(i));
        }
        Date currentDate = Calendar.getInstance().getTime();
        String date = sdf.format(currentDate);
        System.out.println("DATE IS" + date);
        Integer academicScore = calcAcademic(scores);
        Integer emotionalScore = calcEmotional(scores);
        Integer physicalScore = calcPhysical(scores);
        Integer socialScore = calcSocial(scores);
        Score score = new Score(scores, currentDate, academicScore,
                emotionalScore, physicalScore, socialScore);
        score.setComplete(complete);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        email = encodeEmail(email);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Users").child(email).child(date).setValue(score);
    }

    public boolean checkComplete() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        email = encodeEmail(email);
        Date currentDate = Calendar.getInstance().getTime();
        final String date = sdf.format(currentDate);

        final DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(email).child(date);
        final Score result = new Score();
        result.setComplete(false);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() > 0) {
                    Score score = dataSnapshot.getValue(Score.class);
                    if (score.isComplete()) {
                        result.setComplete(true);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("ERROR ERROR");
            }
        });

        return result.isComplete();
    }

    public void readScore(final AssessmentController AC) {
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
                    AC.setList(score.getScores());
                    System.out.println("Scores are " + score.getScores().toString());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "readScore:onCancelled", databaseError.toException());
            }
        });

    }
    private String encodeEmail(String email) {
        return email.replaceAll("\\.", ",");
    }

    private String decodeEmail(String email) {
        return email.replace("\\,", ".");
    }

    private Integer calcAcademic(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 3; i < 6; i++) {
            sum += score.get(i);
        }
        double normal = (sum/12);
        sum = (int) (normal*10);
        System.out.println("Academic Score is" + sum);
        int result = (int) sum;
        return result;
    }

    private Integer calcEmotional(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += score.get(i);
            System.out.println("New Sum is " + sum);
        }
        double normal = (sum/12);
        System.out.println(normal);
        sum = (int) (normal*10);
        System.out.println("Academic Score is" + sum);
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
        System.out.println("Academic Score is" + sum);
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
        System.out.println("Academic Score is" + sum);
        int result = (int) sum;
        return result;
    }
}
