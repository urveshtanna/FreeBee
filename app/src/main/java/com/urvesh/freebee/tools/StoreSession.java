package com.urvesh.freebee.tools;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class StoreSession {

    public static final java.lang.String CAMERA_ORIENTATION = "camera_orientation";

    private String MY_PREF = "xmajdle";

    private Context mContext;
    SharedPreferences mSharedPreference;
    SharedPreferences.Editor mEditor;
    ;

    public StoreSession(Context context) {
        this.mContext = context;
        if (context != null) {
            mSharedPreference = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE); // 0 - for private mode
            mEditor = mSharedPreference.edit();
            mEditor.commit();
        }
    }


    public void storeVariable(String key, String value) {
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public void storeVariable(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    public void storeVariable(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    public void storeVariable(String key, Set<String> value) {
        mEditor.putStringSet(key, value);
        mEditor.apply();
    }

    public boolean hasValue(String key) {
        return mSharedPreference.contains(key);
    }

    public String retrieveVariable(String key) {
        return mSharedPreference.getString(key, null);
    }

    public String retrieveVariable(String key, String defaultValue) {
        return mSharedPreference.getString(key, defaultValue);
    }

    public int retrieveVariable(String key, int defaultValue) {
        return mSharedPreference.getInt(key, defaultValue);
    }

    public boolean retrieveBoolean(String key, boolean defaultValue) {
        return mSharedPreference.getBoolean(key, defaultValue);
    }


    public void clearData() {
        mEditor.clear();
        mEditor.apply();
    }

    public void deleteVariable(String key) {
        mEditor.remove(key);
        mEditor.apply();
    }
}
