package com.mobile.inter_im;

import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.textfield.TextInputLayout;
import com.mobile.inter_im.databinding.ActivityMainBinding;
import com.mobile.inter_im.model.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    interface RequestUser{
        @GET("/api/users/{uid}")
        Call<UserData> getUser(@Path("uid") String uid);
    }

    private ActivityMainBinding binding;
    public NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar bar = findViewById(R.id.topAppBar);

        /*
        // Configurez la topappbar
        setSupportActionBar(bar);

        // Désactivation de l'affichage du titre
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Activation de l'affichage du logo
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Définition du logo
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestUser requestUser = retrofit.create(RequestUser.class);
        requestUser.getUser("3").enqueue(new Callback<UserData>()
        {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response)
            {
                //bar.setTitle(((UserData.DataClass) response.body().getData()).getFirst_name());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t)
            {
                //bar.setTitle(t.getMessage());
            }
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_search, R.id.navigation_notifications, R.id.navigation_profil).build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}