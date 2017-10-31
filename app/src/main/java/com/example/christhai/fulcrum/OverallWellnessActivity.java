package com.example.christhai.fulcrum;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/** Represents the overall wellness trends page.
 * @author Team Atlas
 * @version 1.0
*/

public class OverallWellnessActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_wellness);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_overall_wellness);
        super.onResume();
        super.getToolbar().setTitle("Overall Wellness");

    }


}

