package com.militao.herois.api;

import android.text.PrecomputedText;

import com.militao.herois.model.Filme;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciarAtualizaDB {

    public void carregar(List<PrecomputedText.Params> list, Api api){
        Call<List<Filme>> callFilme = api.listarFilmes();
        callFilme.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                //list = response.body();




            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {

            }
        });
    }
}
