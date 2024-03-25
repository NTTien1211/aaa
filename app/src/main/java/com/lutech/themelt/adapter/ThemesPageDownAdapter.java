package com.lutech.themelt.adapter;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import com.lutech.themelt.R;
import com.lutech.themelt.activity.ThemesActivity;
import com.lutech.themelt.activity.ThemesSettingActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ThemesPageDownAdapter extends PagerAdapter {
    ThemesActivity themesActivity;
    ArrayList<String> mlis;
     Context context ;
     int id;

    public ThemesPageDownAdapter(ThemesActivity themesActivity, ArrayList<String>  mlis , Context context , int id) {
        this.themesActivity = themesActivity;
        this.mlis = mlis;
        this.context = context;
        this.id = id;
    }

    @Override
    public int getCount() {
        return mlis.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(themesActivity).inflate(R.layout.viewpager_themes_down, container, false);
        ImageView simple_img = view.findViewById(R.id.simple_img);
        Button layout_button = view.findViewById(R.id.layout_button);



        Glide.with(themesActivity).load(mlis.get(position)).into(simple_img);
        layout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , ThemesSettingActivity.class);
                intent.putExtra("id", id);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
