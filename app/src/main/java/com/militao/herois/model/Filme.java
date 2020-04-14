package com.militao.herois.model;

import java.util.List;

public class Filme {
    public String producer;
    public String title;
    public String created;
    public int episode_id;
    public String director;
    public String release_date;
    public String opening_crawl;
    public int id;

    public Filme(String producer, String title, String created, int episode_id, String director, String release_date, String opening_crawl, int id) {
        this.producer = producer;
        this.title = title;
        this.created = created;
        this.episode_id = episode_id;
        this.director = director;
        this.release_date = release_date;
        this.opening_crawl = opening_crawl;
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
