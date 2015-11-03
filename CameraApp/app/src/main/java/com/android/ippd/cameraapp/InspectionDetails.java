package com.android.ippd.cameraapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Nicole on 10/21/15.
 */
public class InspectionDetails extends Activity {

    //private Button backButton;
    private Spinner partsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_inspection);

        // Hide soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        // for parts dropdown, will list parts previously created as well as option to create new part
        partsSpinner = (Spinner) findViewById(R.id.partsSpinner);
        String[] items = new String[]{"New Part"};
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        partsSpinner.setAdapter(adapter);


//        backButton = (Button)findViewById(R.id.backButton);
//        backButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                NavUtils.navigateUpFromSameTask(InspectionDetails.this);
//        }
//        };
    }
}
