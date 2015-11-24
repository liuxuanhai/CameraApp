package com.android.ippd.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nicole on 10/21/15.
 */
public class InspectionDetails extends Activity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = ".InspectDetailsActivity";
    private Button backButton;
    private Button submit;
    private Spinner partsSpinner;
    private Inspection inspec = new Inspection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //new Inspection(this).inspection_init();

        // Override animation to slide in view from bottom to top
        overridePendingTransition(R.anim.slide_up, R.anim.no_change);

        setContentView(R.layout.details_inspection);

        // Hide the soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate up to parent activity
                // NavUtils.navigateUpFromSameTask(InspectionDetails.this);
                // Currently cannot animate when using NavUtils

                // Temporary solution to adding animations
                finish();
                overridePendingTransition(R.anim.no_change, R.anim.slide_down);
            }
        });

        // Button to submit the input data of inspection details
        submit = (Button)findViewById(R.id.submitInspectionButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Submit Inspection details");
                // Open settings activity
                inspec.storeInspection(InspectionDetails.this);
            }
        });

        inspec.inspection_init();

        // for parts dropdown, will list parts previously created as well as option to create new part
        partsSpinner = (Spinner) findViewById(R.id.partsSpinner);
        ArrayList<String> items = inspec.getPartsNameArray();
        // Create an ArrayAdapter using the string arraylist and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        partsSpinner.setAdapter(adapter);
        partsSpinner.setOnItemSelectedListener(this);

        // For Date and Time
        inspec.getDateTime();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l){
        TextView myText = (TextView) view;
        if (myText.getText() == "Add New Part"){
            Log.d(TAG, "Open PartDetails activity");
            Intent i = new Intent(InspectionDetails.this, PartDetails.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Part: " + myText.getText() + " selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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
