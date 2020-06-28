package com.example.trabalho_final;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NaoInfetadosLista extends AppCompatActivity {
    private ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_naoinfetados);

        this.listView2 = (ListView)findViewById(R.id.listview2);

        ArrayList<NaoInfetados> lista = new NaoInfetadosBD(this).pesquisar();
        NaoInfetadosAdapter naoinfetadosAdapter = new NaoInfetadosAdapter(this, lista);
        this.listView2.setAdapter(naoinfetadosAdapter);
    }
}
