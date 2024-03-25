package com.lutech.themelt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesPageChildAdapter;
import com.lutech.themelt.adapter.ThemesSettingAdapter;

public class ThemesSettingActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageButton backpressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes_setting);
        viewPager = findViewById(R.id.settingthemeviewpager);
        tabLayout = findViewById(R.id.settingthemetablayout);
        backpressButton = findViewById(R.id.back_preessed);

        int id = getIntent().getIntExtra("id", 0);
        ThemesSettingAdapter themesPage = new ThemesSettingAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, this , id);

        viewPager.setAdapter(themesPage);

        tabLayout.setupWithViewPager(viewPager);
        backpressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }



}