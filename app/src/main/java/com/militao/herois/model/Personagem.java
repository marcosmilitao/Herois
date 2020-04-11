package com.militao.herois.model;

public class Personagem {

    public int id;
    public String name;
    public String edited;
    public String created;
    public String gender;
    public String skin_color;
    public String hair_color;
    public String height;
    public String eye_color;
    public String mass;
    public String homeworld;
    public String birth_year;
    public String image;
    public int[] films;
    public int[] vehicles;
    public int[] starships;

    public Personagem(int id, String name, String edited, String created, String gender, String skin_color, String hair_color, String height, String eye_color, String mass, String homeworld, String birth_year, String image, int[] films, int[] vehicles, int[] starships) {
        this.id = id;
        this.name = name;
        this.edited = edited;
        this.created = created;
        this.gender = gender;
        this.skin_color = skin_color;
        this.hair_color = hair_color;
        this.height = height;
        this.eye_color = eye_color;
        this.mass = mass;
        this.homeworld = homeworld;
        this.birth_year = birth_year;
        this.image = image;
        this.films = films;
        this.vehicles = vehicles;
        this.starships = starships;
    }

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

    public int[] getFilms() {
        return films;
    }

    public void setFilms(int[] films) {
        this.films = films;
    }

    public int[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(int[] vehicles) {
        this.vehicles = vehicles;
    }

    public int[] getStarships() {
        return starships;
    }

    public void setStarships(int[] starships) {
        this.starships = starships;
    }
}
