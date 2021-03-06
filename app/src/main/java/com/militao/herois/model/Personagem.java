package com.militao.herois.model;

import android.util.Log;

import com.militao.herois.api.Api;
import com.militao.herois.dao.FilmeDao;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Personagem extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;
    private String edited;
    private String created;
    private String gender;
    private String skin_color;
    private String hair_color;
    private String height;
    private String eye_color;
    private String mass;
    private String homeworld;
    private String birth_year;
    private String image;
    private RealmList<Integer> films;
    private RealmList<Filme> listaFilmes;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RealmList<Integer> getFilms() {
        return films;
    }

    public void setFilms(RealmList<Integer> films) {

        this.films = films;
    }

    public RealmList<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(RealmList<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
}
