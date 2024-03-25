package com.lutech.themelt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.CircleTransform;
import com.lutech.themelt.R;
import com.lutech.themelt.activity.ThemesActivity;
import com.lutech.themelt.model.ThemesModel;
import com.lutech.themelt.model.WidgetModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WidgetPagePhotosAdapter extends RecyclerView.Adapter<WidgetPagePhotosAdapter.WidgetPhotoViewHolder> {

    private Context context;
    private ArrayList<WidgetModel> mlist;

    public WidgetPagePhotosAdapter(Context context, ArrayList<WidgetModel> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public WidgetPhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_widgetrecycle, parent, false);
        return new WidgetPhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetPhotoViewHolder holder, int position) {
        WidgetModel model = mlist.get(position);
        Picasso.get().load(model.getImgsmall()).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }

    static class WidgetPhotoViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView imageView;

        public WidgetPhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.widget_imageview_photo);
        }
    }
}
