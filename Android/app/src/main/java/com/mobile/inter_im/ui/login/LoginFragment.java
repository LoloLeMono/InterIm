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
import com.mobile.inter_im.model.UserData;
import com.mobile.inter_im.ui.home.HomeFragment;
import com.mobile.inter_im.ui.profil.ProfilFragment;
import com.mobile.inter_im.user.UserViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState)
    {
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setContext(requireContext());

        //NavController navController = NavHostFragment.findNavController(this);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLoginTitle;
        loginViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button buttonLogin = root.findViewById(R.id.button_login);
        Button buttonRegister = root.findViewById(R.id.button_register);
        TextInputLayout mailEditLayout = root.findViewById(R.id.textField_menu);
        TextInputLayout mdpEditLayout = root.findViewById(R.id.textField2_menu);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailText = mailEditLayout.getEditText().getText().toString();
                String mdpText = mdpEditLayout.getEditText().getText().toString();

                loginViewModel.verifyLogin(mailText, mdpText/*, navController*/);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(new SigninFragment());
            }
        });

        loginViewModel.getSnackbarMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show();
                mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(new ProfilFragment());
            }
        });

        return root;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}