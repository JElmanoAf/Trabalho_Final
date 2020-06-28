package com.example.trabalho_final;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfissionaisAdapter extends ArrayAdapter<Profissionais> {
    private Context context;
    private ArrayList<Profissionais> lista;

    public ProfissionaisAdapter(Context context, ArrayList<Profissionais> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final Profissionais posicaoP = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_profissional, null);
        final View layout = convertView;

        TextView itemNomeP = (TextView) convertView.findViewById(R.id.itemNomeP);
        itemNomeP.setText(posicaoP.getNomeP());

        TextView itemDatadenascimentoP = (TextView) convertView.findViewById(R.id.itemDatadenascimentoP);
        itemDatadenascimentoP.setText(posicaoP.getDatadenascimentoP());

        TextView itemTelemovelP = (TextView) convertView.findViewById(R.id.itemTelemovelP);
        itemTelemovelP.setText(posicaoP.getTelemovelP());

        TextView itemLocalidadeP = (TextView) convertView.findViewById(R.id.itemLocalidadeP);
        itemLocalidadeP.setText(posicaoP.getLocalidadeP());

        TextView itemGeneroP = (TextView) convertView.findViewById(R.id.itemGeneroP);
        itemGeneroP.setText(posicaoP.getGeneroP());

        Button editarP = (Button) convertView.findViewById(R.id.editarP);
        editarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfissionaisDados.class);
                intent.putExtra("id", posicaoP.getIdP());
                intent.putExtra("nome", posicaoP.getNomeP());
                intent.putExtra("datadenascimento", posicaoP.getDatadenascimentoP());
                intent.putExtra("telemovel", posicaoP.getTelemovelP());
                intent.putExtra("localidade", posicaoP.getLocalidadeP());
                intent.putExtra("genero", posicaoP.getGeneroP());
                context.startActivity(intent);
            }
        });

        Button eliminarP = (Button) convertView.findViewById(R.id.eliminarP);
        eliminarP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new ProfissionaisBD(context).delete(posicaoP);
                layout.setVisibility(View.GONE);
            }
        });

        return convertView;
    }
}
