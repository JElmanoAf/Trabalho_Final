package com.example.trabalho_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NaoInfetadosDados extends AppCompatActivity {

    private NaoInfetados naoinfetado = new NaoInfetados();
    private EditText editarNomeNI;
    private EditText editarDatadenascimentoNI;
    private EditText editarTelemovelNI;
    private EditText editarLocalidadeNI;
    private EditText editarSalaNI;
    private EditText editarGeneroNI;
    private Button SubmeterNI;
    private Button CancelarNI;
    private boolean novoNaoInfetado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_naoinfetados);

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

        this.editarNomeNI= (EditText)findViewById(R.id.editarNomeNI);
        this.editarDatadenascimentoNI = (EditText)findViewById(R.id.editarDatadenascimentoNI);
        this.editarTelemovelNI = (EditText)findViewById(R.id.editarTelemovelNI);
        this.editarLocalidadeNI = (EditText)findViewById(R.id.editarLocalidadeNI);
        this.editarSalaNI = (EditText)findViewById(R.id.editarSalaNI);
        //Genero
        this.SubmeterNI = (Button)findViewById(R.id.SubmeterNI);
        this.CancelarNI = (Button)findViewById(R.id.CancelarNI);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                this.naoinfetado.setNomeNI(bundle.getString("nome"));
                this.naoinfetado.setDatadenascimentoNI(bundle.getString("datadenascimento"));
                this.naoinfetado.setTelemovelNI(bundle.getString("telemovel"));
                this.naoinfetado.setLocalidadeNI(bundle.getString("localidade"));
                this.naoinfetado.setSalaNI(bundle.getString("sala"));
                this.naoinfetado.setGeneroNI(bundle.getString("genero"));
                this.naoinfetado.setIdNI(bundle.getInt("id"));

                this.editarNomeNI.setText(this.naoinfetado.getNomeNI());
                this.editarDatadenascimentoNI.setText(this.naoinfetado.getDatadenascimentoNI());
                this.editarTelemovelNI.setText(this.naoinfetado.getTelemovelNI());
                this.editarLocalidadeNI.setText(this.naoinfetado.getLocalidadeNI());
                this.editarSalaNI.setText(this.naoinfetado.getSalaNI());
                //genero
                this.novoNaoInfetado = false;
            }
        }
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

        this.naoinfetado.setNomeNI(this.editarNomeNI.getText().toString());
        this.naoinfetado.setDatadenascimentoNI(this.editarDatadenascimentoNI.getText().toString());
        this.naoinfetado.setTelemovelNI(this.editarTelemovelNI.getText().toString());
        this.naoinfetado.setLocalidadeNI(this.editarLocalidadeNI.getText().toString());
        this.naoinfetado.setSalaNI(this.editarSalaNI.getText().toString());
        //Genero
        if (this.novoNaoInfetado){
            //Insert
            new NaoInfetadosBD(this).insert(this.naoinfetado);
            Toast.makeText(this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
        }else {
            //Update
            new NaoInfetadosBD(this).update(this.naoinfetado);
            Toast.makeText(this, "Usuario atualizado com sucesso", Toast.LENGTH_LONG).show();
        }
        finish();
    }

    public void cancelarNaoInfetado(View v){
        finish();
    }
}
