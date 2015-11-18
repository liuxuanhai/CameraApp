package com.android.ippd.cameraapp;

import java.util.ArrayList;

/**
 * Created by Nicole K. on 11/13/15.
 */
public class DataStorage {

    //static String[] partsArray = new String[50];
    static ArrayList<String> partsArray = new ArrayList<String>();

    // adds new part to partsArray
    protected ArrayList<String> addNewPart(String part){
        partsArray.add(part);
        return partsArray;
    }
    protected ArrayList<String> getPartsArray(){
        return partsArray;
    }

}
