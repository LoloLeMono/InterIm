package com.mobile.inter_im.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.inter_im.MainActivity;
import com.mobile.inter_im.databinding.ItemOfferBinding;
import com.mobile.inter_im.model.OfferData;
import com.mobile.inter_im.ui.login.LoginFragment;
import com.mobile.inter_im.ui.login.LoginViewModel;

class OfferViewHolder extends RecyclerView.ViewHolder {
    // Déclare les éléments de la vue de la Material Card
    TextView titre, descr, ville;
    Button seeButton;
    private ItemOfferBinding binding;
    OfferData myOffer;

    public OfferViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemOfferBinding.bind(itemView);

        // Initialise les éléments de la vue de la Material Card
        titre = binding.textTitre;
        descr = binding.textDescr;
        ville = binding.textVille;
        seeButton = binding.buttonSee;

        System.out.println("CREATE OfferViewHolder");
        System.out.println("Titre = "+ this.titre.getText().toString());
        System.out.println("descr = "+ this.descr.getText().toString());
        System.out.println("ville = "+ this.ville.getText().toString());

        seeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                myOffer = new OfferData(titre.getText().toString(), descr.getText().toString(), ville.getText().toString());
            }
        });
    }
}