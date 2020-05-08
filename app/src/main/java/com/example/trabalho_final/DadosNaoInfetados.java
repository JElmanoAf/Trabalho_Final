package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DadosNaoInfetados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_nao_infetados);

        Spinner dropdownGenero;
        dropdownGenero = (Spinner) findViewById(R.id.spinnerNI);
        final List<String> generoList = new ArrayList<>();
        generoList.add(getString(R.string.Masculino_N_Infetado));
        generoList.add(getString(R.string.Feminino_N_Infetado));

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

    public void submeterNI(View view) {
        // Verificar se os dados estão corretos
        EditText editarNomeNI = (EditText) findViewById(R.id.editarNomeNI);
        String nome = editarNomeNI.getText().toString();

        if (nome.length() == 0) {
            editarNomeNI.setError(getString(R.string.nome_obrigatorioP));
            editarNomeNI.requestFocus();
            return;
        }

        EditText editarDatadenascimentoNI = (EditText) findViewById(R.id.editarDatadenascimentoNI);
        String datadenascimento = editarDatadenascimentoNI.getText().toString();

        if (datadenascimento.length() == 0) {
            editarDatadenascimentoNI.setError(getString(R.string.datadenascimento_obrigatoriaP));
            editarDatadenascimentoNI.requestFocus();
            return;
        }

        EditText editarTelemovelNI = (EditText) findViewById(R.id.editarTelemovelNI);
        String telemovel = editarTelemovelNI.getText().toString();

        if (telemovel.length() < 9) {
            editarTelemovelNI.setError(getString(R.string.telemovel_obrigatorioP));
            editarTelemovelNI.requestFocus();
            return;
        }

        EditText editarLocalidadeNI = (EditText) findViewById(R.id.editarLocalidadeNI);
        String localidade = editarLocalidadeNI.getText().toString();

        if (localidade.length() == 0) {
            editarLocalidadeNI.setError(getString(R.string.localidade_obrigatoriaP));
            editarLocalidadeNI.requestFocus();
            return;
        }

        EditText editarSalaNI = (EditText) findViewById(R.id.editarSalaNI);
        String sala = editarLocalidadeNI.getText().toString();

        if (sala.length() == 0) {
            editarSalaNI.setError(getString(R.string.localidade_obrigatoriaP));
            editarSalaNI.requestFocus();
            return;
        }
    }
}
