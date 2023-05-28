package com.mobile.inter_im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.inter_im.R;
import com.mobile.inter_im.model.OfferData;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OfferViewHolder> {
    private List<OfferData> offers;

    public OffersAdapter(Context context, List<OfferData> offers) {
        this.offers = offers;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new OfferViewHolder(inflater.inflate(R.layout.item_offer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        //OfferData offer = offers.get(position);

        // Met à jour les éléments de la vue de la Material Card avec les données de l'offre
        holder.titre.setText(offers.get(position).getNom());
        holder.descr.setText(offers.get(position).getDescr());
        holder.ville.setText(offers.get(position).getVille());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }
}
