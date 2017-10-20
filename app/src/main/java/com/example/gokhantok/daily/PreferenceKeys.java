package com.example.gokhantok.daily;

import android.content.res.Resources;import com.example.gokhantok.daily.R;import java.lang.String;

public class PreferenceKeys {
    final String night_mode_pref_key;

    public PreferenceKeys(Resources resources){
        night_mode_pref_key = resources.getString(R.string.night_mode_pref_key);
    }
}
