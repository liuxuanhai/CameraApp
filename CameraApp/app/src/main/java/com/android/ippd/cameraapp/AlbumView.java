package com.android.ippd.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.ippd.cameraapp.DataStorage;
import com.android.ippd.cameraapp.Inspection;
import com.android.ippd.cameraapp.R;

import java.util.ArrayList;

/**
 * Created by Nicole K. on 11/21/15.
 */
public class AlbumView extends Activity {

    private static final String TAG = ".AlbumViewActivity";
    private Button backButton;
    private DataStorage DS = new DataStorage(this);
    private ArrayList<Inspection> inspecArr = new ArrayList<Inspection>();
    private ArrayList<String> inspecNameArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_album);


        // Override animation to slide in view from bottom to top
        overridePendingTransition(R.anim.slide_up, R.anim.no_change);

        inspecArr = DS.getInspecArr();
        inspecNameArray = DS.getLocationArr();

        // Creates listView of all Inspections (by location)
        ArrayAdapter<String> inspecList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inspecNameArray);
        ListView inspecListView = (ListView) findViewById(R.id.listView);
        inspecListView.setAdapter(inspecList);

        // Hide soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        // Inspection selected will pull up details in new activity
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        Log.d(TAG, "Open InspectionDetails activity");
                        // maybe create new activity to save changes to an inspection
                        Intent i = new Intent(AlbumView.this, InspectionDetails.class);
                        startActivity(i);
                    }
                };

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
