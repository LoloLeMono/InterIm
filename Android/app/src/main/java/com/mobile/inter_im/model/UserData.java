package com.mobile.inter_im.model;

import java.util.List;

public class UserData {
    String _id, nom, prenom, mdp, mail, tel, nat, type, adresse, ville, bio, cv, vitale, abo;
    Boolean notif;
    List<String> autredoc, emplois;

    public UserData(String mail, String mdp)
    {
        this.mail = mail;
        this.mdp = mdp;
    }

    public UserData(String nom, String prenom, String mail, String tel, String nat, String adresse, String ville)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.nat = nat;
        this.adresse = adresse;
        this.ville = ville;
    }

    public UserData(String _id, String nom, String prenom, String mdp, String mail, String tel, String nat, String type, String adresse, String ville, String bio, String cv, String vitale, Boolean notif, String abo, List<String> autredoc, List<String> emplois)
    {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.tel = tel;
        this.nat = nat;
        this.type = type;
        this.adresse = adresse;
        this.ville = ville;
        this.bio = bio;
        this.cv = cv;
        this.vitale = vitale;
        this.notif = notif;
        this.abo = abo;
        this.autredoc = autredoc;
        this.emplois = emplois;
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

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String premon)
    {
        this.prenom = prenom;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getNat()
    {
        return nat;
    }

    public void setNat(String nat)
    {
        this.nat = nat;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public String getCv()
    {
        return cv;
    }

    public void setCv(String cv)
    {
        this.cv = cv;
    }

    public String getVitale()
    {
        return vitale;
    }

    public void setVitale(String vitale)
    {
        this.vitale = vitale;
    }

    public Boolean getNotif()
    {
        return notif;
    }

    public void setNotif(Boolean notif)
    {
        this.notif = notif;
    }

    public String getAbo()
    {
        return abo;
    }

    public void setAbo(String abo)
    {
        this.abo = abo;
    }

    public List<String> getAutredoc()
    {
        return autredoc;
    }

    public void setAutredoc(List<String> autredoc)
    {
        this.autredoc = autredoc;
    }

    public List<String> getEmplois()
    {
        return emplois;
    }

    public void setEmplois(List<String> emplois)
    {
        this.emplois = emplois;
    }
}
