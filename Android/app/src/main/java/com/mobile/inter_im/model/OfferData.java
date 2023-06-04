package com.mobile.inter_im.model;

public class OfferData
{
    String _id, nom, etat, secteur, descr, ville;
    long date;
    int duree;
    float salaire;
    String[] candidatures;

    public OfferData(String _id, String nom, String etat, String secteur, String descr, String ville, long date, int duree, float salaire, String[] candidatures)
    {
        this._id = _id;
        this.nom = nom;
        this.etat = etat;
        this.secteur = secteur;
        this.descr = descr;
        this.ville = ville;
        this.date = date;
        this.duree = duree;
        this.salaire = salaire;
        this.candidatures = candidatures;
    }

    public OfferData(String nom, String descr, String ville)
    {
        this.nom = nom;
        this.descr = descr;
        this.ville = ville;
    }

    public OfferData(long date, String secteur, String ville)
    {
        this.secteur = secteur;
        this.ville = ville;
        this.date = date;
    }

    public String get_id()
    {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getEtat()
    {
        return etat;
    }

    public void setEtat(String etat)
    {
        this.etat = etat;
    }

    public String getSecteur()
    {
        return secteur;
    }

    public void setSecteur(String secteur)
    {
        this.secteur = secteur;
    }

    public String getDescr()
    {
        return descr;
    }

    public void setDescr(String descr)
    {
        this.descr = descr;
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

    public int getDuree()
    {
        return duree;
    }

    public void setDuree(int duree)
    {
        this.duree = duree;
    }

    public float getSalaire()
    {
        return salaire;
    }

    public void setSalaire(float salaire)
    {
        this.salaire = salaire;
    }

    public String[] getCandidatures()
    {
        return candidatures;
    }

    public void setCandidatures(String[] candidatures)
    {
        this.candidatures = candidatures;
    }
}
