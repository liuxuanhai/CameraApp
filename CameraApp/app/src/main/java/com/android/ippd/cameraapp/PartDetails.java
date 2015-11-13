package com.android.ippd.cameraapp;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nicole on 11/3/15.
 */
public class PartDetails extends Activity{

    private static final String TAG = ".PartDetailsActivity";
    private Button backButton;
    private Button submitPartButton;
    private String[] partsArray = new String[50];  // make this arraylist

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Override animation to slide in view from bottom to top
        overridePendingTransition(R.anim.slide_up, R.anim.no_change);

        setContentView(R.layout.details_part);

        // Hide soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        backButton = (Button) findViewById(R.id.backButton);
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
        submitPartButton = (Button) findViewById(R.id.submitPartButton);
        submitPartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String partInput = ((EditText)findViewById(R.id.partText)).getText().toString();
                addNewPart(partInput);
                Log.d(TAG, "Submitting new part");
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

    //initialize array used for partsSpinner
    protected void partsArray_init(){
        //initialize partsArray
        for(int i = 0; i<partsArray.length; i++){
            partsArray[i] = "";
        }
    }

    // adds new part to partsArray
    protected String[] addNewPart(String part){
        for(int i = 0; i<partsArray.length; i++){
            if (partsArray[i] == "") {
                partsArray[i] = part;
                return partsArray;
            }
        }
        // if return occurs here, then max of 50 parts has been reached for inspection
        return partsArray;
    }
    protected String[] getPartsArray(){
        return partsArray;
    }
}
