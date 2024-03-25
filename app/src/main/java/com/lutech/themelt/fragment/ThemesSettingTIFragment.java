package com.lutech.themelt.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.lutech.themelt.R;
import com.lutech.themelt.json.JsonUtils;
import com.lutech.themelt.model.WidgetModel;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class ThemesSettingTIFragment extends Fragment {
    ArrayList<WidgetModel> widgets = new ArrayList<WidgetModel>();
    ShapeableImageView mImageViewTime, mImageViewDaily , mImageViewCalendar ;
    TextView textview_wg_day, textview_wg_month,textview_wg_time,tv_dailyquot;
    Calendar calendar = Calendar.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_themes_setting_t_i, container, false);
        anhxa(view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id", 0);
            widgets = JsonUtils.extractWidgetsByThemeId(getContext(),id);
            for (WidgetModel widget : widgets) {
                if ("Digital Clock".equals(widget.getType())) {
                    loadImageIntoImageView(widget.getImgsmall(), mImageViewTime);
                } else if ("Daily Quote".equals(widget.getType())) {
                    loadImageIntoImageView(widget.getImgsmall(), mImageViewDaily);
                } else if ("Calendar".equals(widget.getType())) {
                    loadImageIntoImageView(widget.getImgsmall(), mImageViewCalendar);
                }
            }

        }
        if (widgets.isEmpty()) {
            loadImageIntoImageView("https://i.pinimg.com/originals/e9/73/4c/e9734c86285016e477d6a5d100f80ccd.jpg", mImageViewTime);
            loadImageIntoImageView("https://i.pinimg.com/originals/e9/73/4c/e9734c86285016e477d6a5d100f80ccd.jpg", mImageViewDaily);
            loadImageIntoImageView("https://i.pinimg.com/originals/e9/73/4c/e9734c86285016e477d6a5d100f80ccd.jpg", mImageViewCalendar);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayName = getDayName(dayOfWeek);
        textview_wg_day.setText(dayName);


        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String monthName = getMonthName(month);
        String date = String.format(Locale.ENGLISH, "%s %d", monthName, dayOfMonth);
        textview_wg_month.setText(date);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String time = String.format(Locale.ENGLISH, "%02d:%02d", hour, minute);
        textview_wg_time.setText(time);

        return view;
    }
    private String getDayName(int dayOfWeek) {
        String[] dayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[dayOfWeek - 1];
    }

    private String getMonthName(int month) {
        String[] monthNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
    private void anhxa(View view) {
        mImageViewTime = view.findViewById(R.id.imageViewtime);
        mImageViewDaily = view.findViewById(R.id.imageViewdaily);
        mImageViewCalendar = view.findViewById(R.id.imageViewcalender);
        textview_wg_day = view.findViewById(R.id.textview_wg_day);
        textview_wg_month = view.findViewById(R.id.textview_wg_month);
        textview_wg_time = view.findViewById(R.id.textview_wg_time);
        tv_dailyquot = view.findViewById(R.id.tv_dailyquot);
    }

    private void loadImageIntoImageView(String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}