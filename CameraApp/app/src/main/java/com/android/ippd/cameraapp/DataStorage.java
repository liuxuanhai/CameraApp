package com.android.ippd.cameraapp;

import android.app.Activity;

import com.android.ippd.cameraapp.Inspection;
import com.android.ippd.cameraapp.Part;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Nicole K. on 11/22/15.
 *
 * This class used for holding array of Inspections
 */
public class DataStorage extends Activity {

    private Activity activity;
    private static ArrayList<Inspection> inspecArr = new ArrayList<Inspection>();
    private static ArrayList<String> inspecNameArray = new ArrayList<String>();

    public DataStorage(Activity activity){
        this.activity = activity;
    }

    public void addInspection(Inspection inspection){
        inspecArr.add(inspection);   // this array contains Inspection objects
        inspecNameArray.add(inspection.getInspecName()); //this array contains locations that are displayed as inspection title
    }

    public ArrayList<Inspection> getInspecArr(){ return inspecArr; }
    public ArrayList<String> getLocationArr(){ return inspecNameArray;}


}
