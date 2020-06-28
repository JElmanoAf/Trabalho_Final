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

public class InfetadosDados extends AppCompatActivity {

    private Infetados infetado = new Infetados();
    private EditText editarNomeI;
    private EditText editarDatadenascimentoI;
    private EditText editarTelemovelI;
    private EditText editarLocalidadeI;
    private EditText editarSalaI;
    private EditText editarGeneroI;
    private Button SubmeterI;
    private Button CancelarI;
    private boolean novoInfetado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_infetados);

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

        this.editarNomeI= (EditText)findViewById(R.id.editarNomeI);
        this.editarDatadenascimentoI = (EditText)findViewById(R.id.editarDatadenascimentoI);
        this.editarTelemovelI = (EditText)findViewById(R.id.editarTelemovelI);
        this.editarLocalidadeI = (EditText)findViewById(R.id.editarLocalidadeI);
        this.editarSalaI = (EditText)findViewById(R.id.editarSalaI);
        //Genero
        this.SubmeterI = (Button)findViewById(R.id.SubmeterI);
        this.CancelarI = (Button)findViewById(R.id.CancelarI);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                this.infetado.setNome(bundle.getString("nome"));
                this.infetado.setDatadenascimento(bundle.getString("datadenascimento"));
                this.infetado.setTelemovel(bundle.getString("telemovel"));
                this.infetado.setLocalidade(bundle.getString("localidade"));
                this.infetado.setSala(bundle.getString("sala"));
                this.infetado.setGenero(bundle.getString("genero"));
                this.infetado.setId(bundle.getInt("id"));

                this.editarNomeI.setText(this.infetado.getNome());
                this.editarDatadenascimentoI.setText(this.infetado.getDatadenascimento());
                this.editarTelemovelI.setText(this.infetado.getTelemovel());
                this.editarLocalidadeI.setText(this.infetado.getLocalidade());
                this.editarSalaI.setText(this.infetado.getSala());
                //genero
                this.novoInfetado = false;
            }
        }
    }

    public void submeterI(View v){

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

        this.infetado.setNome(this.editarNomeI.getText().toString());
        this.infetado.setDatadenascimento(this.editarDatadenascimentoI.getText().toString());
        this.infetado.setTelemovel(this.editarTelemovelI.getText().toString());
        this.infetado.setLocalidade(this.editarLocalidadeI.getText().toString());
        this.infetado.setSala(this.editarSalaI.getText().toString());
        //Genero
        if (this.novoInfetado){
            //Insert
            new InfetadosBD(this).insert(this.infetado);
            Toast.makeText(this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
        }else {
            //Update
            new InfetadosBD(this).update(this.infetado);
            Toast.makeText(this, "Usuario atualizado com sucesso", Toast.LENGTH_LONG).show();
        }
        finish();
    }

    public void cancelarInfetado(View v){
        finish();
    }

}
