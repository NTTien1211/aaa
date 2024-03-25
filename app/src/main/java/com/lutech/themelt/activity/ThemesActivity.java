package com.lutech.themelt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesPageDownAdapter;

import java.util.ArrayList;

public class ThemesActivity extends AppCompatActivity {
    int pos , dow , id;
    ViewPager viewPager;
    Context context;
    ImageButton themesdownload_close ,themesdownload_inf;
    ArrayList<String> mlis = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        pos= getIntent().getIntExtra("pos",0);
        mlis=getIntent().getStringArrayListExtra("list");
        dow = getIntent().getIntExtra("dowload", 0);
        id = getIntent().getIntExtra("id", 0);
        viewPager=findViewById(R.id.viewpager_themesdowns);
        themesdownload_close=findViewById(R.id.themesdownload_close);
        themesdownload_inf=findViewById(R.id.themesdownload_inf);

        ThemesPageDownAdapter adapter = new ThemesPageDownAdapter(ThemesActivity.this, mlis , getApplicationContext() , id);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);

        themesdownload_close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        themesdownload_inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ThemesActivity.this);
                dialog.setContentView(R.layout.dialog_theme_info);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView downloadTextView = dialog.findViewById(R.id.theme_dowload_inf);
                downloadTextView.setText(String.valueOf(dow));
                WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                params.gravity = Gravity.TOP;
                dialog.getWindow().setAttributes(params);
                dialog.getWindow().setLayout(
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT
                );
                dialog.show();
            }
        });


    }
}