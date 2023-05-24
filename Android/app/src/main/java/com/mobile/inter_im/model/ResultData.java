package com.mobile.inter_im.model;

import java.util.List;

public class ResultData {
    Integer resultat;
    String message;

    public ResultData(Integer resultat, String message)
    {
        this.resultat = resultat;
        this.message = message;
    }

    public Integer getResultat()
    {
        return resultat;
    }

    public void setResultat(Integer resultat)
    {
        this.resultat = resultat;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
