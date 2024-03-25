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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lutech.themelt.R;
import com.lutech.themelt.activity.IconSettingActivity;
import com.lutech.themelt.model.ThemesIconModel;
import com.lutech.themelt.model.ThemesModel;

import java.util.ArrayList;
import java.util.List;

public class IconsPagerAdapter extends RecyclerView.Adapter<IconsPagerAdapter.IconPageHolder>{
    ArrayList<ThemesIconModel>  themes = new ArrayList<ThemesIconModel>();
    Context context;
    public IconsPagerAdapter(ArrayList<ThemesIconModel>  themes ,Context   context) {
        this.themes = themes;
        this.context = context;
    }

    @NonNull
    @Override
    public IconPageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iconrecycle, parent, false);
        return new IconPageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconsPagerAdapter.IconPageHolder holder, int position) {
        ThemesIconModel theme = themes.get(position);
        holder.textView.setText(theme.getName());

        List<String> iconUrls = theme.getUrls();
        List<ImageView> imageViews = holder.iconImageViews;

        for (int i = 0; i < iconUrls.size(); i++) {
            Glide.with(context)
                    .load(iconUrls.get(i))
                    .into(imageViews.get(i));
        }
        holder.iconlayout_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IconSettingActivity.class);
                intent.putExtra("Idtheme", theme.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public static class IconPageHolder extends RecyclerView.ViewHolder {
        TextView textView;
        List<ImageView> iconImageViews;
        LinearLayout iconlayout_all;
        public IconPageHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.namethemes);
            iconlayout_all = itemView.findViewById(R.id.iconlayout_all);
            iconImageViews = new ArrayList<>();
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img1));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img2));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img3));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img4));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img5));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img6));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img7));
            iconImageViews.add((ImageView) itemView.findViewById(R.id.icon_img8));
        }
    }

}
