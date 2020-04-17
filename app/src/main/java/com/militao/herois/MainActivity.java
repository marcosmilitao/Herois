package com.militao.herois;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.militao.herois.adapter.ListaPersonagemAdapter;
import com.militao.herois.api.Api;
import com.militao.herois.api.Service;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.ItemLista;
import com.militao.herois.model.Personagem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemLista> itemLista;
    ItemLista item;
    Api api;
    Realm realm;
    List<Personagem> lista;
    PersonagemDao  personagemDao;

    RealmResults<Personagem> listaPersonagens;

    ListaPersonagemAdapter listaPersonagemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personagemDao = new PersonagemDao();
        final ListView lv = findViewById(R.id.ListaPersonagens);
        EditText pesquisar = findViewById(R.id.pesquisar);
        Button button = findViewById(R.id.button);
        realm = Realm.getDefaultInstance();
        api = Service.getClient(this).create(Api.class);
        itemLista = new ArrayList<ItemLista>();
        listaPersonagens = Realm.getDefaultInstance().where(Personagem.class).findAll();

//        listaPersonagens.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Personagem>>() {
//            @Override
//            public void onChange(RealmResults<Personagem> personagems, OrderedCollectionChangeSet changeSet) {
//                for(Personagem p : personagems ){
//
//                    itemLista.add(new ItemLista(p.getName(),p.getImage()));
//                }
//            }
//        });

        for(Personagem p : listaPersonagens ){
           Log.e("IMAGEM", p.getImage());
                    itemLista.add(new ItemLista(p.getName(),p.getImage()));
               }
//
        listaPersonagemAdapter = new ListaPersonagemAdapter(MainActivity.this, itemLista);
        lv.setAdapter(listaPersonagemAdapter);
//        Call<List<Personagem>> call = api.listarPersonagens();
//
//        call.enqueue(new Callback<List<Personagem>>() {
//            @Override
//            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
//                Log.d("OK", "><><><><><><><>><<><><>><><><>><><><><><><");
//                lista = response.body();
//
//                itemLista = new ArrayList<ItemLista>();
//                for(Personagem p : lista ){
//
//                    itemLista.add(new ItemLista(p.getName(),p.getImage()));
//                }
//
//
//                listaPersonagemAdapter = new ListaPersonagemAdapter(MainActivity.this, itemLista);
//                lv.setAdapter(listaPersonagemAdapter);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Personagem>> call, Throwable t) {
//                Log.d("ERROR", t.toString());
//            }
//        });


        pesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listaPersonagemAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Personagem p : lista ){

                    //saveData(p);

                    personagemDao.addPersonagem(p);
                }
            }
        });
    }


}
