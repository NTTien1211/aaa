package com.lutech.themelt.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.bottomsheet.MyBottomSheetDialogAppFragment;
import com.lutech.themelt.model.IconsModel;

import java.util.List;

public class ThemesSettingIconAdapter extends RecyclerView.Adapter<ThemesSettingIconAdapter.Icon_viewHolder> implements MyBottomSheetDialogAppFragment.OnAppSelectedListener {
    // Phần code hiện có{
    List<IconsModel> mlist ;
    Context context ;
    Drawable selectedAppIcon;
    public ThemesSettingIconAdapter(List<IconsModel> modelList , Context context) {
        this.mlist = modelList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Icon_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_itemrecycle_child, parent, false);
        return new ThemesSettingIconAdapter.Icon_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Icon_viewHolder holder, int position) {
        IconsModel model = mlist.get(position);
        Glide.with(context)
                .load(model.getImgsmal())
                .into(holder.imageView1);

        if (selectedAppIcon != null) {
            holder.imageView2.setImageDrawable(selectedAppIcon);
        }

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBottomSheetDialogAppFragment bottomSheetDialogFragment = new MyBottomSheetDialogAppFragment();
                bottomSheetDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });
    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public void onAppSelected(Drawable appIcon) {
        selectedAppIcon = appIcon;
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

    public class Icon_viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1 ;
        Button settting_iconThemeslock , settting_iconThemes;
        ShapeableImageView imageView2;
        LinearLayout layout;
        public Icon_viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.icon_data_theme);
            imageView2 = itemView.findViewById(R.id.icon_datachange_theme);
            settting_iconThemeslock = itemView.findViewById(R.id.settting_iconThemeslock);
            settting_iconThemes = itemView.findViewById(R.id.settting_iconThemes);
            layout = itemView.findViewById(R.id.linner_layout);

        }
    }
}
