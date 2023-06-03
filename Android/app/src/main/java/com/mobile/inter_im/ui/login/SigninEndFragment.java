package com.mobile.inter_im.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.PasswordHasher;
import com.mobile.inter_im.R;
import com.mobile.inter_im.databinding.FragmentSigninBinding;
import com.mobile.inter_im.databinding.FragmentSigninEndBinding;
import com.mobile.inter_im.model.UserData;
import com.mobile.inter_im.ui.profil.ProfilFragment;

public class SigninEndFragment extends Fragment
{

    private FragmentSigninEndBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setContext(requireContext());
        MainActivity mainActivity = (MainActivity) getActivity();

        binding = FragmentSigninEndBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button_create = root.findViewById(R.id.button_create);
        Button button_back = root.findViewById(R.id.button_backEnd);
        TextInputLayout subEditLayout = root.findViewById(R.id.textField_sub);
        TextInputLayout passEditLayout = root.findViewById(R.id.textField_password);

        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subText = subEditLayout.getEditText().getText().toString();
                String passText = passEditLayout.getEditText().getText().toString();
                String hashPass = PasswordHasher.hashPassword(passText);
                loginViewModel.setMdp(hashPass);
                loginViewModel.setAbo(subText);
                loginViewModel.createUser();

                mainActivity.replaceFragment(new LoginFragment());
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.replaceFragment(new SigninFragment());
            }
        });

        return root;
    }
}