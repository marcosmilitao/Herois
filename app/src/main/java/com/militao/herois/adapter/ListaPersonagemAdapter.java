package com.militao.herois.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.militao.herois.R;
import com.militao.herois.model.ItemLista;
import com.militao.herois.task.DownloadImagemTask;

import java.util.ArrayList;

public class ListaPersonagemAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<ItemLista> itens;
    CustomFilter filter;
    ArrayList<ItemLista> filterList;

    public ListaPersonagemAdapter(Context ctx,ArrayList<ItemLista> personagem) {
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
            nameTxt.setText(itens.get(pos).getNome());
            new DownloadImagemTask(img).execute(itens.get(pos).getUrlImagem());
        }


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("main activity", itens.get(pos).nome);

                // startActivity(new Intent(MainActivity.this,ItemsPreviewActivity.class).putExtra("items",itemsModelListFiltered.get(position)));

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

    //INNER CLASS
    class CustomFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub

            FilterResults results=new FilterResults();

            if(constraint != null && constraint.length()>0)
            {
                //CONSTARINT TO UPPER
                constraint=constraint.toString().toUpperCase();

                ArrayList<ItemLista> filters=new ArrayList<ItemLista>();

                //get specific items
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getNome().toUpperCase().contains(constraint))
                    {
                        ItemLista p=new ItemLista(filterList.get(i).getNome(), filterList.get(i).getUrlImagem());

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

            itens =(ArrayList<ItemLista>) results.values;
            notifyDataSetChanged();
        }

    }

}
