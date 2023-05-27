package com.mobile.inter_im.ui.home;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public HomeViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("Découvrez votre futur job !");
    }

    public LiveData<String> getText() {
        return mText;
    }
}