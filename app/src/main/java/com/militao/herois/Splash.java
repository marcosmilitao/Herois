package com.militao.herois;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.militao.herois.api.Api;
import com.militao.herois.api.Service;
import com.militao.herois.dao.FilmeDao;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Filme;
import com.militao.herois.model.Personagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends Activity {

    Api api;
    PersonagemDao personagemDao;
    FilmeDao filmeDao;
    List<Personagem> lista;
    List<Filme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        personagemDao = new PersonagemDao();
        filmeDao = new FilmeDao();
        api = Service.getClient(this).create(Api.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 3000);


        Call<List<Filme>> callFilme = api.listarFilmes();
        callFilme.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                listaFilmes = response.body();

                for(Filme f : listaFilmes){
                    filmeDao.addFime(f);
                }

            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {

            }
        });




        Call<List<Personagem>> call = api.listarPersonagens();
        call.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                lista = response.body();
                for(Personagem p : lista){
                    personagemDao.addPersonagem(p);

//                    Log.e("EeeeEEEEEEeee","<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                }

            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {

            }
        });


    }

    private void mostrarMainActivity() {
//        Log.e("XXXXXXXXXXXXX","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        Intent intent = new Intent(
                Splash.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}
