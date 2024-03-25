package com.lutech.themelt.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lutech.themelt.fragment.IconsFragment;
import com.lutech.themelt.fragment.ThemesFragment;
import com.lutech.themelt.fragment.WallpapersFragment;
import com.lutech.themelt.fragment.WidgetsFragment;

public class ThemesPagerAdapter extends FragmentStatePagerAdapter {
    public ThemesPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ThemesFragment();
            case 1:
                return new IconsFragment();
            case 2:
                return new WidgetsFragment();
            case 3:
                return new WallpapersFragment();
             default:
                 return new ThemesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
