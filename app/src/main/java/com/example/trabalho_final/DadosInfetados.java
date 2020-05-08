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

public class DadosInfetados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_infetados);

        Spinner dropdownGenero;
        dropdownGenero = (Spinner) findViewById(R.id.spinnerI);
        final List<String> generoList = new ArrayList<>();
        generoList.add(getString(R.string.Masculino_Infetado));
        generoList.add(getString(R.string.Feminino_Infetado));

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

    public void submeterI(View view) {
        // Verificar se os dados estão corretos
        EditText editarNomeI = (EditText) findViewById(R.id.editarNomeI);
        String nome = editarNomeI.getText().toString();

        if (nome.length() == 0) {
            editarNomeI.setError(getString(R.string.nome_obrigatorioP));
            editarNomeI.requestFocus();
            return;
        }

        EditText editarDatadenascimentoI = (EditText) findViewById(R.id.editarDatadenascimentoI);
        String datadenascimento = editarDatadenascimentoI.getText().toString();

        if (datadenascimento.length() == 0) {
            editarDatadenascimentoI.setError(getString(R.string.datadenascimento_obrigatoriaP));
            editarDatadenascimentoI.requestFocus();
            return;
        }

        EditText editarTelemovelI = (EditText) findViewById(R.id.editarTelemovelI);
        String telemovel = editarTelemovelI.getText().toString();

        if (telemovel.length() < 9) {
            editarTelemovelI.setError(getString(R.string.telemovel_obrigatorioP));
            editarTelemovelI.requestFocus();
            return;
        }

        EditText editarLocalidadeI = (EditText) findViewById(R.id.editarLocalidadeI);
        String localidade = editarLocalidadeI.getText().toString();

        if (localidade.length() == 0) {
            editarLocalidadeI.setError(getString(R.string.localidade_obrigatoriaP));
            editarLocalidadeI.requestFocus();
            return;
        }

        EditText editarSalaI = (EditText) findViewById(R.id.editarSalaI);
        String sala = editarLocalidadeI.getText().toString();

        if (sala.length() == 0) {
            editarSalaI.setError(getString(R.string.localidade_obrigatoriaP));
            editarSalaI.requestFocus();
            return;
        }
    }
}
