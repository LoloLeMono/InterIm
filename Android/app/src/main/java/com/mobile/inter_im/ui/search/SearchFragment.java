package com.mobile.inter_im.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.R;
import com.mobile.inter_im.databinding.FragmentSearchBinding;
import com.mobile.inter_im.model.OfferData;

import java.util.List;
import java.util.Locale;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity) requireActivity();
        searchViewModel = new ViewModelProvider(mainActivity).get(SearchViewModel.class);

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

                searchViewModel.sendDatas(parseDateDeb, sector, town);
            }
        });

        searchViewModel.getSendOfferDataList().observe(getViewLifecycleOwner(), new Observer<List<OfferData>>() {
            @Override
            public void onChanged(List<OfferData> offerDataList) {
                // Créer une instance du fragment de destination
                Gson gson = new Gson();
                String offersListJson = gson.toJson(offerDataList);
                System.out.println("Dans search = "+searchViewModel.getOffers());

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(new DisplayOffersFragment());
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