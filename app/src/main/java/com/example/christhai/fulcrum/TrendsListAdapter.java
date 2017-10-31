package com.example.christhai.fulcrum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ChrisThai on 10/29/2017.
 */

public class TrendsListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    /**
     * Instantiating an adapter.
     * @param context The current page's context
     */
    public TrendsListAdapter(Context context) {
        this.context = context;
        List<String> header = new LinkedList<String>();
        HashMap<String, List<String>> data = new HashMap<String, List<String>>();
        header.add("Home");
        header.add("Daily Assessment");
        header.add("Overall Wellness");
        header.add("Current Trends");
        header.add("Settings");
        header.add("Help & Feedback");
        header.add("Sign Out");
        List<String> currTrends = new LinkedList<String>();
        currTrends.add("Emotional Trends");
        currTrends.add("Social Trends");
        currTrends.add("Physical Trends");
        currTrends.add("Academic Trends");
        data.put("Current Trends", currTrends);
        this.listDataHeader = header;
        this.listDataChild = data;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (this.listDataChild.get(this.listDataHeader.get(groupPosition)) != null) {
            return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.current_trends_header, null);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.submenu);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if (getChildrenCount(groupPosition) == 0) {
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.current_trends_items, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.nav_current_trends_item);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        if (this.getChildrenCount(groupPosition) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Class<? extends AppCompatActivity> selectTrend(int groupPosition, int childPosition) {
        String child = (String) getChild(groupPosition, childPosition); //Retrieve selected string

        switch(child) {
            case "Emotional Trends":
                return EmotionalTrendsActivity.class;
            case "Social Trends":
                return SocialTrendsActivity.class;
            case "Physical Trends":
                return PhysicalTrendsActivity.class;
            case "Academic Trends":
                return AcademicTrendsActivity.class;
            default:
                return null;
        }
    }

    public Class<? extends AppCompatActivity> selectPage(int groupPosition) {
        String group = (String) getGroup(groupPosition);
        switch(group){
            case "Home":
                return MainActivity.class;
            case "Daily Assessment":
                return daily_assessment.class;
            case "Overall Wellness":
                return OverallWellnessActivity.class;
            case "Settings":
                return SettingsActivity.class;
            case "Help & Feedback":
                return HelpFeedbackActivity.class;
            case "Sign Out":
                return LoginActivity.class;
            default:
                return null;
        }
    }
}
