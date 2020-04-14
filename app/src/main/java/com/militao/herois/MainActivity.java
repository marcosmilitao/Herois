package com.militao.herois;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.militao.herois.api.Api;
import com.militao.herois.model.ItemLista;
import com.militao.herois.model.Personagem;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemLista> itemLista;
    ItemLista item;
    Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = findViewById(R.id.ListaPersonagens);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        Call<List<Personagem>> call = api.listarPersonagens();

        call.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                Log.d("OK", "><><><><><><><>><<><><>><><><>><><><><><><");
                List<Personagem> lista = response.body();

                itemLista = new ArrayList<ItemLista>();
                for(Personagem p : lista ){

                    Log.d("Nome",p.getName());
                    Log.d("Nome",p.getImage());

                    itemLista.add(new ItemLista(p.getName(),p.getImage()));
                }


                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, itemLista);
                lv.setAdapter(customAdapter);


            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Log.d("ERROR", "><><><><><><><>><<><><>><><><>><><><><><><");
            }
        });

    }

    class CustomAdapter extends ArrayAdapter<ItemLista> {


        CustomAdapter(Context  c, ArrayList <ItemLista> list){
            super(c,0,list);

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = LayoutInflater.from(getContext()).inflate(R.layout.personagem_item, parent, false);

            ItemLista item = getItem(position);

            TextView nome = v.findViewById(R.id.txt_nome);
            ImageView image = v.findViewById(R.id.img_foto);

            if (item != null) {
                new DownloadImageTask(image).execute(item.getUrlImagem());
                nome.setText(item.getNome());
            }

            return v;
        }


    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
