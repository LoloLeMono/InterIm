package com.mobile.inter_im;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import android.content.SharedPreferences;

import com.mobile.inter_im.databinding.ActivityMainBinding;
import com.mobile.inter_im.ui.home.HomeFragment;
import com.mobile.inter_im.ui.login.LoginFragment;
import com.mobile.inter_im.ui.notifications.NotificationsFragment;
import com.mobile.inter_im.ui.profil.ProfilFragment;
import com.mobile.inter_im.ui.search.SearchFragment;

public class MainActivity extends AppCompatActivity {

    //public NavController navController;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        MaterialToolbar bar = findViewById(R.id.topAppBar);
        setSupportActionBar(bar);

        SharedPreferences sharedPreferences = this.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isConnected", false).apply();

        boolean isConnected = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE).getBoolean("isConnected", false); // Récupérez la valeur de isConnected depuis les SharedPreferences
        System.out.println("isConnected = "+isConnected);

        // BottomNavigationView navView = findViewById(R.id.nav_view);
        // BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        binding.navView.setOnItemSelectedListener(item ->
        {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_search:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.navigation_notifications:
                    replaceFragment(new NotificationsFragment());
                    break;
                case R.id.navigation_profil:
                    if (isConnected) {
                        replaceFragment(new ProfilFragment());
                    } else {
                        replaceFragment(new LoginFragment());
                    }
                    break;
            }
            return true;
        });




        // AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_search, R.id.navigation_notifications, R.id.navigation_profil).build();
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.commit();
    }

}