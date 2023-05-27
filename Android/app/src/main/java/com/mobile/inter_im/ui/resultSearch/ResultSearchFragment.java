package com.mobile.inter_im.ui.resultSearch;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.inter_im.R;

public class ResultSearchFragment extends Fragment
{

    private ResultSearchViewModel mViewModel;

    public static ResultSearchFragment newInstance()
    {
        return new ResultSearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        mViewModel = new ViewModelProvider(this).get(ResultSearchViewModel.class);
        return inflater.inflate(R.layout.fragment_result_search, container, false);
    }

}