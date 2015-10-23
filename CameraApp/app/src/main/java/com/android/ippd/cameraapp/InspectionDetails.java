package com.android.ippd.cameraapp;

<<<<<<< HEAD
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
=======
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
>>>>>>> 5ebdbe255e06d49e5b68494cbb02c2aca1740b9f
import android.widget.Spinner;

/**
 * Created by MyMac on 10/21/15.
 */
<<<<<<< HEAD
public class InspectionDetails extends MainActivity {
=======
public class InspectionDetails extends Activity {
>>>>>>> 5ebdbe255e06d49e5b68494cbb02c2aca1740b9f


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_inspection);

        // for parts dropdown, will list parts previously created as well as option to create new part
        Spinner dropdown = (Spinner)findViewById(R.id.partsSpinner);
        String[] items = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }
}
