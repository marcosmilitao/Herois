package com.militao.herois.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.DetalhesActivity;
import com.militao.herois.R;
import com.militao.herois.dao.FilmeDao;
import com.militao.herois.model.Filme;
import com.militao.herois.model.Personagem;
import com.militao.herois.task.DownloadImagemTask;

import java.util.ArrayList;


import io.realm.RealmResults;

public class ListaPersonagemAdapter extends BaseAdapter implements Filterable {

    private Context c;
    private ArrayList<Personagem> itens;
    private CustomFilter filter;
    private ArrayList<Personagem> filterList;


    public ListaPersonagemAdapter(Context ctx,ArrayList<Personagem> personagem) {
        // TODO Auto-generated constructor stub

        this.c=ctx;
        this.itens =personagem;
        this.filterList=personagem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itens.size();
    }

    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return itens.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return itens.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view==null)
        {
            view=inflater.inflate(R.layout.personagem_item, null);
        }

        TextView nameTxt=(TextView) view.findViewById(R.id.txt_nome);
        ImageView img=(ImageView) view.findViewById(R.id.img_foto);

        if(itens != null) {
            nameTxt.setText(itens.get(pos).getName());
            new DownloadImagemTask(img).execute(itens.get(pos).getImage());
        }


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("main activity", itens.get(pos).getName());

                c.startActivity(new Intent(c, DetalhesActivity.class)
                        .putExtra("id",itens.get(pos).getId()));

            }
        });

        return view;
    }

    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if(filter == null)
        {
            filter=new CustomFilter();
        }

        return filter;
    }


    class CustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub

            FilterResults results=new FilterResults();

            if(constraint != null && constraint.length()>0)
            {

                constraint=constraint.toString().toUpperCase();

                ArrayList<Personagem> filters=new ArrayList<Personagem>();
                Personagem p;

                for(int i=0;i<filterList.size();i++)
                {
                    boolean t = false;

                    for(Filme filme : filterList.get(i).getListaFilmes()){
                        if(filme.getTitle().toUpperCase().contains(constraint)){
                            p = filterList.get(i);
                            filters.add(p);
                            t = true;
                            break;
                        }
                    }


                    if(filterList.get(i).getName().toUpperCase().contains(constraint) && t == false)
                    {
                       p = filterList.get(i);
                       filters.add(p);
                    }
                }

                results.count=filters.size();
                results.values=filters;

            }else
            {
                results.count=filterList.size();
                results.values=filterList;

            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub

            itens =(ArrayList<Personagem>) results.values;
            notifyDataSetChanged();
        }

    }

    private RealmResults<Filme> listarFilmes(CharSequence c){
        RealmResults<Filme> filmes;
        FilmeDao filmeDao = new FilmeDao();
        filmes = filmeDao.todosFilmes();



        return filmes;
    }
}
