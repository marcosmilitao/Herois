package com.militao.herois.dao;

import android.util.Log;

import com.militao.herois.model.Personagem;

import io.realm.Realm;
import io.realm.RealmResults;

public class PersonagemDao {


    public void addPersonagem(final Personagem p){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealmOrUpdate(p);
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                }
            }
        }, new Realm.Transaction.OnSuccess() {

            @Override
            public void onSuccess() {
                Log.w("OK","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("ERRO","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
        });
    }

    public RealmResults todosPersonagens(){
       return Realm.getDefaultInstance().where(Personagem.class).findAll();
    }

    public Personagem personagemPorId(int id){
        return  Realm.getDefaultInstance().where(Personagem.class).equalTo("id",id).findFirst();
    }
}
