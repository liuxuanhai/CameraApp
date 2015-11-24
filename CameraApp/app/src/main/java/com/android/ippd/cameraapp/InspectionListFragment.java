package com.android.ippd.cameraapp;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael on 11/24/15.
 */
public class InspectionListFragment extends ListFragment {
    private static final String TAG = ".InspectionListFragment";
    private ArrayList<Inspection> mInspections;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.inspection_title);
        mInspections = InspectionList.get(getActivity()).getInspections();


        InspectionAdapter adapter = new InspectionAdapter(mInspections);
        setListAdapter(adapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((InspectionAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Inspection s = ((InspectionAdapter)getListAdapter()).getItem(position);

        // Start InspectionInfoActivity
        Intent i = new Intent(getActivity(), InspectionInfoActivity.class);
        i.putExtra("STRING_I_NEED",s.getId().toString());
        Log.d(TAG,"UUID: " + s.getId().toString());

        startActivity(i);
    }

    private class InspectionAdapter extends ArrayAdapter<Inspection>{

        public InspectionAdapter(ArrayList<Inspection> inspections){
            super(getActivity(),0,inspections);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // If we aren't given a view, inflate one
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_inspection,null);
            }

            // Configure the view for this Inspection
            Inspection s = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.inspection_list_item_titleTextView);
            titleTextView.setText(s.getTitle());
            //TextView dateTextView = (TextView)convertView.findViewById(R.id.inspection_list_item_dateTextView);
            //dateTextView.setText(s.getDateTime());

            return convertView;
        }
    }
}
