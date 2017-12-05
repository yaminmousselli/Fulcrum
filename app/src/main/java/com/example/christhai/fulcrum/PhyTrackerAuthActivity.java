package com.example.christhai.fulcrum;

import android.content.Intent;
import android.content.IntentSender;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.result.DailyTotalResult;

import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import static android.R.attr.value;

public class PhyTrackerAuthActivity extends AppCompatActivity implements OnDataPointListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_OAUTH = 1;
    private static final String AUTH_PENDING = "auth_state_pending";
    private boolean authInProgress = false;
    private GoogleApiClient mApiClient;

    private TextView numSteps;
    private TextView numCalories;
    private TextView physicalScore;

    private boolean stepsRetrieved = false;
    private boolean calRetrieved = false;

    private int steps;
    private float cals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phy_tracker_auth);

        if (savedInstanceState != null) {
            authInProgress = savedInstanceState.getBoolean(AUTH_PENDING);
        }

        mApiClient = new GoogleApiClient.Builder(this)
                .addApi(Fitness.HISTORY_API)
                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
                .addConnectionCallbacks(this)
                .enableAutoManage(this, 0, this)
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_phy_tracker_auth);

        Button stepsButton = (Button) findViewById(R.id.getStepsButton);
        Button caloriesButton = (Button) findViewById(R.id.getCaloriesButton);

        //TextView numSteps = (TextView) findViewById(R.id.numSteps);
        //TextView numCalories = (TextView) findViewById(R.id.numCalories);

        numSteps = (TextView) findViewById(R.id.numSteps);
        numCalories = (TextView) findViewById(R.id.numCalories);
        physicalScore = (TextView) findViewById(R.id.calculatedScore);

        //steps = 0;
        //cals = 0;
        stepsRetrieved = false;
        calRetrieved = false;

        stepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //numSteps.setText(displayStepDataForToday());
                //displayStepDataForToday();
                new ViewTodaysStepCountTask().execute();
                //numSteps.setText("7593");
            }
        });

        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ViewTodaysCalCountTask().execute();

                //numCalories.setText("1500");
            }
        });

        //physicalScore.setText("8");
    }
    @Override
    protected void onStart() {
        super.onStart();
        mApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.e("HistoryAPI", "onConnected");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.e("HistoryAPI", "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if( !authInProgress ) {
            try {
                authInProgress = true;
                connectionResult.startResolutionForResult( PhyTrackerAuthActivity.this, REQUEST_OAUTH );
            } catch(IntentSender.SendIntentException e ) {

            }
        } else {
            Log.e( "GoogleFit", "authInProgress" );
        }
    }

    @Override
    public void onDataPoint(DataPoint dataPoint) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == REQUEST_OAUTH ) {
            authInProgress = false;
            if( resultCode == RESULT_OK ) {
                if( !mApiClient.isConnecting() && !mApiClient.isConnected() ) {
                    mApiClient.connect();
                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    //displayStepDataForToday();
                }
            } else if( resultCode == RESULT_CANCELED ) {
                Log.e( "GoogleFit", "RESULT_CANCELED" );
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(intent);
            }
        } else {
            Log.e("GoogleFit", "requestCode NOT request_oauth");
        }
    }

    private void showDataSet(DataSet dataSet) {
        Log.e("History", "Data returned for Data type: " + dataSet.getDataType().getName() + "DataSet size: " + dataSet.getDataPoints().size());
        DateFormat dateFormat = DateFormat.getDateInstance();
        DateFormat timeFormat = DateFormat.getTimeInstance();

        for (DataPoint dp : dataSet.getDataPoints()) {
            Log.e("History", "Data point:");
            Log.e("History", "\tType: " + dp.getDataType().getName());
            Log.e("History", "\tStart: " + dateFormat.format(dp.getStartTime(TimeUnit.MILLISECONDS)) + " " + timeFormat.format(dp.getStartTime(TimeUnit.MILLISECONDS)));
            Log.e("History", "\tEnd: " + dateFormat.format(dp.getEndTime(TimeUnit.MILLISECONDS)) + " " + timeFormat.format(dp.getEndTime(TimeUnit.MILLISECONDS)));
            for(Field field : dp.getDataType().getFields()) {
                Log.e("History", "\tField: " + field.getName() +
                        " Value: " + dp.getValue(field));
                numSteps.setText(dp.getValue(field).asInt());
            }
        }
    }

    private String displayStepDataForToday() {
        DailyTotalResult result = Fitness.HistoryApi.readDailyTotal( mApiClient, DataType.AGGREGATE_STEP_COUNT_DELTA ).await(1, TimeUnit.MINUTES);

        if (result.getStatus().isSuccess() && !result.getTotal().isEmpty()) {
            DataSet totalSet = result.getTotal();
            Log.e("History", "Steps Data returned for Data type: " + totalSet.getDataType().getName() + "DataSet size: " + totalSet.getDataPoints().size() + "Num steps: " + totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS));
            return totalSet.isEmpty() ? "-1" : totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt() + "";
        }
        //Toast.makeText(getApplicationContext(), "Steps: " + " Value: ", Toast.LENGTH_SHORT).show();

        showDataSet(result.getTotal());
        return "-1";
    }

    private String displayCalDataForToday() {
        DailyTotalResult result = Fitness.HistoryApi.readDailyTotal( mApiClient, DataType.AGGREGATE_CALORIES_EXPENDED ).await(1, TimeUnit.MINUTES);
        //DailyTotalResult result = Fitness.HistoryApi.readDailyTotal( mApiClient, DataType.TYPE_CALORIES_EXPENDED ).await(1, TimeUnit.MINUTES);

        if (result.getStatus().isSuccess() && !result.getTotal().isEmpty()) {
            DataSet totalSet = result.getTotal();
            Log.e("History", "Cal Data returned for Data type: " + totalSet.getDataType().getName() + "DataSet size: " + totalSet.getDataPoints().size() + "Num cals: " + totalSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES));
            //return totalSet.isEmpty() ? "-1" : totalSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES).asFloat() + "";
            return totalSet.isEmpty() ? "-1" : totalSet.getDataPoints().get(0).getValue(Field.FIELD_CALORIES) + "";
        }
        //Toast.makeText(getApplicationContext(), "Steps: " + " Value: ", Toast.LENGTH_SHORT).show();

        showDataSet(result.getTotal());
        return "-1";
    }

    private void updateStepText(String newText)
    {
        numSteps.setText("Steps: " + newText);
        stepsRetrieved = true;
        if (stepsRetrieved && calRetrieved) {
            calculateScore();
        }
    }

    private void updateCalText(String newText)
    {
        numCalories.setText("Calories: " + newText);
        calRetrieved = true;
        if (stepsRetrieved && calRetrieved) {
            calculateScore();
        }

    }

    private void calculateScore()
    {
        if (stepsRetrieved && calRetrieved)
        {

            Log.e("History", "Calculating Score: Steps: " + steps + " Cal: " + cals );

            int stepScore = 0;
            int calScore = 0;

            if (steps < 4000)
            {
                stepScore = 1;
            } else if (steps < 6000)
            {
                stepScore = 2;
            } else if (steps < 8000)
            {
                stepScore = 3;
            } else if (steps < 10000)
            {
                stepScore = 4;
            } else if (steps >= 10000)
            {
                stepScore = 5;
            }

            if (cals < 800)
            {
                calScore = 1;
            } else if (cals < 1200)
            {
                calScore = 2;
            } else if (cals < 1600)
            {
                calScore = 3;
            } else if (cals < 2000)
            {
                calScore = 4;
            } else if (cals >= 2000)
            {
                calScore = 5;
            }

            physicalScore.setText(stepScore + calScore + "");
        }
    }

    private class ViewTodaysStepCountTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            final String temp = displayStepDataForToday();
            runOnUiThread(new Runnable() {

                public void run() {
                    //HERE I WANT TO UPDATE MY TEXT VIEW
                    updateStepText(temp);
                    steps = Integer.parseInt(temp);
                }
            });

            //updateText(displayStepDataForToday());
            return null;
        }
    }

    private class ViewTodaysCalCountTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            final String temp = displayCalDataForToday();
            runOnUiThread(new Runnable() {

                public void run() {
                    //HERE I WANT TO UPDATE MY TEXT VIEW
                    updateCalText(temp);
                    cals = Float.parseFloat(temp);
                    //cals = 42f;
                    //updateCalText(cals + "");
                }
            });

            //updateText(displayStepDataForToday());
            return null;
        }
    }

}
