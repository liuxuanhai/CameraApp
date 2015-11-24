package com.android.ippd.cameraapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Michael on 11/24/15.
 */
public class InspectionInfoActivity extends Activity {
    private static final String TAG = ".InspectionInfoActivity";

    private Inspection mInspection;
    private String mUUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_info);

        Bundle extras = getIntent().getExtras();

        if (extras == null){
            return;
        }

        String uuid = extras.getString("STRING_I_NEED");

        mInspection = InspectionList.get(getApplicationContext()).getInspection(UUID.fromString(uuid));

        Log.d(TAG, "UUID: " + uuid);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }

    private class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<Bitmap> pictures = mInspection.getPictures();

        // Constructor
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return pictures.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(mContext);
                //imageView.setLayoutParams(new GridView.LayoutParams(640, 480));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            }
            else
            {
                imageView = (ImageView) convertView;
            }
            imageView.setImageBitmap(pictures.get(position));
            return imageView;
        }
    }
}
