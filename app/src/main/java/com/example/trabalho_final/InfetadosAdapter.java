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
        final Infetados itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.activity_item_infetado, null);
        final View layout = convertView;

        TextView textView4 = (TextView) convertView.findViewById(R.id.textView4);
        textView4.setText(itemPosicao.getNome());

        TextView textView5 = (TextView) convertView.findViewById(R.id.textView5);
        textView5.setText(itemPosicao.getDatadenascimento());

        Button Editar = (Button) convertView.findViewById(R.id.Editar);
        Editar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, itemInfetado.class);
                intent.putExtra("id", itemPosicao.getId());
                intent.putExtra("nome", itemPosicao.getNome());
                intent.putExtra("datadenascimento", itemPosicao.getDatadenascimento());
                intent.putExtra("telemovel", itemPosicao.getTelemovel());
                intent.putExtra("localidade", itemPosicao.getLocalidade());
                intent.putExtra("sala", itemPosicao.getSala());
                intent.putExtra("genero", itemPosicao.getGenero());
                context.startActivity(intent);
            }
        });

        Button Eliminar = (Button) convertView.findViewById(R.id.Eliminar);
        Eliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new BDInfetados(context).delete(itemPosicao);
                layout.setVisibility(View.GONE);
            }
        });

        return convertView;
    }


}
