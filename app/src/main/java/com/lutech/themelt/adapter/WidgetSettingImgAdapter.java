package com.lutech.themelt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.activity.IconSettingActivity;
import com.lutech.themelt.model.ThemesIconModel;
import com.lutech.themelt.model.WidgetModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WidgetSettingImgAdapter extends RecyclerView.Adapter<WidgetSettingImgAdapter.WidgetTVAPageHolder>{
    ArrayList<WidgetModel>  themes = new ArrayList<WidgetModel>();
    Context context;
    public WidgetSettingImgAdapter(ArrayList<WidgetModel>  themes , Context   context) {
        this.themes = themes;
        this.context = context;
    }

    @NonNull
    @Override
    public WidgetTVAPageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widget_tva_recycle, parent, false);
        return new WidgetTVAPageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetSettingImgAdapter.WidgetTVAPageHolder holder, int position) {
        WidgetModel theme = themes.get(position);
        Picasso.get().load(theme.getImgsmall()).into(holder.img_widgetTVA);
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public static class WidgetTVAPageHolder extends RecyclerView.ViewHolder {
        ShapeableImageView img_widgetTVA;
        public WidgetTVAPageHolder(@NonNull View itemView) {
            super(itemView);
            img_widgetTVA = itemView.findViewById(R.id.img_widgetTVA);
        }
    }

}
