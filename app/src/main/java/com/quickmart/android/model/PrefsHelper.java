package com.quickmart.android.model;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsHelper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String PREF_NAME = "QuickMartPrefs";

    private static PrefsHelper instance;

    public static final String IS_FIRST_LAUNCH = "is_first_launch";

    private PrefsHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public static synchronized PrefsHelper getInstance(Context context) {
        if (instance == null) {
            instance = new PrefsHelper(context);
        }
        return instance;
    }

    public void setIsFirstLaunch(boolean value) {
        saveBoolean(IS_FIRST_LAUNCH, value);
    }

    public void saveBoolean(String kay, boolean value) {
        editor.putBoolean(kay, value);
        editor.apply();
    }


    public boolean istIsFirstLaunch(){
        return getBoolean(IS_FIRST_LAUNCH);
    }
    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, true);
    }


}
