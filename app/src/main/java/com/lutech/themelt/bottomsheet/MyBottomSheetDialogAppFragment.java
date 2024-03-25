package com.lutech.themelt.bottomsheet;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lutech.themelt.R;
import com.lutech.themelt.adapter.ThemesSettingIconAdapter;
import com.lutech.themelt.adapter.ThemesSettingIconAppListAdapter;
import com.lutech.themelt.model.Applist;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyBottomSheetDialogAppFragment extends BottomSheetDialogFragment {
    String imageUrl;
    private Context mContext;
    private List<Applist> systemAppsList;
    Applist man;
    private ThemesSettingIconAppListAdapter systemAppAdapter;

    public interface OnAppSelectedListener {
        void onAppSelected(Drawable appIcon);
    }

    private OnAppSelectedListener mListener;

    public void setOnAppSelectedListener(OnAppSelectedListener listener) {
        mListener = listener;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_list_app, container, false);
        ListView systemApsLv = view.findViewById(R.id.system_app_list);
        systemAppsList = getCustomIconApps();
        systemAppAdapter = new ThemesSettingIconAppListAdapter(getContext(), systemAppsList);
        systemApsLv.setAdapter(systemAppAdapter);
        systemApsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                String[] colors = {" Open App"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Choose Action")
                        .setItems(colors, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) {
                                    Applist tempSelectedApp = systemAppsList.get(i);
                                    mListener.onAppSelected(tempSelectedApp.getIcon());
                                    man =  tempSelectedApp;

                                }
                            }
                        });
                builder.show();
            }
        });

        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnAppSelectedListener) {
            mListener = (OnAppSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnAppSelectedListener");
        }
    }

    private List<Applist> getCustomIconApps() {
        PackageManager pm = getActivity().getPackageManager();
        List<Applist> apps = new ArrayList<>();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            if (!isSystemPackage(packageInfo)) {
                String appName = packageInfo.loadLabel(pm).toString();
                Drawable appIcon = packageInfo.loadIcon(pm);
                if (!isDefaultLauncherIcon(pm, packageInfo.packageName)) {
                    apps.add(new Applist(appName, appIcon, packageInfo.packageName));
                }
            }
        }
        return apps;
    }

    private boolean isSystemPackage(ApplicationInfo packageInfo) {
        return (packageInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    private boolean isDefaultLauncherIcon(PackageManager pm, String packageName) {
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            ComponentName componentName = intent.getComponent();
            if (componentName != null) {
                Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
                for (ResolveInfo resolveInfo : resolveInfos) {
                    if (resolveInfo.activityInfo.packageName.equals(packageName)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
