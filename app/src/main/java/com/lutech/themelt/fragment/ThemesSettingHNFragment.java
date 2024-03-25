package com.lutech.themelt.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.bottomsheet.MyBottomSheetDialogFragment;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.ThemesModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ThemesSettingHNFragment extends Fragment {

    RelativeLayout relativeLayout;
    ShapeableImageView imageView;
    ThemesModel themesModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_themes_setting_h_n, container, false);
        relativeLayout = view.findViewById(R.id.layout_build);
        imageView = view.findViewById(R.id.imvCornerCutTwo);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id", 0);
            themesModel = JsonUtils.getThemeById(getContext(), id);
            String url = themesModel.getImg();
            Picasso.get().load(url).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    imageView.setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
                }
            });


        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (themesModel != null) {
                    MyBottomSheetDialogFragment bottomSheetDialogFragment = MyBottomSheetDialogFragment.newInstance(themesModel.getImgwallpaper());
                    bottomSheetDialogFragment.show(getChildFragmentManager(), bottomSheetDialogFragment.getTag());
                } else {
                    Toast.makeText(getContext(), "Themes Model is null", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  view;
    }
}