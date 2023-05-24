package com.mobile.inter_im.ui.profil;

import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.mobile.inter_im.R;
import com.mobile.inter_im.RetrofitInterface;
import com.mobile.inter_im.databinding.FragmentNotificationsBinding;
import com.mobile.inter_im.databinding.FragmentProfilBinding;
import com.mobile.inter_im.model.UserData;
import com.mobile.inter_im.user.UserViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfilFragment extends Fragment {

    private FragmentProfilBinding binding;
    public UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState)
    {
        ProfilViewModel profilViewModel = new ViewModelProvider(this).get(ProfilViewModel.class);
        profilViewModel.setContext(requireContext());

        NavController navController = NavHostFragment.findNavController(this);

        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLoginTitle;
        profilViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button buttonLogin = root.findViewById(R.id.button_login);
        TextInputLayout mailEditLayout = root.findViewById(R.id.textField_menu);
        TextInputLayout mdpEditLayout = root.findViewById(R.id.textField2_menu);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailText = mailEditLayout.getEditText().getText().toString();
                String mdpText = mdpEditLayout.getEditText().getText().toString();
                //profilViewModel.fetchDataFromAPI();
                profilViewModel.verifyLogin(mailText, mdpText, navController);
            }
        });

        profilViewModel.getSnackbarMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show();
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