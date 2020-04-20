package com.militao.herois.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.R;
import com.militao.herois.model.Filme;

import java.util.List;

public class GridFilmesAdapter extends BaseAdapter {

    private Context context;
    private final List<Filme> titulos;
    private final int [] imagens;
    View view;
    private LayoutInflater layoutInflater;
    public GridFilmesAdapter(List<Filme> titulos, int[] imagens, Context context) {
        this.context = context;
        this.titulos = titulos;
        this.imagens = imagens;

    }


    @Override
    public int getCount() {
        return titulos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            view = layoutInflater.inflate(R.layout.poster_item, null);

            ImageView imageView = view.findViewById(R.id.imageViewPoster);
            TextView textView = view.findViewById(R.id.tituloPoster);

            imageView.setImageResource(imagens[titulos.get(position).getEpisode_id()-1]);
            textView.setText(titulos.get(position).getTitle());
        }

        return view;
    }
}
