package com.militao.herois.model;

import com.militao.herois.api.Api;

public class ItemLista {

    public String nome;
    public String urlImagem;

    public ItemLista(String nome, String urlImagem) {
        this.nome = nome;
        this.urlImagem = urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
