package com.militao.herois;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.ListView;


import android.app.SearchManager;

import android.widget.SearchView.OnQueryTextListener;

import androidx.appcompat.widget.SearchView;

import androidx.appcompat.widget.Toolbar;

import com.militao.herois.adapter.ListaPersonagemAdapter;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Personagem;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    ArrayList<Personagem> itemLista;
    Realm realm;
    PersonagemDao  personagemDao;
    RealmResults<Personagem> listaPersonagens;
    ListaPersonagemAdapter listaPersonagemAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personagemDao = new PersonagemDao();
        final ListView lv = findViewById(R.id.ListaPersonagens);
        //EditText pesquisar = findViewById(R.id.pesquisar);
        realm = Realm.getDefaultInstance();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        itemLista = new ArrayList<Personagem>();
        listaPersonagens = personagemDao.todosPersonagens();


         itemLista.addAll(realm.copyFromRealm(listaPersonagens));

        listaPersonagemAdapter = new ListaPersonagemAdapter(MainActivity.this, itemLista);
        lv.setAdapter(listaPersonagemAdapter);

//
//        pesquisar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                listaPersonagemAdapter.getFilter().filter(charSequence);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Pesquisar");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listaPersonagemAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
