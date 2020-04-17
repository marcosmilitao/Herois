package com.militao.herois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.task.DownloadImagemTask;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.detalhe_nome);
        ImageView imageView = findViewById(R.id.img_foto_detalhe);

        Log.i("TESTE", intent.getExtras().getString("nome_personagem"));
        textView.setText(intent.getExtras().getString("nome_personagem"));

        new DownloadImagemTask(imageView).execute(intent.getStringExtra("imagem"));
    }
}
