package com.lutech.themelt.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lutech.themelt.R;
import com.lutech.themelt.appinf.PackageInformation;

import java.util.ArrayList;

public class ThemesIconAppListSystemAdapter extends BaseAdapter {
    private ArrayList<PackageInformation.InfoObject> mObjectApps;
    private Context mContext;

    public ThemesIconAppListSystemAdapter(Context context, ArrayList<PackageInformation.InfoObject> apps) {
        this.mContext = context;
        this.mObjectApps = apps;
    }

    @Override
    public int getCount() {
        return mObjectApps.size();
    }

    @Override
    public Object getItem(int position) {
        return mObjectApps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        convertView = inflater.inflate(R.layout.layout_adapter_custom_app_list, parent, false);
        holder = new ViewHolder();
        holder.appName = (TextView) convertView.findViewById(R.id.text_app_name);
        holder.appIcon = (ImageView) convertView.findViewById(R.id.image_app_icon);
        holder.appOption = (ImageView) convertView.findViewById(R.id.image_option);
        final PackageInformation.InfoObject infoObject = mObjectApps.get(position);
        holder.appName.setText(infoObject.appname);
        holder.appIcon.setImageDrawable(infoObject.icon);
        holder.appOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open the specific App Info page:
                String packageName = infoObject.packagename;
                try {
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + packageName));
                    mContext.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    //Open the generic Apps manager
                    Intent intent = new Intent(Settings.ACTION_SETTINGS);
                    mContext.startActivity(intent);
                }
            }
        });
        return convertView;
    }
    private class ViewHolder {
        TextView appName;
        TextView appVersion;
        ImageView appIcon;
        ImageView appOption;
    }
}