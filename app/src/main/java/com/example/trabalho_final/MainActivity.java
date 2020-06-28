package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Professionais(View view) {
        Intent intent = new Intent(this, ProfissionaisDados.class);
        startActivity(intent);
    }

    public void novoUsuarioI(View view) {
        Intent intent = new Intent(this, InfetadosDados.class);
        startActivity(intent);
    }

    public void NaoInfetados(View view) {
        Intent intent = new Intent(this, NaoInfetadosDados.class);
        startActivity(intent);
    }

    public void abreListaI(View view) {
        Intent intent = new Intent(this, InfetadosLista.class);
        startActivity(intent);
    }

    public void abreListaNI(View view) {
        Intent intent = new Intent(this, NaoInfetadosLista.class);
        startActivity(intent);
    }

    public void abreListaP(View view) {
        Intent intent = new Intent(this, ProfissionaisLista.class);
        startActivity(intent);
    }
}
