package com.mobile.inter_im.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.PasswordHasher;
import com.mobile.inter_im.R;
import com.mobile.inter_im.RetrofitInterface;
import com.mobile.inter_im.model.ResultData;
import com.mobile.inter_im.model.UserData;
import com.mobile.inter_im.ui.home.HomeFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private Context context;
    private final RetrofitInterface retrofitInterface;
    public static UserData user;

    public void setContext(Context context) {
        this.context = context;
    }

    public LoginViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Connexion");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public void verifyLogin(String mail, String mdp/*, NavController navController*/) {

        String mdpHashed = PasswordHasher.hashPassword(mdp);
        System.out.println(mdpHashed);
        UserData user = new UserData(mail, mdpHashed);

        Call<UserData> call = retrofitInterface.executeLogin(user);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    UserData result = response.body();
                    if (result != null) {
                        saveData(result);
                        System.out.println("Nom = "+result.getNom());
                        System.out.println("Prenom = "+result.getPrenom());

                        System.out.println("UserPreferences mail = "+context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE).getString("mail", "Pas de valeurs"));

                        changeValSnackbar("Utilisateur trouvé");
                    }
                    else {
                        changeValSnackbar("Mail ou mot de passe incorrect");
                    }
                } else {
                    System.out.println("Erreur response : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                System.out.println("Erreur failure : " + t.getMessage());
            }
        });
    }

    public void createUser() {

        Call<ResultData> call = retrofitInterface.executeSignup(user);
        call.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                if (response.isSuccessful()) {
                    ResultData result = response.body();
                    if (result.getResultat() == 1) {

                        System.out.println("RESULTAT : 1");
                        System.out.println(user);

                    }
                    else {
                        System.out.println("RESULTAT : 0");
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

    private void saveData(UserData user){
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("mail", user.getMail()).apply();
        sharedPreferences.edit().putString("prenom", user.getPrenom()).apply();
        sharedPreferences.edit().putString("nom", user.getNom()).apply();
        sharedPreferences.edit().putString("telephone", user.getTel()).apply();
        sharedPreferences.edit().putString("adresse", user.getAdresse()).apply();
        sharedPreferences.edit().putString("ville", user.getVille()).apply();
        sharedPreferences.edit().putString("bio", user.getBio()).apply();
        sharedPreferences.edit().putString("nationalite", user.getNat()).apply();
        sharedPreferences.edit().putString("type", user.getType()).apply();

        sharedPreferences.edit().putBoolean("notif", user.getNotif()).apply();
        sharedPreferences.edit().putString("abo", user.getAbo()).apply();


        sharedPreferences.edit().putBoolean("isConnected", true).apply();
    }

    public void setUser(UserData u){
        user = u;
    }

    public void setMdp(String mdp){
        user.setMdp(mdp);
    }

    public void setAbo(String abo){
        user.setAbo(abo);
    }

    public UserData getUser(){
        return user;
    }
}