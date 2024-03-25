package com.lutech.themelt.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.lutech.themelt.R;
import com.lutech.themelt.fragment.WidgetsPhotoFragment;

public class WidgetPageChildAdapter extends FragmentStatePagerAdapter {
    private Context mContext;

    public WidgetPageChildAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position) {
           case 0:
               return new WidgetsPhotoFragment();
           case 1:

           default:
               return new WidgetsPhotoFragment();
       }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return getPageTitleText(position);
    }

    private String getPageTitleText(int position) {
        switch (position) {
            case 0:
                return "Photo";
            case 1:
                return "Gif";
            case 2:
                return "Daily Player";
            case 3:
                return "Digital Clock";
            case 4:
                return "Calendar";
            case 5:
                return "Daily Quote";
            case 6:
                return "Weather";
            case 7:
                return "Clock";
            default:
                return "Photo";
        }
    }

    private int getIconResource(int position) {
        switch (position) {
            case 0:
                return R.drawable.icons8camera30;
            case 1:
                return R.drawable.icons8film30;
            case 2:
                return R.drawable.icons8daily30;
            case 3:
                return R.drawable.iconswatch30;
            case 4:
                return R.drawable.icons8deskcalender30;
            default:
                return R.drawable.icons8deskcalender30;
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
