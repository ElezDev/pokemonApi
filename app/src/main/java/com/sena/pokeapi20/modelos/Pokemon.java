package com.sena.pokeapi20.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pokemon {


    @SerializedName("number")
    @Expose
    private int number;

    public int getNumber() {
        String[] urlParts=url.split("/");
        number=Integer.parseInt(urlParts[urlParts.length-1]);
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;

}
