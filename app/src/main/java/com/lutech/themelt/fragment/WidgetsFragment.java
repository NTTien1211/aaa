package com.lutech.themelt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesPageChildAdapter;
import com.lutech.themelt.adapter.WidgetPageChildAdapter;


public class WidgetsFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widgets, container, false);
        tabLayout = view.findViewById(R.id.tab_layoutWiaget);
        viewPager = view.findViewById(R.id.widgetPager_theme);

        WidgetPageChildAdapter themesPage = new WidgetPageChildAdapter(getChildFragmentManager() , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, getContext());
        viewPager.setAdapter(themesPage);

        tabLayout.setupWithViewPager(viewPager);
        themesPage.setupCustomTabViews(tabLayout);

        return view;
    }
}