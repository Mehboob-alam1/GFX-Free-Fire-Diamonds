package com.elevenappstudio.getdailydiamondguide;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseUrlManager {

    private static final String TAG = "FirebaseUrlManager";
    private static FirebaseUrlManager instance;
    private DatabaseReference databaseReference;
    
    // Default fallback values
    private static final String DEFAULT_URL = "https://easyranktools.com";
    private static final boolean DEFAULT_SHOW_ADS = true;
    private static final boolean DEFAULT_SHOW_SURVEY = true;
    
    // Cached values from Firebase
    private String adUrl = DEFAULT_URL;
    private boolean showAds = DEFAULT_SHOW_ADS;
    private boolean showSurvey = DEFAULT_SHOW_SURVEY;

    private FirebaseUrlManager() {
        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("config");
        loadConfig();
    }

    public static synchronized FirebaseUrlManager getInstance() {
        if (instance == null) {
            instance = new FirebaseUrlManager();
        }
        return instance;
    }

    private void loadConfig() {
        // Load Ad URL
        databaseReference.child("adUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    adUrl = snapshot.getValue(String.class);
                    Log.d(TAG, "Ad URL loaded: " + adUrl);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "Failed to load ad URL: " + error.getMessage());
            }
        });

        // Load showAds flag
        databaseReference.child("showAds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Boolean value = snapshot.getValue(Boolean.class);
                    if (value != null) {
                        showAds = value;
                        Log.d(TAG, "showAds loaded from Firebase: " + showAds);
                    } else {
                        showAds = DEFAULT_SHOW_ADS;
                        Log.d(TAG, "showAds is null, using default: " + DEFAULT_SHOW_ADS);
                    }
                } else {
                    showAds = DEFAULT_SHOW_ADS;
                    Log.d(TAG, "showAds doesn't exist in Firebase, using default: " + DEFAULT_SHOW_ADS);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                showAds = DEFAULT_SHOW_ADS;
                Log.e(TAG, "Failed to load showAds, using default: " + error.getMessage());
            }
        });

        // Load showSurvey flag
        databaseReference.child("showSurvey").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Boolean value = snapshot.getValue(Boolean.class);
                    if (value != null) {
                        showSurvey = value;
                        Log.d(TAG, "showSurvey loaded from Firebase: " + showSurvey);
                    } else {
                        showSurvey = DEFAULT_SHOW_SURVEY;
                        Log.d(TAG, "showSurvey is null, using default: " + DEFAULT_SHOW_SURVEY);
                    }
                } else {
                    showSurvey = DEFAULT_SHOW_SURVEY;
                    Log.d(TAG, "showSurvey doesn't exist in Firebase, using default: " + DEFAULT_SHOW_SURVEY);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                showSurvey = DEFAULT_SHOW_SURVEY;
                Log.e(TAG, "Failed to load showSurvey, using default: " + error.getMessage());
            }
        });
    }

    // Getters
    public String getAdUrl() { 
        Log.d(TAG, "getAdUrl() returning: " + adUrl);
        return adUrl; 
    }
    
    public boolean shouldShowAds() { 
        Log.d(TAG, "shouldShowAds() returning: " + showAds);
        return showAds; 
    }
    
    public boolean shouldShowSurvey() { 
        Log.d(TAG, "shouldShowSurvey() returning: " + showSurvey);
        return showSurvey; 
    }
}

