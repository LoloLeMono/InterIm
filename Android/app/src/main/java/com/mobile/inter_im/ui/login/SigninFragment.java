package com.mobile.inter_im.ui.login;

import android.os.Bundle;
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
import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.R;
import com.mobile.inter_im.databinding.FragmentLoginBinding;
import com.mobile.inter_im.databinding.FragmentSigninBinding;
import com.mobile.inter_im.model.UserData;
import com.mobile.inter_im.ui.home.HomeFragment;
import com.mobile.inter_im.ui.profil.ProfilFragment;
import com.mobile.inter_im.user.UserViewModel;

public class SigninFragment extends Fragment
{

    private FragmentSigninBinding binding;
    MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setContext(requireContext());
        mainActivity = (MainActivity) getActivity();

        binding = FragmentSigninBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button buttonNext = root.findViewById(R.id.button_next);
        Button buttonStop = root.findViewById(R.id.button_stop);

        TextInputLayout nomEditLayout = root.findViewById(R.id.textField_nom);
        TextInputLayout prenomEditLayout = root.findViewById(R.id.textField_prenom);
        TextInputLayout mailEditLayout = root.findViewById(R.id.textField_mail);
        TextInputLayout phoneEditLayout = root.findViewById(R.id.textField_phone);
        TextInputLayout natEditLayout = root.findViewById(R.id.textField_nat);
        TextInputLayout adrEditLayout = root.findViewById(R.id.textField_address);
        TextInputLayout townEditLayout = root.findViewById(R.id.textField_town);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomText = nomEditLayout.getEditText().getText().toString();
                String prenomText = prenomEditLayout.getEditText().getText().toString();
                String mailText = mailEditLayout.getEditText().getText().toString();
                String phoneText = phoneEditLayout.getEditText().getText().toString();
                String natText = natEditLayout.getEditText().getText().toString();
                String adrText = adrEditLayout.getEditText().getText().toString();
                String townText = townEditLayout.getEditText().getText().toString();

                loginViewModel.setUser(new UserData(
                        nomText,
                        prenomText,
                        mailText,
                        phoneText,
                        natText,
                        adrText,
                        townText
                ));

                mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(new SigninEndFragment());
                System.out.println(loginViewModel.getUser());
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.replaceFragment(new LoginFragment());
            }
        });

        return root;
    }
}