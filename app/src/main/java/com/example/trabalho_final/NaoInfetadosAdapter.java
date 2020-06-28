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

public class NaoInfetadosAdapter extends ArrayAdapter<NaoInfetados> {
    private Context context;
    private ArrayList<NaoInfetados> lista;

    public NaoInfetadosAdapter(Context context, ArrayList<NaoInfetados> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final NaoInfetados posicaoNI = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_naoinfetado, null);
        final View layout = convertView;

        TextView itemNomeNI = (TextView) convertView.findViewById(R.id.itemNomeNI);
        itemNomeNI.setText(posicaoNI.getNomeNI());

        TextView itemDatadenascimentoNI = (TextView) convertView.findViewById(R.id.itemDatadenascimentoNI);
        itemDatadenascimentoNI.setText(posicaoNI.getDatadenascimentoNI());

        TextView itemTelemovelNI = (TextView) convertView.findViewById(R.id.itemTelemovelNI);
        itemTelemovelNI.setText(posicaoNI.getTelemovelNI());

        TextView itemLocalidadeNI = (TextView) convertView.findViewById(R.id.itemLocalidadeNI);
        itemLocalidadeNI.setText(posicaoNI.getLocalidadeNI());

        TextView itemSalaNI = (TextView) convertView.findViewById(R.id.itemSalaNI);
        itemSalaNI.setText(posicaoNI.getSalaNI());

        TextView itemGeneroNI = (TextView) convertView.findViewById(R.id.itemGeneroNI);
        itemGeneroNI.setText(posicaoNI.getGeneroNI());

        Button editarNI = (Button) convertView.findViewById(R.id.editarNI);
        editarNI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, NaoInfetadosDados.class);
                intent.putExtra("id", posicaoNI.getIdNI());
                intent.putExtra("nome", posicaoNI.getNomeNI());
                intent.putExtra("datadenascimento", posicaoNI.getDatadenascimentoNI());
                intent.putExtra("telemovel", posicaoNI.getTelemovelNI());
                intent.putExtra("localidade", posicaoNI.getLocalidadeNI());
                intent.putExtra("sala", posicaoNI.getSalaNI());
                intent.putExtra("genero", posicaoNI.getGeneroNI());
                context.startActivity(intent);
            }
        });

        Button eliminarNI = (Button) convertView.findViewById(R.id.eliminarNI);
        eliminarNI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new NaoInfetadosBD(context).delete(posicaoNI);
                layout.setVisibility(View.GONE);
            }
        });

        return convertView;
    }
}
