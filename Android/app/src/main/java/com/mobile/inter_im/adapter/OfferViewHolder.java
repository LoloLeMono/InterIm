package com.mobile.inter_im.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.inter_im.databinding.ItemOfferBinding;

class OfferViewHolder extends RecyclerView.ViewHolder {
    // Déclare les éléments de la vue de la Material Card
    TextView titre, descr, ville;
    private ItemOfferBinding binding;

    public OfferViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemOfferBinding.bind(itemView);

        // Initialise les éléments de la vue de la Material Card
        titre = binding.textTitre;
        descr = binding.textDescr;
        ville = binding.textVille;
        System.out.println("CREATE OfferViewHolder");
        System.out.println("Titre = "+ this.titre.getText().toString());
        System.out.println("descr = "+ this.descr.getText().toString());
        System.out.println("ville = "+ this.ville.getText().toString());
    }
}