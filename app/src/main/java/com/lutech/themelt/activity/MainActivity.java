package com.lutech.themelt.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lutech.themelt.R;
import com.lutech.themelt.adapter.CustomsViewPager;
import com.lutech.themelt.adapter.ThemesPagerAdapter;

public class MainActivity extends AppCompatActivity {
    CustomsViewPager viewPager;
    BottomNavigationView vbNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anhxa();

        ThemesPagerAdapter themesAdapter = new ThemesPagerAdapter(getSupportFragmentManager() , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(themesAdapter);
        viewPager.setPagingEnable(false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    switch (position){
                        case 0:
                            vbNavigationView.getMenu().findItem(R.id.item_theme).setChecked(true);
                            break;
                        case 1:
                            vbNavigationView.getMenu().findItem(R.id.item_icons).setChecked(true);
                            break;
                        case 2:
                            vbNavigationView.getMenu().findItem(R.id.item_widget).setChecked(true);
                            break;
                        case 3:
                            vbNavigationView.getMenu().findItem(R.id.item_wallpaper).setChecked(true);
                            break;
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vbNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_theme) {
                    viewPager.setCurrentItem(0);
                } else  if (item.getItemId() == R.id.item_icons){
                    viewPager.setCurrentItem(1);
                }else  if (item.getItemId() == R.id.item_widget){
                    viewPager.setCurrentItem(2);
                }else  if (item.getItemId() == R.id.item_wallpaper){
                    viewPager.setCurrentItem(3);
                }

                return true;
            }
        });
    }

    private void anhxa() {
        viewPager = findViewById(R.id.viewpager);
        vbNavigationView = findViewById(R.id.bottomnavigationView);
    }
}