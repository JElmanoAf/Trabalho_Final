package com.example.trabalho_final;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfissionaisLista extends AppCompatActivity {
    private ListView listView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_profissionais);

        this.listView3 = (ListView) findViewById(R.id.listview3);

        ArrayList<Profissionais> lista = new ProfissionaisBD(this).pesquisar();
        ProfissionaisAdapter profissionaisAdapter = new ProfissionaisAdapter(this, lista);
        this.listView3.setAdapter(profissionaisAdapter);
    }
}
