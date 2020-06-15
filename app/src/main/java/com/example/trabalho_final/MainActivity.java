package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Professionais(View view) {
        Intent intent = new Intent(this, DadosProfessionais.class);
        startActivity(intent);
    }

    public void Infetados(View view) {
        Intent intent = new Intent(this, DadosInfetados.class);
        startActivity(intent);
    }

    public void NaoInfetados(View view) {
        Intent intent = new Intent(this, DadosNaoInfetados.class);
        startActivity(intent);
    }

}
