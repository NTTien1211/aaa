package com.lutech.themelt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesSettingIconAdapter;
import com.lutech.themelt.bottomsheet.MyBottomSheetDialogAppFragment;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.IconsModel;

import java.util.ArrayList;

public class IconSettingActivity extends AppCompatActivity  implements MyBottomSheetDialogAppFragment.OnAppSelectedListener{
    int id;
    ArrayList<IconsModel> icons = new ArrayList<IconsModel>();
    RecyclerView IconSetting_btRC;
    ImageButton back_preessed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_setting);
        IconSetting_btRC = findViewById(R.id.IconSetting_btRC);
        back_preessed = findViewById(R.id.back_preessed);
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("Idtheme" , 0);
            icons = JsonUtils.extractIconsByThemeId(this, id);
        }
        ThemesSettingIconAdapter themesSettingAdapter = new ThemesSettingIconAdapter( icons , this);

        IconSetting_btRC.setAdapter(themesSettingAdapter);
        IconSetting_btRC.setLayoutManager(new LinearLayoutManager(this));
        back_preessed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void onAppSelected(Drawable appIcon) {
        // Pass the selected app icon to the adapter
        if (IconSetting_btRC != null && IconSetting_btRC.getAdapter() instanceof ThemesSettingIconAdapter) {
            ((ThemesSettingIconAdapter) IconSetting_btRC.getAdapter()).onAppSelected(appIcon);
        }
    }
}