package com.militao.herois;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.militao.herois.api.Api;
import com.militao.herois.model.Personagem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);


        Call<List<Personagem>> call = api.listarPersonagens();

        call.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                Log.d("OK", "><><><><><><><>><<><><>><><><>><><><><><><");
                List<Personagem> lista = response.body();

                for(Personagem p : lista ){
                    Log.d("Nome",p.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Log.d("ERROR", "><><><><><><><>><<><><>><><><>><><><><><><");
            }
        });
    }
}
