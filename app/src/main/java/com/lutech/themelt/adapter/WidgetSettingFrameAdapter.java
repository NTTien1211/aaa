package com.lutech.themelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.model.FrameModel;
import com.lutech.themelt.model.WidgetModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WidgetSettingFrameAdapter extends RecyclerView.Adapter<WidgetSettingFrameAdapter.WidgetFramePageHolder>{
    ArrayList<FrameModel>  themes = new ArrayList<FrameModel>();
    Context context;
    public WidgetSettingFrameAdapter(ArrayList<FrameModel>  themes , Context   context) {
        this.themes = themes;
        this.context = context;
    }

    @NonNull
    @Override
    public WidgetFramePageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widget_tva_recycle, parent, false);
        return new WidgetFramePageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetSettingFrameAdapter.WidgetFramePageHolder holder, int position) {
        FrameModel theme = themes.get(position);
        Picasso.get().load(theme.getImgsmall()).into(holder.img_widgetTVA);
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public static class WidgetFramePageHolder extends RecyclerView.ViewHolder {
        ShapeableImageView img_widgetTVA;
        public WidgetFramePageHolder(@NonNull View itemView) {
            super(itemView);
            img_widgetTVA = itemView.findViewById(R.id.img_widgetTVA);
        }
    }

}
