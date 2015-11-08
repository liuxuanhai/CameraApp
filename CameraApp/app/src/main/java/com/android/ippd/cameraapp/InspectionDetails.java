package com.android.ippd.cameraapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by MyMac on 10/21/15.
 */
public class InspectionDetails extends Activity {

    private static final String TAG = ".InspectionDetails Activity";
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Override animation to slide in view from bottom to top
        overridePendingTransition(R.anim.slide_up, R.anim.no_change);

        setContentView(R.layout.details_inspection);

        // Hide the soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        // for parts dropdown, will list parts previously created as well as option to create new part
        Spinner dropdown = (Spinner)findViewById(R.id.partsSpinner);
        String[] items = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Navigate up to parent activity
                // NavUtils.navigateUpFromSameTask(InspectionDetails.this);
                // Currently cannot animate when using NavUtils

                // Temporary solution to adding animations
                finish();
                overridePendingTransition(R.anim.no_change, R.anim.slide_down);
            }
        });
    }

    // Override onBackPressed to animate view from top to bottom when leaving view
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.no_change, R.anim.slide_down);
    }

    @Override
    public void onDestroy(){
        Log.d(TAG, "destroyed");
        super.onDestroy();
    }
}
