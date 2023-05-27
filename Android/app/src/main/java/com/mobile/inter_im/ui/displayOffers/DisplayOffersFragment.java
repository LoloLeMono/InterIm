package com.mobile.inter_im.ui.displayOffers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.inter_im.R;
import com.mobile.inter_im.model.SendOfferData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DisplayOffersFragment extends Fragment
{
    private List<SendOfferData> liOffers;
    private DisplayOffersViewModel mViewModel;

    public static DisplayOffersFragment newInstance()
    {
        return new DisplayOffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        System.out.println("Dans display = "+this.getArguments().getString("offersListJson"));

        mViewModel = new ViewModelProvider(this).get(DisplayOffersViewModel.class);
        return inflater.inflate(R.layout.fragment_display_offers, container, false);
    }

}