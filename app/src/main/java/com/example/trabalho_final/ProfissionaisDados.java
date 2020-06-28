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

public class ProfissionaisDados extends AppCompatActivity {

    private Profissionais profissional = new Profissionais();
    private EditText editarNomeP;
    private EditText editarDatadenascimentoP;
    private EditText editarTelemovelP;
    private EditText editarLocalidadeP;
    private EditText editarGeneroP;
    private Button SubmeterP;
    private Button CancelarP;
    private boolean novoProfissional = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_profissionais);

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

        this.editarNomeP= (EditText)findViewById(R.id.editarNomeP);
        this.editarDatadenascimentoP = (EditText)findViewById(R.id.editarDatadenascimentoP);
        this.editarTelemovelP = (EditText)findViewById(R.id.editarTelemovelP);
        this.editarLocalidadeP = (EditText)findViewById(R.id.editarLocalidadeP);
        //Genero
        this.SubmeterP = (Button)findViewById(R.id.SubmeterP);
        this.CancelarP = (Button)findViewById(R.id.CancelarP);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                this.profissional.setNomeP(bundle.getString("nome"));
                this.profissional.setDatadenascimentoP(bundle.getString("datadenascimento"));
                this.profissional.setTelemovelP(bundle.getString("telemovel"));
                this.profissional.setLocalidadeP(bundle.getString("localidade"));
                this.profissional.setGeneroP(bundle.getString("genero"));
                this.profissional.setIdP(bundle.getInt("id"));

                this.editarNomeP.setText(this.profissional.getNomeP());
                this.editarDatadenascimentoP.setText(this.profissional.getDatadenascimentoP());
                this.editarTelemovelP.setText(this.profissional.getTelemovelP());
                this.editarLocalidadeP.setText(this.profissional.getLocalidadeP());
                //genero
                this.novoProfissional = false;
            }
        }
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

        this.profissional.setNomeP(this.editarNomeP.getText().toString());
        this.profissional.setDatadenascimentoP(this.editarDatadenascimentoP.getText().toString());
        this.profissional.setTelemovelP(this.editarTelemovelP.getText().toString());
        this.profissional.setLocalidadeP(this.editarLocalidadeP.getText().toString());
        //Genero
        if (this.novoProfissional){
            //Insert
            new ProfissionaisBD(this).insert(this.profissional);
            Toast.makeText(this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
        }else {
            //Update
            new ProfissionaisBD(this).update(this.profissional);
            Toast.makeText(this, "Usuario atualizado com sucesso", Toast.LENGTH_LONG).show();
        }
        finish();
    }
    public void cancelarProfissional(View v){
        finish();
    }
}
