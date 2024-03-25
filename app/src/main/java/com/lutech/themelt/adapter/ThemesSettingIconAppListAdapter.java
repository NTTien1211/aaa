package com.lutech.themelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lutech.themelt.R;
import com.lutech.themelt.model.Applist;

import java.util.List;

public class ThemesSettingIconAppListAdapter extends BaseAdapter {
    public LayoutInflater layoutInflater;

    public List<Applist> listStorage;
    public ThemesSettingIconAppListAdapter(Context context, List<Applist> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int mLastPosition = 0;
        float initialTranslation = (mLastPosition <= position ? 500f : -500f);

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.installed_app_list, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.list_app_name);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.app_icon);
            listViewHolder.packageInListView = (TextView)convertView.findViewById(R.id.app_package);


            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(listStorage.get(position).getIcon());


        return convertView;
    }

    class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
        TextView packageInListView;
    }
}