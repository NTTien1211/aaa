package com.lutech.themelt.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import java.util.ArrayList;
import java.util.List;

public class WidgetSettingColorAdapter extends RecyclerView.Adapter<WidgetSettingColorAdapter.WidgetColorPageHolder> {
    private List<String> colors;
    private Context context;

    private int[] baseColors = {Color.WHITE ,  Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE , Color.CYAN};

    public WidgetSettingColorAdapter(Context context) {
        this.context = context;
        colors = generateShadesOfColors(baseColors, 10);
    }

    @NonNull
    @Override
    public WidgetColorPageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widgetextcolor_recycl, parent, false);
        return new WidgetColorPageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetColorPageHolder holder, int position) {
        String color = colors.get(position);
        holder.widget_settingcolor.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    private List<String> generateShadesOfColors(int[] baseColors, int numOfShades) {
        List<String> shades = new ArrayList<>();

        for (int baseColor : baseColors) {
            float[] hsv = new float[3];
            Color.colorToHSV(baseColor, hsv);
            float baseLightness = hsv[2];

            for (int i = 0; i < numOfShades; i++) {
                float lightness = baseLightness - (i * 0.1f);
                if (lightness < 0) lightness = 0;
                hsv[2] = lightness;
                shades.add(String.format("#%06X", (0xFFFFFF & Color.HSVToColor(hsv))));
            }
        }

        return shades;
    }

    public static class WidgetColorPageHolder extends RecyclerView.ViewHolder {
        ShapeableImageView widget_settingcolor;

        public WidgetColorPageHolder(@NonNull View itemView) {
            super(itemView);
            widget_settingcolor = itemView.findViewById(R.id.widget_settingcolor);
        }
    }


}

