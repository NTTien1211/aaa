package com.lutech.themelt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesPageChildNewAdapter;
import com.lutech.themelt.adapter.ThemesSettingAdapter;
import com.lutech.themelt.adapter.ThemesSettingIconAdapter;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.IconsModel;

import java.util.ArrayList;

public class ThemesSettingBTFragment extends Fragment {
    ArrayList<IconsModel> icons = new ArrayList<IconsModel>();
    RecyclerView themesSetting_btRC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_themes_setting_b_t, container, false);
        themesSetting_btRC = view.findViewById(R.id.themesSetting_btRC);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id", 0);
            icons = JsonUtils.extractIconsByThemeId(getContext(), id);
        }
        ThemesSettingIconAdapter themesSettingAdapter = new ThemesSettingIconAdapter( icons , getContext());

        themesSetting_btRC.setAdapter(themesSettingAdapter);
        themesSetting_btRC.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}