package com.lutech.themelt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.IconsPagerAdapter;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.ThemesIconModel;

import java.util.ArrayList;


public class IconsFragment extends Fragment {

    IconsPagerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<ThemesIconModel> themes = new ArrayList<ThemesIconModel>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_icons, container, false);
        themes = JsonUtils.extractThemesAndIcons(getContext());
        Log.d("TAG", "checkmama" +themes.size());
        recyclerView = view.findViewById(R.id.icons_recyclerview);
        adapter = new IconsPagerAdapter(themes, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}