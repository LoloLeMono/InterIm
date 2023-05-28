package com.mobile.inter_im.ui.search;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.adapter.OffersAdapter;
import com.mobile.inter_im.R;

public class DisplayOffersFragment extends Fragment{
    private SearchViewModel searchViewModel;
    private RecyclerView recyclerView;
    private OffersAdapter offersAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        MainActivity mainActivity = (MainActivity) requireActivity();
        searchViewModel = new ViewModelProvider(mainActivity).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_display_offers, container, false);

        offersAdapter = new OffersAdapter(getContext(), searchViewModel.getOffers());

        System.out.println("Dans display = "+searchViewModel.getOffers());

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(offersAdapter);

        return root;
    }

}