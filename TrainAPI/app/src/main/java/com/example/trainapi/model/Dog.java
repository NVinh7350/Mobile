package com.example.trainapi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Dog implements Serializable {
    @SerializedName("bred_for")
    @ColumnInfo
    private String bred_for;
    @SerializedName("breed_group")
    @ColumnInfo
    private String breed_group;
//    @SerializedName("height")
//    @ColumnInfo
//    private Height height;
//    @SerializedName("wight")
//    @ColumnInfo
//    private Wight wight;
    @SerializedName("id")
    @PrimaryKey
    private int id;
    @ColumnInfo
    @SerializedName("life_span")
    private String life_span;
    @ColumnInfo
    @SerializedName("origin")
    private String origin;
    @ColumnInfo
    @SerializedName("temperament")
    private String temperament;
    @ColumnInfo
    @SerializedName("url")
    private String url;
    @ColumnInfo
    @SerializedName("name")
    private String name;

    public Dog(String bred_for, String breed_group, int id, String life_span, String origin, String temperament, String url, String name) {
        this.bred_for = bred_for;
        this.breed_group = breed_group;
//        this.height = height;
//        this.wight = wight;
        this.id = id;
        this.life_span = life_span;
        this.origin = origin;
        this.temperament = temperament;
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBred_for() {
        return bred_for;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

//    public Height getHeight() {
//        return height;
//    }
//
//    public void setHeight(Height height) {
//        this.height = height;
//    }
//
//    public Wight getWight() {
//        return wight;
//    }
//
//    public void setWight(Wight wight) {
//        this.wight = wight;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
