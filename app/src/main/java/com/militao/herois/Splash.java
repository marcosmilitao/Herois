package com.militao.herois;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.militao.herois.api.Api;
import com.militao.herois.api.Service;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Personagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends Activity {

    Api api;
    PersonagemDao personagemDao;
    List<Personagem> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        personagemDao = new PersonagemDao();
        api = Service.getClient(this).create(Api.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 3000);

        Call<List<Personagem>> call = api.listarPersonagens();
        call.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                lista = response.body();
                for(Personagem p : lista){
                    personagemDao.addPersonagem(p);

                    Log.e("EeeeEEEEEEeee","<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                }

            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {

            }
        });

    }

    private void mostrarMainActivity() {
        Log.e("XXXXXXXXXXXXX","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        Intent intent = new Intent(
                Splash.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}
