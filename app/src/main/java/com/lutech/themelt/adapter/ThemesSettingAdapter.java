package com.lutech.themelt.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lutech.themelt.R;
import com.lutech.themelt.fragment.ThemesSettingBTFragment;
import com.lutech.themelt.fragment.ThemesSettingHNFragment;
import com.lutech.themelt.fragment.ThemesSettingTIFragment;
import com.lutech.themelt.themefragmentchild.ThemesNewFragment;

public class ThemesSettingAdapter extends FragmentStatePagerAdapter {
    private Context mContext;

    int id;
    public ThemesSettingAdapter(@NonNull FragmentManager fm, int behavior, Context context , int id) {
        super(fm, behavior);
        mContext = context;
        this.id =id;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ThemesSettingHNFragment fragment = new ThemesSettingHNFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                fragment.setArguments(bundle);
                return fragment;
            case 1:
                ThemesSettingBTFragment fragment1 = new ThemesSettingBTFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("id", id);
                fragment1.setArguments(bundle1);
                return fragment1;
            case 2:
                ThemesSettingTIFragment fragment2 = new ThemesSettingTIFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("id", id);
                fragment2.setArguments(bundle2);
                return fragment2;
            default:
                fragment = new ThemesSettingHNFragment();
                bundle = new Bundle();
                bundle.putInt("id", id);
                fragment.setArguments(bundle);
                return fragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public  CharSequence getPageTitle(int position) {
        return getPageTitleText(position);
    }

    private static String getPageTitleText(int position) {
        switch (position) {
            case 0:
                return "HÌNH NỀN";
            case 1:
                return "BIỂU TƯỢNG";
            case 2:
                return "TIỆN ÍCH";
            default:
                return "HÌNH NỀN";
        }
    }

}
