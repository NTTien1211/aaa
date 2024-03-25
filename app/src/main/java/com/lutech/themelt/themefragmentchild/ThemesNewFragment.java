package com.lutech.themelt.themefragmentchild;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesPageChildAdapter;
import com.lutech.themelt.adapter.ThemesPageChildNewAdapter;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.ThemesModel;

import java.util.ArrayList;


public class ThemesNewFragment extends Fragment {
    RecyclerView mRecyclerView;
    ArrayList<ThemesModel> mlist = new ArrayList<ThemesModel>();
    private String mThemeType;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_themes_new, container, false);

        if (getArguments() != null) {
            mThemeType = getArguments().getString("theme_type");
        }
        mlist.addAll(JsonUtils.extractImgUrls(getContext()));
        ArrayList<ThemesModel> filteredList =  new ArrayList<ThemesModel>();
        filteredList.addAll(JsonUtils.extractImgUrlsByType( getContext(),mThemeType));
        mRecyclerView = view.findViewById(R.id.themes_recycleview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        ThemesPageChildNewAdapter mRecyclerAdapter;
        if (mThemeType.equals("New")){
             mRecyclerAdapter = new ThemesPageChildNewAdapter(getContext(), mlist);
        }
        else {
             mRecyclerAdapter = new ThemesPageChildNewAdapter(getContext(), filteredList);
        }
        mRecyclerView.setAdapter(mRecyclerAdapter);
        return view;
    }

}