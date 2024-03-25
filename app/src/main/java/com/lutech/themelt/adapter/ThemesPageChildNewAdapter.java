package com.lutech.themelt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.lutech.themelt.CircleTransform;
import com.lutech.themelt.R;
import com.lutech.themelt.activity.ThemesActivity;
import com.lutech.themelt.model.ThemesModel;
import com.lutech.themelt.themefragmentchild.ThemesNewFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ThemesPageChildNewAdapter extends RecyclerView.Adapter<ThemesPageChildNewAdapter.WappViewHolder> {

    private Context context;
    private ArrayList<ThemesModel> mlist;

    public ThemesPageChildNewAdapter(Context context, ArrayList<ThemesModel> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public WappViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_themes_recycleview, parent, false);
        return new WappViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WappViewHolder holder, int position) {
        ThemesModel theme = mlist.get(position);
        ArrayList<String> m2list = new ArrayList<>();
        m2list.add(theme.getImg());

        Picasso.get().load(theme.getImg()).transform(new CircleTransform(80)).into(holder.imageView);
        holder.themesname.setText(theme.getName());
        holder.themesdowload.setText(String.valueOf(theme.getDownload()));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                Intent intent = new Intent(context, ThemesActivity.class);
                intent.putExtra("list", m2list);
                intent.putExtra("id", theme.getId());
                intent.putExtra("pos", adapterPosition);
                intent.putExtra("dowload", theme.getDownload());
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }

    static class WappViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView themesname , themesdowload;

        public WappViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.themes_img);
            themesname = itemView.findViewById(R.id.themes_name);
            themesdowload = itemView.findViewById(R.id.themes_dowload);
        }
    }
}
