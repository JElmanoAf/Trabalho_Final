package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class InfetadosLista extends AppCompatActivity {

    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_infetados);

        this.listView1 = (ListView)findViewById(R.id.listview1);

        ArrayList<Infetados> lista = new InfetadosBD(this).pesquisar();
        InfetadosAdapter infetadosAdapter = new InfetadosAdapter(this, lista);
        this.listView1.setAdapter(infetadosAdapter);
    }
}