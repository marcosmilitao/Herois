package com.militao.herois.dao;

import android.content.Intent;
import android.util.Log;

import com.militao.herois.model.Filme;


import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class FilmeDao {

    Realm realm;
    public void addFime(final Filme f){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealmOrUpdate(f);
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                }
            }
        }, new Realm.Transaction.OnSuccess() {

            @Override
            public void onSuccess() {
//                Log.w("OK","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
//                Log.e("ERRO","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
        });
    }

    public RealmResults todosFilmes(){
        return Realm.getDefaultInstance().where(Filme.class).findAll();
    }

    public Filme filmePorId(int id){
        return  Realm.getDefaultInstance().where(Filme.class).equalTo("id",id).findFirst();
    }

    public RealmList<Filme> listaFilmesPorListaIds(RealmList<Integer> i){
        RealmList<Filme> filmes;
        filmes = new RealmList<>();
        Filme f;
        for(Integer id : i){
            f = filmePorId(id);
            Log.e("FILME", f.getTitle());

           filmes.add(f);

        }
        return filmes;
    }

    public List<Integer> listaFilmesContem(CharSequence c){
        List<Filme> filmes = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        Realm r = Realm.getDefaultInstance();
        try {

            RealmResults<Filme> results = r.where(Filme.class).contains("title",c.toString(), Case.INSENSITIVE).findAll();
            filmes.addAll(r.copyFromRealm(results));
            List<Integer> personagens = new ArrayList<>();
            for(Filme f : filmes){
                Log.e("Realm Erro", f.getTitle());
                for (Integer i : f.getCharacters()) {
                    personagens.add(i);
                }
            }
            ids = personagens;
        }catch (RealmException ex){
            Log.e("Realm Erro", ex.getMessage());
        }finally {
            if(r != null){
                r.close();
            }
        }

        return ids;
    }
}
