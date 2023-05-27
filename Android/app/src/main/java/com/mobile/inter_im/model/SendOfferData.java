package com.mobile.inter_im.model;

public class SendOfferData
{
    String secteur, ville;
    long date;

    public SendOfferData(long date, String secteur, String ville)
    {
        this.secteur = secteur;
        this.date = date;
        this.ville = ville;
    }

    public String getSecteur()
    {
        return secteur;
    }

    public void setSecteur(String secteur)
    {
        this.secteur = secteur;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public long getDate()
    {
        return date;
    }

    public void setDate(long date)
    {
        this.date = date;
    }
}
