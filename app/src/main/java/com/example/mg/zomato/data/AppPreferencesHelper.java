
package com.example.mg.zomato.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mg.zomato.app.DI.IApplicationContext;
import com.example.mg.zomato.app.DI.IApplicationScope;
import com.google.gson.Gson;

import javax.inject.Inject;

@IApplicationScope
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_PROFILE = "PREF_KEY_CURRENT_USER_NAME";

    private final SharedPreferences mPrefs;
    private Gson gson = new Gson();
    private String json;

    @Inject
    public AppPreferencesHelper(@IApplicationContext Context context) {
        mPrefs = context.getSharedPreferences("mindorks_pref", Context.MODE_PRIVATE);
    }

/*    @Override
    public ProfileModel getSavedData() {
        Type type = new TypeToken<ProfileModel>() {
        }.getType();
        json = mPrefs.getString(PREF_KEY_PROFILE, "");
        return gson.fromJson(json, type);

    }

    @Override
    public void setDataToPrefs(ProfileModel model) {
        json = gson.toJson(model);
        mPrefs.edit().putString(PREF_KEY_PROFILE, json).apply();
    }*/


}
