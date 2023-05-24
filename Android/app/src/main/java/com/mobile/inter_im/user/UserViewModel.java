package com.mobile.inter_im.user;

import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel
{
    private SharedPreferences sharedPreferences;

    public UserViewModel(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveUserInfo(String username, int age) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putInt("age", age);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    public int getAge() {
        return sharedPreferences.getInt("age", 0);
    }
}

