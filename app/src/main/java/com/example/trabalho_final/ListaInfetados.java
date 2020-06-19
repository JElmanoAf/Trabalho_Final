package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaInfetados extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_infetados);

        this.listView = (ListView)findViewById(R.id.listview);

        ArrayList<Infetados> lista = new BDInfetados(this).pesquisar();
        InfetadosAdapter infetadosAdapter = new InfetadosAdapter(this, lista);
        this.listView.setAdapter(infetadosAdapter);
    }
}