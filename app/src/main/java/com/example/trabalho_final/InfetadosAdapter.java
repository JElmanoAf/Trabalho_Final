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

public class InfetadosAdapter extends ArrayAdapter<Infetados> {
    private Context context;
    private ArrayList<Infetados> lista;

    public InfetadosAdapter(Context context, ArrayList<Infetados> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final Infetados posicaoI = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_infetado, null);
        final View layout = convertView;

        TextView itemNomeI = (TextView) convertView.findViewById(R.id.itemNomeI);
        itemNomeI.setText(posicaoI.getNome());

        TextView itemDatadenascimentoI = (TextView) convertView.findViewById(R.id.itemDatadenascimentoI);
        itemDatadenascimentoI.setText(posicaoI.getDatadenascimento());

        TextView itemTelemovelI = (TextView) convertView.findViewById(R.id.itemTelemovelI);
        itemTelemovelI.setText(posicaoI.getTelemovel());

        TextView itemLocalidadeI = (TextView) convertView.findViewById(R.id.itemLocalidadeI);
        itemLocalidadeI.setText(posicaoI.getLocalidade());

        TextView itemSalaI = (TextView) convertView.findViewById(R.id.itemSalaI);
        itemSalaI.setText(posicaoI.getSala());

        TextView itemGeneroI = (TextView) convertView.findViewById(R.id.itemGeneroI);
        itemGeneroI.setText(posicaoI.getGenero());

        Button editarI = (Button) convertView.findViewById(R.id.editarI);
        editarI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, DadosInfetados.class);
                intent.putExtra("id", posicaoI.getId());
                intent.putExtra("nome", posicaoI.getNome());
                intent.putExtra("datadenascimento", posicaoI.getDatadenascimento());
                intent.putExtra("telemovel", posicaoI.getTelemovel());
                intent.putExtra("localidade", posicaoI.getLocalidade());
                intent.putExtra("sala", posicaoI.getSala());
                intent.putExtra("genero", posicaoI.getGenero());
                context.startActivity(intent);
            }
        });

        Button eliminarI = (Button) convertView.findViewById(R.id.eliminarI);
        eliminarI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new BDInfetados(context).delete(posicaoI);
                layout.setVisibility(View.GONE);
            }
        });

        return convertView;
    }


}
