package com.militao.herois.dao;

import android.util.Log;

import com.militao.herois.model.Personagem;

import io.realm.Realm;

public class PersonagemDao {


    public void addPersonagem(final Personagem p){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {


                    Number maxId = realm.where(Personagem.class).max("id");

                    int novoId = (maxId == null) ? 1 : maxId.intValue() + 1;

                    Personagem personagem = realm.createObject(Personagem.class, novoId);
                    personagem.setName(p.getName());
                    personagem.setImage(p.getImage());

                    personagem.setBirth_year(p.getBirth_year());
                    personagem.setCreated(p.getCreated());
                    personagem.setEdited(p.getEdited());
                    personagem.setEye_color(p.getEye_color());
                    personagem.setHeight(p.getHeight());
                    personagem.setFilms(p.getFilms());

                    personagem.setGender(p.getGender());
                    personagem.setSkin_color(p.getSkin_color());
                    personagem.setHair_color(p.getHair_color());
                    personagem.setMass(p.getMass());
                    personagem.setHomeworld(p.getHomeworld());
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

}
