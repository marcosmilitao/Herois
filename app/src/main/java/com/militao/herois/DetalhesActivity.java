package com.militao.herois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.dao.PersonagemDao;
import com.militao.herois.model.Personagem;
import com.militao.herois.task.DownloadImagemTask;

public class DetalhesActivity extends AppCompatActivity {
    PersonagemDao personagemDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        personagemDao = new PersonagemDao();
        Intent intent = getIntent();
        Personagem personagem = new Personagem();
        TextView textView = findViewById(R.id.detalhe_nome);
        ImageView imageView = findViewById(R.id.img_foto_detalhe);

        personagem = personagemDao.personagemPorId(intent.getExtras().getInt("id"));

        textView.setText(personagem.getName());
        new DownloadImagemTask(imageView).execute(personagem.getImage());
    }
}
