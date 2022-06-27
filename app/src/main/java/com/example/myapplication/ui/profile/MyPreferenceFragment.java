package com.example.myapplication.ui.profile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.myapplication.R;

public class MyPreferenceFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String DEFAULT_VALUE = "-";
    private String NAME;
    private String EMAIL;
    private String PHONE;
    private String ADDRESS;
    private EditTextPreference namePreference;
    private EditTextPreference emailPreference;
    private EditTextPreference phonePreference;
    private EditTextPreference addressPreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
        init();
        setSummeries();
    }

    private void setSummeries() {
        SharedPreferences sh = getPreferenceManager().getSharedPreferences();
        namePreference.setSummary(sh.getString(NAME, DEFAULT_VALUE));
        emailPreference.setSummary(sh.getString(EMAIL, DEFAULT_VALUE));
        phonePreference.setSummary(sh.getString(PHONE, DEFAULT_VALUE));
        addressPreference.setSummary(sh.getString(ADDRESS, DEFAULT_VALUE));
    }

    private void init() {
        NAME = getResources().getString(R.string.name);
        EMAIL = getResources().getString(R.string.email);
        PHONE = getResources().getString(R.string.phone);
        ADDRESS = getResources().getString(R.string.address);
        namePreference = findPreference(NAME);
        emailPreference = findPreference(EMAIL);
        phonePreference = findPreference(PHONE);
        addressPreference = findPreference(ADDRESS);
    }

    @Override
    public void onResume(){
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(NAME)) {
            namePreference.setSummary(sharedPreferences.getString(NAME, DEFAULT_VALUE));
        }
        if (key.equals(EMAIL)) {
            emailPreference.setSummary(sharedPreferences.getString(EMAIL, DEFAULT_VALUE));
        }
        if (key.equals(PHONE)) {
            phonePreference.setSummary(sharedPreferences.getString(PHONE, DEFAULT_VALUE));
        }
        if (key.equals(ADDRESS)) {
            addressPreference.setSummary(sharedPreferences.getString(ADDRESS, DEFAULT_VALUE));
        }
    }
}