package com.android.ippd.cameraapp;

import android.app.Activity;
import android.widget.EditText;

import com.android.ippd.cameraapp.R;

/**
 * Created by Nicole K. on 11/18/15.
 */
public class Part {
    private static String partName;
    private static String partComments;
    Activity activity;

    public Part(Activity activity){
        this.activity = activity;
    }

    public void part_init(){
        EditText partN = (EditText)activity.findViewById(R.id.partText);
        partName = partN.getText().toString();

        EditText partComm = (EditText)activity.findViewById(R.id.partCommentsText);
        partComments = partComm.getText().toString();
    }
    public String getpartName(){
        return partName;
    }
    public String getPartComments(){
        return partComments;
    }


}
