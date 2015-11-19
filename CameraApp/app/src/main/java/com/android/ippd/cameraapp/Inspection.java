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
    private static String mInspector;
    private static String mEngine;
    private static String mLocation;
    private static String mComments;
    private static String mDate;
    //private Part part = new Part();
    //create Arraylist<Part> that will contain individual part names and comments

    public Inspection(Activity activity){
        this.activity = activity;
    }

    protected void inspection_init(){

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
        SimpleDateFormat dateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        mDate = dateFormat.format(dNow);
        mDateText.setText(mDate);
        return mDate;
    }

    // adds new part to partsArray
    protected ArrayList<Part> addNewPart(/*String part, String comments*/){
        Part partItem = new Part(this.activity);
        partItem.part_init();
        partsArray.add(partItem);
        return partsArray;
    }
    protected ArrayList<Part> getPartsArray(){
        return partsArray;
    }

}
