package com.android.ippd.cameraapp;

import android.app.Fragment;

/**
 * Created by Michael on 11/24/15.
 */
public class InspectionListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        // Direct retrieval
        return new InspectionListFragment();
    }
}
