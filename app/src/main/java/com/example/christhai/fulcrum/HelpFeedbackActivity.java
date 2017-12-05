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
import android.view.Menu;
import android.view.MenuItem;

/** Represents the help and feedback page.
 * @author Team All-Star
 * @version 1.0
 */

public class HelpFeedbackActivity extends BaseActivity {

    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_feedback);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_help_feedback);
        super.onResume();
        super.getToolbar().setTitle("Help & Feedback");
    }

    private void getParcel() {
        Intent b = getIntent();

        if (b.getParcelableExtra("score") != null) {
            score = b.getParcelableExtra("score");

        }
    }
}
