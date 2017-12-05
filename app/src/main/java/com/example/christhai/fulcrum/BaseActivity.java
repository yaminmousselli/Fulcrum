package com.example.christhai.fulcrum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

/**
 * Created by ChrisThai on 10/31/2017.
 */

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ExpandableListView submenu;
    private ExpandableListAdapter currAdapter;
    private Menu menu;
    private Toolbar toolbar;
    private Score score = new Score();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        if (!getIntent().hasExtra("score")) {
            getParcel();
        }

        //Navigation Drawer Listener
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Expandable View Listener
        submenu = (ExpandableListView) findViewById(R.id.navigationmenu);

        //Setting List Adapter
        currAdapter = new TrendsListAdapter(getApplicationContext());

        submenu.setAdapter(currAdapter);
        submenu.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                TrendsListAdapter adapter = (TrendsListAdapter) currAdapter;
                Class newpage = adapter.selectPage(groupPosition);
                if (newpage != null) {
                    Intent intent = new Intent();
                    intent.putExtra("score", score);
                    intent.setClass(getApplicationContext(),newpage);
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });
        submenu.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                        int childPosition, long id) {
                TrendsListAdapter adapter = (TrendsListAdapter) currAdapter;
                Class newpage = adapter.selectTrend(groupPosition, childPosition);
                Intent intent = new Intent(getApplicationContext(), newpage);
                startActivity(intent);
                return true;
            }
        });
    }
    //Below are methods for the Toolbar.

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        super.onCreateOptionsMenu(menu);

        // Create your menu...

        this.menu = menu;
        return true;
    }
    @Override
    public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return true;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    private void getParcel() {
        Intent b = getIntent();

        if (b.getParcelableExtra("score") != null) {
            score = b.getParcelableExtra("score");

        }
    }
}
