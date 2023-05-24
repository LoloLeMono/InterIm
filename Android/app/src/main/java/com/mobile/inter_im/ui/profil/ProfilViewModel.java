package com.mobile.inter_im.ui.profil;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.mobile.inter_im.PasswordHasher;
import com.mobile.inter_im.R;
import com.mobile.inter_im.RetrofitInterface;
import com.mobile.inter_im.model.ResultData;
import com.mobile.inter_im.model.UserData;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfilViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private Context context;

    private RetrofitInterface retrofitInterface;

    public void setContext(Context context) {
        this.context = context;
    }

    public ProfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Connexion");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public void fetchDataFromAPI() {
        Call<List<UserData>> call = retrofitInterface.getUsers();
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful()) {
                    List<UserData> userList = response.body();
                    if (userList != null && userList.size() > 0) {
                        UserData user = userList.get(0);
                        System.out.println("Réponse reçue : " + user);
                        // Faites quelque chose avec les données de l'utilisateur, comme les afficher dans une boîte de dialogue
                    }
                } else {
                    System.out.println("Erreur response : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                System.out.println("Erreur failure : " + t.getMessage());
            }
        });
    }

    public void verifyLogin(String mail, String mdp, NavController navController) {

        String mdpHashed = PasswordHasher.hashPassword(mdp);
        System.out.println(mdpHashed);
        UserData user = new UserData(mail, mdpHashed);

        Call<ResultData> call = retrofitInterface.executeLogin(user);
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                if (response.isSuccessful()) {
                    ResultData result = response.body();
                    if (result.getResultat() == 0) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
                        sharedPreferences.edit().putString("mail", mail).apply();
                        changeValSnackbar("Utilisateur trouvé");
                        navController.navigate(R.id.navigation_home); // Naviguer vers le fragment d'accueil
                        System.out.println("Mail = "+mail);
                        System.out.println("UserPreferences mail = "+sharedPreferences.getString("mail", "Pas de valeurs"));
                    }
                    else {
                        System.out.println("mdpHashed ="+mdpHashed);
                        changeValSnackbar("Mail ou mot de passe incorrect");
                    }
                } else {
                    System.out.println("Erreur response : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {
                System.out.println("Erreur failure : " + t.getMessage());
            }
        });
    }

    public LiveData<String> getText() {
        return mText;
    }

    private MutableLiveData<String> snackbarMessage = new MutableLiveData<>();

    public void changeValSnackbar(String s) {
        // Effectuer une action
        snackbarMessage.setValue(s);
    }
    public LiveData<String> getSnackbarMessage()
    {
        return snackbarMessage;
    }
}