package com.lutech.themelt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.WidgetPagePhotosAdapter;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.WidgetModel;

import java.util.ArrayList;

public class WidgetsPhotoFragment extends Fragment {
    RecyclerView mRecyclerView;
    WidgetPagePhotosAdapter mPagePhotosAdapter;
    ArrayList<WidgetModel> mlist = new ArrayList<WidgetModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view =  inflater.inflate(R.layout.fragment_widgets_photo, container, false);
        mRecyclerView = view.findViewById(R.id.widget_photorecycl);
        mlist = JsonUtils.extractWidgets(getContext() , "Photo");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        mPagePhotosAdapter = new WidgetPagePhotosAdapter(getContext(),mlist );
        mRecyclerView.setAdapter(mPagePhotosAdapter);
        return view;
    }
}