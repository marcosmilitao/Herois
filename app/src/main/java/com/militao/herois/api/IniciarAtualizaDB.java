package com.militao.herois.api;

import android.content.Context;
import android.util.Log;

import com.militao.herois.dao.FilmeDao;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Filme;
import com.militao.herois.model.Personagem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciarAtualizaDB {


    public void carregar(Context context){

        Api api;
        PersonagemDao personagemDao = new PersonagemDao();
        FilmeDao filmeDao = new FilmeDao();

        api = Service.getClient(context).create(Api.class);

        Call<List<Filme>> callFilme = api.listarFilmes();
        callFilme.enqueue(new Callback<List<Filme>>() {
            List<Filme> listaFilmes = new ArrayList<>();
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                listaFilmes = response.body();

                for(Filme f : listaFilmes){
                    filmeDao.addFime(f);
                }

            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Log.e("ERRO",t.toString());
            }
        });




        Call<List<Personagem>> call = api.listarPersonagens();
        call.enqueue(new Callback<List<Personagem>>() {
            List<Personagem> lista = new ArrayList<>();
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                lista = response.body();
                for(Personagem p : lista){
                    personagemDao.addPersonagem(p);
                }

            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Log.e("ERRO",t.toString());
            }
        });

    }
}
