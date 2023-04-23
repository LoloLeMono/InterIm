package com.mobile.inter_im.ui.profil;

import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mobile.inter_im.R;
import com.mobile.inter_im.databinding.FragmentProfilBinding;

public class ProfilFragment extends Fragment {

private FragmentProfilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        ProfilViewModel profilViewModel =
                new ViewModelProvider(this).get(ProfilViewModel.class);

        Button boutonLogin;
        View view = inflater.inflate(R.layout.fragment_profil,container,false);
        boutonLogin = (Button) view.findViewById(R.id.button_login);
        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLoginDialog();
            }
        });

        Button boutonSignup;
        boutonSignup = (Button) view.findViewById(R.id.button_register);
        boutonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSignupDialog();
            }
        });

    binding = FragmentProfilBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        /*final TextView textView = binding.textProfil;
        profilViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return root;
    }

    private void handleLoginDialog() {
        View view = getLayoutInflater().inflate(R.layout.fragment_profil, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setView(view).show();
    }

    private void handleSignupDialog() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}