package com.mobile.inter_im.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.mobile.inter_im.R;
import com.mobile.inter_im.databinding.FragmentSearchBinding;
import com.mobile.inter_im.model.SendOfferData;
import com.mobile.inter_im.ui.displayOffers.DisplayOffersFragment;

import java.io.Console;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        searchViewModel.setContext(requireContext());

        // NavController navController = NavHostFragment.findNavController(this);
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button buttonSearch = root.findViewById(R.id.button_search);
        DatePicker dateDeb = root.findViewById(R.id.date_deb);
        TextInputLayout townLayout = root.findViewById(R.id.search_textField_town);
        TextInputLayout sectorLayout = root.findViewById(R.id.search_textField_sect);

        buttonSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                long day = dateDeb.getDayOfMonth();
                long month = dateDeb.getMonth()+1;
                long year = dateDeb.getYear();
                long parseDateDeb = year * 10000L + month * 100L + day;
                //long parseDateFin = dateFin.getDayOfMonth() * 10000L + dateFin.getMonth()+1 * 100L + dateFin.getYear();

                String town = townLayout.getEditText().getText().toString();
                String sector = sectorLayout.getEditText().getText().toString().toLowerCase(Locale.ROOT);

                System.out.println("Début : "+parseDateDeb+", Ville : "+town+", Secteur : "+sector);

                //searchViewModel.sendDatas(parseDateDeb, sector, town, navController);
            }
        });

        searchViewModel.getSendOfferDataList().observe(getViewLifecycleOwner(), new Observer<List<SendOfferData>>() {
            @Override
            public void onChanged(List<SendOfferData> sendOfferDataList) {
                // Créer une instance du fragment de destination
                Gson gson = new Gson();
                String offersListJson = gson.toJson(sendOfferDataList);
                Bundle args = new Bundle();
                args.putString("offersListJson", offersListJson);

                DisplayOffersFragment fragment = new DisplayOffersFragment();
                fragment.setArguments(args);
                System.out.println("Dans search = "+fragment.getArguments().getString("offersListJson"));
                // navController.navigate(R.id.navigation_displayOffers);
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}