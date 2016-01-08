package com.android.ippd.cameraapp;

import android.app.Activity;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nicole K. on 11/13/15.
 */
public class Inspection {

    // used for accessing elements from activity with viewById()
    private Activity activity;

    private static ArrayList<Part> partsArray = new ArrayList<Part>();
    private static ArrayList<String> partsNameArray = new ArrayList<String>();
    private static String mInspector;
    private static String mEngine;
    private static String mLocation;
    private static String mComments;
    private static String mDate;

    public Inspection(Activity activity){
        this.activity = activity;
    }

    protected void inspection_init(){

        if (partsNameArray.size() == 0) {
            partsNameArray.add("");
            partsNameArray.add("Add New Part");
        }
        EditText inspec = (EditText) activity.findViewById(R.id.inspectorText);
        mInspector = inspec.getText().toString();
        EditText eng = (EditText) activity.findViewById(R.id.engineText);
        mEngine = eng.getText().toString();
        EditText loca = (EditText) activity.findViewById(R.id.locationText);
        mLocation = loca.getText().toString();
        EditText comm = (EditText) activity.findViewById(R.id.commentsText);
        mComments = comm.getText().toString();
        EditText date = (EditText) activity.findViewById(R.id.mDateText);
        mDate = date.getText().toString();

    }
    protected String getDateTime(){
        Date dNow = new Date();
        EditText mDateText = (EditText)activity.findViewById(R.id.mDateText);
        SimpleDateFormat dateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm a zzz");
        mDate = dateFormat.format(dNow);
        mDateText.setText(mDate);
        return mDate;
    }

    // adds new part to partsArray
    protected ArrayList<String> addNewPart(){
        Part partItem = new Part(this.activity);
        partItem.part_init();
        partsArray.add(partItem);   // this array contains Part objects
        partsNameArray.add(partItem.getpartName()); //this array contains part names to display in spinner
        return partsNameArray;
    }

    protected ArrayList<String> getPartsNameArray(){
        return partsNameArray;
    }

    protected void storeInspection(Activity activity){
        EditText inspec = (EditText) activity.findViewById(R.id.inspectorText);
        mInspector = inspec.getText().toString();
        EditText eng = (EditText) activity.findViewById(R.id.engineText);
        mEngine = eng.getText().toString();
        EditText loca = (EditText) activity.findViewById(R.id.locationText);
        mLocation = loca.getText().toString();
        EditText comm = (EditText) activity.findViewById(R.id.commentsText);
        mComments = comm.getText().toString();
        EditText date = (EditText) activity.findViewById(R.id.mDateText);
        mDate = date.getText().toString();
    }

    // Location input is default name of inspection; Ask Siemens for preference
    public String getInspecName(){
        return mLocation;
    }

}
