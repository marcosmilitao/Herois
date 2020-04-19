package com.militao.herois;

import android.app.Application;
import android.sax.RootElement;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().name("realmDataBase.realm").build();
        Realm.setDefaultConfiguration(configuration);
        //Realm.deleteRealm(configuration);

    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}
