package com.mobile.inter_im.ui.search;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.google.gson.Gson;
import com.mobile.inter_im.R;
import com.mobile.inter_im.RetrofitInterface;
import com.mobile.inter_im.databinding.FragmentDisplayOffersBinding;
import com.mobile.inter_im.model.SendOfferData;
import com.mobile.inter_im.ui.displayOffers.DisplayOffersFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final RetrofitInterface retrofitInterface;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public SearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public void sendDatas(long dateDeb, String secteur, String ville, NavController navController) {

        SendOfferData myOffer = new SendOfferData(dateDeb, secteur, ville);
        System.out.println("Date = "+myOffer.getDate());
        System.out.println("secteur = "+myOffer.getSecteur());
        System.out.println("ville = "+myOffer.getVille());
        Call<List<SendOfferData>> call = retrofitInterface.executeOffer(myOffer);
        call.enqueue(new Callback<List<SendOfferData>>() {
            @Override
            public void onResponse(Call<List<SendOfferData>> call, Response<List<SendOfferData>> response) {
                System.out.println(response);
                if (response.isSuccessful()) {
                    List<SendOfferData> offersList = response.body();
                    System.out.println("offerList = " + offersList);
                    if (offersList != null) {
                        System.out.println("Réponse reçue : " + offersList);

                        sendOfferDataList.setValue(offersList);
                    }
                } else {
                    System.out.println("Erreur response : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<SendOfferData>> call, Throwable t) {
                System.out.println("Erreur failure : " + t.getMessage());
            }
        });
    }

    public LiveData<String> getText() {
        return mText;
    }

    private MutableLiveData<List<SendOfferData>> sendOfferDataList = new MutableLiveData<>();

    public LiveData<List<SendOfferData>> getSendOfferDataList() {
        return sendOfferDataList;
    }

}