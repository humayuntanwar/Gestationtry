package com.example.humayunt.gestationtry;

import android.graphics.Bitmap;

public class DbEntity {
    private String _city;
    private String _name;
    private String fact;
    private Bitmap img;
    private String information;
    private String month;

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getInformation() {
        return this.information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getFact() {
        return this.fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Bitmap getImg() {
        return this.img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public DbEntity() {
    }

    public DbEntity(String _name, String _city) {
        this._name = _name;
        this._city = _city;
    }

    public String get_name() {
        return this._name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_city() {
        return this._city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }
}
