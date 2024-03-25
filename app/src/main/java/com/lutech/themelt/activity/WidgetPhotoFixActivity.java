package com.lutech.themelt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.adapter.WidgetPagePhotosAdapter;
import com.lutech.themelt.adapter.WidgetSettingColorAdapter;
import com.lutech.themelt.adapter.WidgetSettingFrameAdapter;
import com.lutech.themelt.adapter.WidgetSettingImgAdapter;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.FrameModel;
import com.lutech.themelt.model.WidgetModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WidgetPhotoFixActivity extends AppCompatActivity {
    RecyclerView mRecyclerViewTvien , mRecyclerViewKhunganh ,mRecyclerViewColor;
    ArrayList<WidgetModel> widgetModels = new ArrayList<WidgetModel>();
    ArrayList<FrameModel> frameModels = new ArrayList<FrameModel>();
    WidgetSettingImgAdapter widgetSettingImgAdapter ;
    ShapeableImageView img_widgetFix;
    WidgetSettingColorAdapter widgetSettingColorAdapter;
    WidgetSettingFrameAdapter widgetSettingFrameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_photo_fix);
        anhxa();
        Picasso.get().load("https://wallpapercave.com/wp/ZEHBtIw.jpg").into(img_widgetFix);

        widgetModels = JsonUtils.extractWidgets(this, "Photo");
        frameModels = JsonUtils.extractFrame(this);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewTvien.setLayoutManager(horizontalLayoutManagaer);
        widgetSettingImgAdapter = new WidgetSettingImgAdapter(widgetModels,this );
        mRecyclerViewTvien.setAdapter(widgetSettingImgAdapter);

        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewKhunganh.setLayoutManager(horizontalLayoutManagaer1);
        widgetSettingFrameAdapter = new WidgetSettingFrameAdapter(frameModels,this );
        mRecyclerViewKhunganh.setAdapter(widgetSettingFrameAdapter);

        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewColor.setLayoutManager(horizontalLayoutManagaer2);
        widgetSettingColorAdapter = new WidgetSettingColorAdapter(this );
        mRecyclerViewColor.setAdapter(widgetSettingColorAdapter);
    }

    private void anhxa() {
        mRecyclerViewTvien = (RecyclerView)findViewById(R.id.widget_fix_tvienanh);
        mRecyclerViewKhunganh = (RecyclerView)findViewById(R.id.widget_fix_khunganh);
        img_widgetFix = (ShapeableImageView) findViewById(R.id.img_widgetFix);
        mRecyclerViewColor = (RecyclerView) findViewById(R.id.widget_fix_color);
    }
}