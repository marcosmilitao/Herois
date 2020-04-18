package com.militao.herois.api;

import com.militao.herois.model.Filme;
import com.militao.herois.model.Personagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://militaostarwarapi.web.app/";

    @GET("people")
    Call<List<Personagem>> listarPersonagens();

    @GET("films")
    Call<List<Filme>> listarFilmes();
}
