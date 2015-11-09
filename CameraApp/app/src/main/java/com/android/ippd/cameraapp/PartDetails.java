package com.android.ippd.cameraapp;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by Nicole on 11/3/15.
 */
public class PartDetails extends Activity{

    private Button submitPartButton;
    private String[] partsArray = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_part);

        // Hide soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

//        submitPartButton = (Button)findViewById(R.id.submitPartButton);
//        submitPartButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                NavUtils.navigateUpFromSameTask(PartDetails.this);
//        }
//        };

    }

    protected String[] addNewPart(String part){
        for(int i = 0; i<50; i++){
            if (partsArray[i] == null) {
                partsArray[i] = part;
                return partsArray;
            }
        }
        // if return occurs here, then max of 50 parts has been reached for inspection
        return partsArray;
    }
}
