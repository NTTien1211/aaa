package com.lutech.themelt.json;

import android.content.Context;
import android.content.res.Resources;


import com.lutech.themelt.R;
import com.lutech.themelt.model.FrameModel;
import com.lutech.themelt.model.IconsModel;
import com.lutech.themelt.model.ThemesIconModel;
import com.lutech.themelt.model.ThemesModel;
import com.lutech.themelt.model.WidgetModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static ArrayList<ThemesModel> extractImgUrls(Context context) {
        ArrayList<ThemesModel> themesList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray themesArray = jsonObject.getJSONArray("Themes");
            for (int i = 0; i < themesArray.length(); i++) {
                JSONObject themeObject = themesArray.getJSONObject(i);
                JSONObject detailsObject = themeObject.getJSONObject("details");
                JSONObject imagesObject = themeObject.getJSONObject("images");
                int id = themeObject.getInt("id");
                String imgUrl = imagesObject.getString("img");
                String themeName = themeObject.getString("name");
                int downloadCount = detailsObject.getInt("download");
                ThemesModel theme = new ThemesModel(id,themeName, downloadCount ,imgUrl);
                themesList.add(theme);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return themesList;
    }
    public static  ArrayList<ThemesModel> extractImgUrlsByType(Context context, String type) {
        ArrayList<ThemesModel> themesList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray themesArray = jsonObject.getJSONArray("Themes");
            for (int i = 0; i < themesArray.length(); i++) {
                JSONObject themeObject = themesArray.getJSONObject(i);
                JSONObject detailsObject = themeObject.getJSONObject("details");
                JSONObject imagesObject = themeObject.getJSONObject("images");
                String themeType = detailsObject.getString("type");
                if (themeType.equals(type)) {
                    int id = themeObject.getInt("id");
                    String imgUrl = imagesObject.getString("img");
                    String themeName = themeObject.getString("name");
                    int downloadCount = detailsObject.getInt("download");
                    ThemesModel theme = new ThemesModel(id ,themeName, downloadCount, imgUrl);
                    themesList.add(theme);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return themesList;
    }

    public static ThemesModel getThemeById(Context context, int id) {
        ThemesModel theme = null;
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray themesArray = jsonObject.getJSONArray("Themes");
            for (int i = 0; i < themesArray.length(); i++) {
                JSONObject themeObject = themesArray.getJSONObject(i);
                int themeId = themeObject.getInt("id");
                if (themeId == id) {
                    JSONObject detailsObject = themeObject.getJSONObject("details");
                    JSONObject imagesObject = themeObject.getJSONObject("images");
                    String imgUrl = imagesObject.getString("img");
                    String imgUrlBr = imagesObject.getString("imgwallpaper");
                    String themeName = themeObject.getString("name");
                    int downloadCount = detailsObject.getInt("download");
                    theme = new ThemesModel(themeId, themeName, downloadCount, imgUrl , imgUrlBr);
                    break;
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return theme;
    }
    public static ArrayList<IconsModel> extractIconsByThemeId(Context context, int themeId) {
        ArrayList<IconsModel> iconsList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray iconsArray = jsonObject.getJSONArray("Icons");
            for (int i = 0; i < iconsArray.length(); i++) {
                JSONObject iconObject = iconsArray.getJSONObject(i);
                int iconThemeId = iconObject.getInt("idtheme");
                if (iconThemeId == themeId) {
                    int iconId = iconObject.getInt("id");
                    String iconUrl = iconObject.getJSONObject("image").getString("url");
                    int iconStatus = iconObject.getInt("status");
                    IconsModel icon = new IconsModel(iconId, iconUrl, iconThemeId, iconStatus);
                    iconsList.add(icon);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return iconsList;
    }
    public static ArrayList<ThemesIconModel> extractThemesAndIcons(Context context) {
        ArrayList<ThemesIconModel> themesIconsList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);

            JSONArray themesArray = jsonObject.getJSONArray("Themes");
            JSONArray iconsArray = jsonObject.getJSONArray("Icons");

            for (int i = 0; i < themesArray.length(); i++) {
                JSONObject themeObject = themesArray.getJSONObject(i);
                int themeId = themeObject.getInt("id");
                String themeName = themeObject.getString("name");

                List<String> iconUrls = new ArrayList<>();
                for (int j = 0; j < iconsArray.length(); j++) {
                    JSONObject iconObject = iconsArray.getJSONObject(j);
                    int iconThemeId = iconObject.getInt("idtheme");
                    int iconType = iconObject.getInt("type");
                    if (iconThemeId == themeId && iconType == 1) {
                        String iconUrl = iconObject.getJSONObject("image").getString("url");
                        iconUrls.add(iconUrl);
                    }
                }

                if (!iconUrls.isEmpty()) {
                    ThemesIconModel themeIconModel = new ThemesIconModel(themeId, themeName, iconUrls);
                    themesIconsList.add(themeIconModel);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return themesIconsList;
    }

    public static ArrayList<WidgetModel> extractWidgetsByThemeId(Context context, int themeId) {
        ArrayList<WidgetModel> widgetsList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);

            JSONArray widgetsArray = jsonObject.getJSONArray("Widgets");

            for (int i = 0; i < widgetsArray.length(); i++) {
                JSONObject widgetObject = widgetsArray.getJSONObject(i);
                int widgetThemeId = widgetObject.getInt("theme_id");

                if (widgetThemeId == themeId) {
                    int widgetId = widgetObject.getInt("id");
                    String widgetType = widgetObject.getString("type");
                    JSONObject imagesObject = widgetObject.getJSONObject("images");
                    String widgetSmallImg = imagesObject.getString("small");
                    String widgetBigImg = imagesObject.getString("big");

                    WidgetModel widgetModel = new WidgetModel();
                    widgetModel.setId(widgetId);
                    widgetModel.setType(widgetType);
                    widgetModel.setImgsmall(widgetSmallImg);
                    widgetModel.setImgbig(widgetBigImg);

                    widgetsList.add(widgetModel);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return widgetsList;
    }
    public static ArrayList<WidgetModel> extractWidgets(Context context, String targetType) {
        ArrayList<WidgetModel> widgetsList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);

            JSONArray widgetsArray = jsonObject.getJSONArray("Widgets");

            for (int i = 0; i < widgetsArray.length(); i++) {
                JSONObject widgetObject = widgetsArray.getJSONObject(i);
                String widgetType = widgetObject.getString("type");
                if (widgetType.equals(targetType)) {
                    int widgetId = widgetObject.getInt("id");
                    JSONObject imagesObject = widgetObject.getJSONObject("images");
                    String widgetSmallImg = imagesObject.getString("small");
                    String widgetBigImg = imagesObject.getString("big");

                    WidgetModel widgetModel = new WidgetModel();
                    widgetModel.setId(widgetId);
                    widgetModel.setType(widgetType);
                    widgetModel.setImgsmall(widgetSmallImg);
                    widgetModel.setImgbig(widgetBigImg);

                    widgetsList.add(widgetModel);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return widgetsList;
    }
    public static ArrayList<FrameModel> extractFrame(Context context) {
        ArrayList<FrameModel> frameList = new ArrayList<>();
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.data);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);

            JSONArray frameArray = jsonObject.getJSONArray("Frame");
            for (int i = 0; i < frameArray.length(); i++) {
                JSONObject frameObject = frameArray.getJSONObject(i);
                int id = frameObject.getInt("id");
                JSONObject imagesObject = frameObject.getJSONObject("images");
                String smallImageUrl = imagesObject.getString("small");
                String bigImageUrl = imagesObject.getString("big");
                FrameModel frameModel = new FrameModel(id, smallImageUrl, bigImageUrl);
                frameList.add(frameModel);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return frameList;
    }


}
