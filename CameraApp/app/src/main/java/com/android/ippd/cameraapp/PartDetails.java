package com.android.ippd.cameraapp;

import android.app.Activity;
import android.support.v4.app.NavUtils;
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
    private DataStorage DS = new DataStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_part);

        // Hide soft keys
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

        submitPartButton = (Button)findViewById(R.id.submitPartButton);
        submitPartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String partInput = ((EditText)findViewById(R.id.partText)).getText().toString();
                DS.addNewPart(partInput);
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

}
