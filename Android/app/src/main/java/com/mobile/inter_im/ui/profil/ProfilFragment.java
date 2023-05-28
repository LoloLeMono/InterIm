package com.mobile.inter_im.ui.profil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.mobile.inter_im.databinding.FragmentProfilBinding;
import com.mobile.inter_im.user.UserViewModel;

public class ProfilFragment extends Fragment
{
    private FragmentProfilBinding binding;
    public UserViewModel userViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        binding.titleName.setText(sharedPreferences.getString("nom", "ERROR")+" "+sharedPreferences.getString("prenom", ""));
        binding.textFieldPhone.getEditText().setText(sharedPreferences.getString("telephone", "ERROR"));
        binding.textFieldNat.getEditText().setText(sharedPreferences.getString("nationalite", "ERROR"));
        binding.textFieldAddr.getEditText().setText(sharedPreferences.getString("adresse", "ERROR"));
        binding.textFieldTown.getEditText().setText(sharedPreferences.getString("ville", "ERROR"));
        binding.textFieldBio.getEditText().setText(sharedPreferences.getString("bio", "ERROR"));
        binding.textFieldType.getEditText().setText(sharedPreferences.getString("type", "ERROR"));
        binding.textFieldSub.getEditText().setText(sharedPreferences.getString("abo", "ERROR"));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}