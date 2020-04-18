//package com.militao.herois.dao;
//
//import android.content.Intent;
//import android.util.Log;
//
//import com.militao.herois.model.Filme;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.realm.Realm;
//import io.realm.RealmList;
//import io.realm.RealmResults;
//
//public class FilmeDao {
//
//
//    public void addFime(final Filme f){
//        Realm realm = Realm.getDefaultInstance();
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                try {
//                    realm.copyToRealmOrUpdate(f);
//                }catch (Exception e){
//                    Log.e("Error", e.getMessage());
//                }
//            }
//        }, new Realm.Transaction.OnSuccess() {
//
//            @Override
//            public void onSuccess() {
//                Log.w("OK","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                Log.e("ERRO","<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
//            }
//        });
//    }
//
//    public RealmResults todosPersonagens(){
//        return Realm.getDefaultInstance().where(Filme.class).findAll();
//    }
//
//    public Filme filmePorId(int id){
//        return  Realm.getDefaultInstance().where(Filme.class).equalTo("id",id).findFirst();
//    }
//
////    public RealmList<Filme> listaFilmesPorListaIds(RealmList<Integer> i){
////        RealmList<Filme> filmes;
////        filmes = new RealmList<>();
////        for(Integer id : i){
////           filmes.add(filmePorId(id));
////        }
////        return filmes;
////    }
//}
