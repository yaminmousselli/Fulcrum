package com.example.christhai.fulcrum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/** Represents the physical trends page.
 * @author Team Atlas
 * @version 1.0
*/
public class PhysicalTrendsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_trends);
    }

    @Override
    protected void onResume() {
        setContentView(R.layout.activity_academic_trends);
        super.onResume();
        super.getToolbar().setTitle("Physical Trends");
    }
}
