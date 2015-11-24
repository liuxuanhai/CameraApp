package com.android.ippd.cameraapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Michael on 11/24/15.
 */
public class InspectionList {
    private ArrayList<Inspection> mInspections;

    private static InspectionList sInspectionList;
    private Context mAppContext;

    private InspectionList(Context appContext){
        mAppContext = appContext;
        mInspections = new ArrayList<Inspection>();
    }

    public static InspectionList get(Context c){
        if(sInspectionList == null){
            sInspectionList = new InspectionList(c.getApplicationContext());
        }
        return sInspectionList;
    }

    public void addInspection(Inspection s){
        mInspections.add(s);
    }

    public ArrayList<Inspection> getInspections(){
        return mInspections;
    }

    public Inspection getInspection(UUID id){
        for(Inspection s:mInspections){
            if(s.getId().equals(id))
                return s;
        }
        return null;
    }


}
