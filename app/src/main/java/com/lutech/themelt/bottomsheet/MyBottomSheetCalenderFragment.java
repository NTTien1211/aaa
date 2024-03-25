package com.lutech.themelt.bottomsheet;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lutech.themelt.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyBottomSheetCalenderFragment extends BottomSheetDialogFragment {
    String imageUrl;
    private Context mContext;
    private static final String IMAGE_URL_KEY = "image_url";

    public static MyBottomSheetCalenderFragment newInstance(String imageUrl) {
        MyBottomSheetCalenderFragment fragment = new MyBottomSheetCalenderFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URL_KEY, imageUrl);


        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog, container, false);
        Button setHomeButton = view.findViewById(R.id.set_home_button);
        Button setClockButton = view.findViewById(R.id.set_clock_button);
        Button setAllButton = view.findViewById(R.id.set_all_button);
        setHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = getArguments().getString(IMAGE_URL_KEY);
                setHomeWallpaper((Activity) mContext,imageUrl );

                dismiss();
            }
        });

        setClockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = getArguments().getString(IMAGE_URL_KEY);
                setLockWallpaper((Activity) mContext,imageUrl );
                dismiss();
            }
        });

        setAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = getArguments().getString(IMAGE_URL_KEY);
                setWallpapers((Activity) mContext,imageUrl );
                dismiss();
            }
        });

        return view;
    }



    public static void setWallpapers(final Activity activity, final String imageUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    final Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity.getApplicationContext());
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    wallpaperManager.setBitmap(myBitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                                    wallpaperManager.setBitmap(myBitmap, null, true, WallpaperManager.FLAG_LOCK);
                                } else {
                                    wallpaperManager.setBitmap(myBitmap);
                                }
                                Toast.makeText(activity, "Wallpapers set successfully", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(activity, "Failed to set wallpapers", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void setHomeWallpaper(final Activity activity, final String imageUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    final Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity.getApplicationContext());
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    wallpaperManager.setBitmap(myBitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                                } else {
                                    wallpaperManager.setBitmap(myBitmap);
                                }
                                Toast.makeText(activity, "Wallpaper set Success", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(activity, "Failed to set Wallpaper", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static void setLockWallpaper(final Activity activity, final String imageUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    final Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity.getApplicationContext());
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    wallpaperManager.setBitmap(myBitmap, null, true, WallpaperManager.FLAG_LOCK);
                                } else {
                                    Toast.makeText(activity, "Lockscreen Wallpaper setting is not supported on this device", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(activity, "Lockscreen Wallpaper set successfully", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(activity, "Failed to set Lockscreen Wallpaper", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
