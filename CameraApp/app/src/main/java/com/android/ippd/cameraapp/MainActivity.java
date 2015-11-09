package com.android.ippd.cameraapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("ALL")
public class MainActivity extends Activity {

    private final String TAG = ".MainActivity";
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    private Camera mCamera;
    private CameraPreview mPreview;
    private Button captureButton;
    private Button inspectionDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the soft keys
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        if (checkCameraHardware(this)){
            // Create an instance of Camera
            mCamera = getCameraInstance();
        }

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
//        mPreview.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
//            }
//        });
        FrameLayout preview = (FrameLayout)findViewById(R.id.camera_preview);
        preview.addView(mPreview);

        // Button to capture a picture
        captureButton = (Button)findViewById(R.id.button_capture);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get an image from the camera
                mCamera.takePicture(null,null,mPicture);
                Log.d(TAG,"Taking a picture");
            }
        });

        // Button to go to InspectionDetails activity
        inspectionDetailsButton = (Button)findViewById(R.id.button_inspectionDetails);
        inspectionDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Open settings activity");
                // Open settings activity
                Intent i = new Intent(MainActivity.this, InspectionDetails.class);
                startActivity(i);
            }
        });

    }



    private Camera.PictureCallback mPicture = new Camera.PictureCallback(){

        @Override
        public void onPictureTaken(byte[] data, Camera camera){
            mCamera.startPreview();
            Log.d(TAG,"onPictureTaken");
            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null) {
                Log.d(TAG, "Error creating media file, checking storage permissions " );
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e){
                Log.d(TAG, "File not found: " + e.getMessage());
            } catch (IOException e ){
                Log.d(TAG, "Error accessing file: " + e.getMessage());
            }
        }
    };

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name M
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    private boolean checkCameraHardware(Context context){
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // This device has a camera
            return true;
        } else {
            // No camera on this device
            return false;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Release the camera when activity is destroyed
        if (mCamera != null){
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        // Hide soft keys when resuming the activity
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
    }
}
