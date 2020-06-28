package com.example.trabalho_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NaoInfetadosBD {
    private SQLiteDatabase bd;

    public NaoInfetadosBD(Context context){ this.bd = new SQLiteCore(context).getWritableDatabase(); }

    public void insert(NaoInfetados naoinfetado){
        ContentValues dados = new ContentValues();
        dados.put("nome",naoinfetado.getNomeNI());
        dados.put("datadenascimento",naoinfetado.getDatadenascimentoNI());
        dados.put("telemovel",naoinfetado.getTelemovelNI());
        dados.put("localidade",naoinfetado.getLocalidadeNI());
        dados.put("sala",naoinfetado.getSalaNI());
        dados.put("genero",naoinfetado.getGeneroNI());

        this.bd.insert("naoinfetado",null, dados);
    }

    public void update(NaoInfetados naoinfetado){
        ContentValues dados = new ContentValues();
        dados.put("nome",naoinfetado.getNomeNI());
        dados.put("datadenascimento",naoinfetado.getDatadenascimentoNI());
        dados.put("telemovel",naoinfetado.getTelemovelNI());
        dados.put("localidade",naoinfetado.getLocalidadeNI());
        dados.put("sala",naoinfetado.getSalaNI());
        dados.put("genero",naoinfetado.getGeneroNI());

        this.bd.update("naoinfetado", dados, "id = ?", new String[]{"" + naoinfetado.getIdNI()});
    }

    public void delete(NaoInfetados naoinfetado){
        this.bd.delete("naoinfetado","id = ?", new String[]{"" + naoinfetado.getIdNI()});
    }

    public ArrayList<NaoInfetados> pesquisar(){
        ArrayList<NaoInfetados> lista = new ArrayList<>();
        String[] colunas = new String[]{"id", "nome", "datadenascimento", "telemovel", "localidade", "sala", "genero"};
        Cursor cursor = this.bd.query("naoinfetado", colunas, null, null, null, null, "nome DESC");

        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do{
                NaoInfetados naoinfetado =  new NaoInfetados();
                naoinfetado.setIdNI(cursor.getInt(0));
                naoinfetado.setNomeNI(cursor.getString(1));
                naoinfetado.setDatadenascimentoNI(cursor.getString(2));
                naoinfetado.setTelemovelNI(cursor.getString(3));
                naoinfetado.setLocalidadeNI(cursor.getString(4));
                naoinfetado.setSalaNI(cursor.getString(5));
                naoinfetado.setGeneroNI(cursor.getString(6));
                lista.add(naoinfetado);
            }while(cursor.moveToNext());
        }
        return lista;
    }
}
