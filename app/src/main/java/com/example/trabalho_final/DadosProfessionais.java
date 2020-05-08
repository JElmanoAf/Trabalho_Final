package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessionais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_professionais);

        Spinner dropdownGenero;
        dropdownGenero = (Spinner) findViewById(R.id.spinnerP);
        final List<String> generoList = new ArrayList<>();
        generoList.add(getString(R.string.Masculino_Professional));
        generoList.add(getString(R.string.Feminino_Professional));

        ArrayAdapter<String> adapterGenero = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generoList);
        dropdownGenero.setAdapter(adapterGenero);
        dropdownGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void submeterP(View view) {
        // Verificar se os dados estão corretos
        EditText editarNomeP = (EditText) findViewById(R.id.editarNomeP);
        String nome = editarNomeP.getText().toString();

        if (nome.length() == 0) {
            editarNomeP.setError(getString(R.string.nome_obrigatorioP));
            editarNomeP.requestFocus();
            return;
        }

        EditText editarDatadenascimentoP = (EditText) findViewById(R.id.editarDatadenascimentoP);
        String datadenascimento = editarDatadenascimentoP.getText().toString();

        if (datadenascimento.length() == 0) {
            editarDatadenascimentoP.setError(getString(R.string.datadenascimento_obrigatoriaP));
            editarDatadenascimentoP.requestFocus();
            return;
        }

        EditText editarTelemovelP = (EditText) findViewById(R.id.editarTelemovelP);
        String telemovel = editarTelemovelP.getText().toString();

        if (telemovel.length() < 9) {
            editarTelemovelP.setError(getString(R.string.telemovel_obrigatorioP));
            editarTelemovelP.requestFocus();
            return;
        }

        EditText editarLocalidadeP = (EditText) findViewById(R.id.editarLocalidadeP);
        String localidade = editarLocalidadeP.getText().toString();

        if (localidade.length() == 0) {
            editarLocalidadeP.setError(getString(R.string.localidade_obrigatoriaP));
            editarLocalidadeP.requestFocus();
            return;
        }
    }
}
