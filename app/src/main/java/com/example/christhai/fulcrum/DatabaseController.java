package com.example.christhai.fulcrum;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import com.example.christhai.fulcrum.User;
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


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

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

    public void pushUser(User user)  {
        mDatabase  = FirebaseDatabase.getInstance().getReference();
        String email = encodeEmail(user.getEmail());
        mDatabase.child("Users").child(email).setValue(user);
        DatabaseReference.goOffline();
    }

    public void pushScores(AssessmentController ac, boolean complete) {
        ArrayList<Integer>scores = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            scores.add(ac.getScores(i));
        }
        Date currentDate = Calendar.getInstance().getTime();
        String date = sdf.format(currentDate);
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
        int result = (int) sum;
        return result;
    }

    private Integer calcEmotional(ArrayList<Integer> score) {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += score.get(i);
        }
        double normal = (sum/12);
        System.out.println(normal);
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
}
