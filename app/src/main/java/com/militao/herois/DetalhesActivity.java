package com.militao.herois;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.adapter.GridFilmesAdapter;
import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Filme;
import com.militao.herois.model.Personagem;
import com.militao.herois.task.DownloadImagemTask;

import java.util.ArrayList;
import java.util.List;

public class DetalhesActivity extends AppCompatActivity {
    PersonagemDao personagemDao;

    Realm realm;
    int[] imagens = {
        R.drawable.poster1,
        R.drawable.poster2,
        R.drawable.poster3,
        R.drawable.poster4,
        R.drawable.poster5,
        R.drawable.poster6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        personagemDao = new PersonagemDao();
        Intent intent = getIntent();
        Personagem personagem = new Personagem();

        TextView nome = findViewById(R.id.detalhe_nome);

        TextView altura = findViewById(R.id.detalhe_altura);
        TextView cabelo = findViewById(R.id.detalhe_cor_cabelo);
        TextView olho = findViewById(R.id.detalhe_cor_olho);
        TextView pele = findViewById(R.id.detalhe_cor_pele);
        TextView genero = findViewById(R.id.detalhe_genero);
        TextView peso = findViewById(R.id.detalhe_peso);

        ImageView imageView = findViewById(R.id.img_foto_detalhe);

        personagem = personagemDao.personagemPorId(intent.getExtras().getInt("id"));
        List<Filme> filmes = new ArrayList<>();

        //filmes = realm.copyFromRealm(personagem.getListaFilmes());

        for (Filme f : personagem.getListaFilmes()){
            filmes.add(f);
        }

        GridView gridView = findViewById(R.id.gridViewFilmes);

        nome.setText(personagem.getName());

        altura.setText(personagem.getHeight());
        cabelo.setText(personagem.getHair_color());
        olho.setText(personagem.getEye_color());
        pele.setText(personagem.getSkin_color());
        genero.setText(personagem.getGender());
        peso.setText(personagem.getMass());

        new DownloadImagemTask(imageView).execute(personagem.getImage());

        GridFilmesAdapter gridFilmesAdapter = new GridFilmesAdapter(filmes,imagens,this);
        gridView.setAdapter(gridFilmesAdapter);
    }
}
