package com.mobile.inter_im.ui.search;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.inter_im.RetrofitInterface;
import com.mobile.inter_im.model.OfferData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchViewModel extends ViewModel {
    private final RetrofitInterface retrofitInterface;
    private List<OfferData> offers;

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public SearchViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public void sendDatas(long date, String secteur, String ville) {

        OfferData myOffer = new OfferData(date, secteur, ville);
        System.out.println("Date = "+myOffer.getDate());
        System.out.println("secteur = "+myOffer.getSecteur());
        System.out.println("ville = "+myOffer.getVille());
        System.out.println("nom = "+myOffer.getNom());
        Call<List<OfferData>> call = retrofitInterface.executeOffer(myOffer);
        call.enqueue(new Callback<List<OfferData>>() {
            @Override
            public void onResponse(Call<List<OfferData>> call, Response<List<OfferData>> response) {
                System.out.println(response);
                if (response.isSuccessful()) {
                    List<OfferData> offersList = response.body();
                    System.out.println("offerList = " + offersList);
                    if (offersList != null) {
                        System.out.println("Réponse reçue : " + offersList);
                        offers = offersList;
                        sendOfferDataList.setValue(offersList);
                    }
                } else {
                    System.out.println("Erreur response : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<OfferData>> call, Throwable t) {
                System.out.println("Erreur failure : " + t.getMessage());
            }
        });
    }

    private MutableLiveData<List<OfferData>> sendOfferDataList = new MutableLiveData<>();

    public LiveData<List<OfferData>> getSendOfferDataList() {
        return sendOfferDataList;
    }

    public void setOffers(List<OfferData> offers){
        this.offers = offers;
    }

    public List<OfferData> getOffers(){
        return this.offers;
    }

}