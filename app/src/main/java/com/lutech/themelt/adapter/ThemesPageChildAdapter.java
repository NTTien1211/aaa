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

import com.lutech.themelt.themefragmentchild.ThemesNewFragment;

public class ThemesPageChildAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private ViewPager mViewPager;
    private static TabLayout mTabLayout;

    public ThemesPageChildAdapter(@NonNull FragmentManager fm, int behavior, Context context, ViewPager viewPager, TabLayout tabLayout) {
        super(fm, behavior);
        mContext = context;
        mViewPager = viewPager;
        mTabLayout = tabLayout;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ThemesNewFragment fragment = new ThemesNewFragment();
        Bundle args = new Bundle();
        args.putString("theme_type", getPageTitleText(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public  CharSequence getPageTitle(int position) {
        return getPageTitleText(position);
    }

    private static String getPageTitleText(int position) {
        switch (position) {
            case 0:
                return "New";
            case 1:
                return "Holiday";
            case 2:
                return "Anime";
            case 3:
                return "Kpop";
            case 4:
                return "Aethetic";
            case 5:
                return "Cute";
            case 6:
                return "Sanrio";
            default:
                return "Neon";
        }
    }

    private int getIconResource(int position) {
        switch (position) {
            case 0:
                return R.drawable.iconsfire30;
            case 1:
                return R.drawable.iconssnow30;
            case 2:
                return R.drawable.iconslower30;
            case 3:
                return R.drawable.icons8musicalnotes30;
            case 4:
                return R.drawable.icons8ainbow30;
            case 5:
                return R.drawable.icons8edbow30;
            default:
                return R.drawable.iconsfire30;
        }
    }

    public void setupCustomTabViews(TabLayout tabLayout) {
        for (int i = 0; i < getCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(R.layout.tablayout_custom);
                View customTabView = tab.getCustomView();
                if (customTabView != null) {
                    ImageView icon = customTabView.findViewById(R.id.icon);
                    TextView title = customTabView.findViewById(R.id.title);
                    icon.setImageResource(getIconResource(i));
                    title.setText(getPageTitleText(i));
                }
            }
        }
    }
}
