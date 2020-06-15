package com.example.trabalho_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BDInfetados {
    private SQLiteDatabase bd;

    public BDInfetados(Context context){
        this.bd = new SQLiteCore(context).getWritableDatabase();
    }

    public void insert(Infetados infetado){
        ContentValues dados = new ContentValues();
        dados.put("nome",infetado.getNome());
        dados.put("datadenascimento",infetado.getDatadenascimento());
        dados.put("telemovel",infetado.getTelemovel());
        dados.put("localidade",infetado.getLocalidade());
        dados.put("sala",infetado.getSala());
        dados.put("genero",infetado.getGenero());

        this.bd.insert("infetado",null, dados);
    }

    public void update(Infetados infetado){
        ContentValues dados = new ContentValues();
        dados.put("nome",infetado.getNome());
        dados.put("datadenascimento",infetado.getDatadenascimento());
        dados.put("telemovel",infetado.getTelemovel());
        dados.put("localidade",infetado.getLocalidade());
        dados.put("sala",infetado.getSala());
        dados.put("genero",infetado.getGenero());

        this.bd.update("infetado", dados, "id = ?", new String[]{"" + infetado.getId()});
    }

    public void delete(Infetados infetado){
        this.bd.delete("infetado","id = ?", new String[]{"" + infetado.getId()});
    }

    public List<Infetados> pesquisar(){
        List<Infetados> lista = new ArrayList<>();
        String[] colunas = new String[]{"id", "nome", "datadenascimento", "telemovel", "localidade", "sala", "genero"};
        Cursor cursor = this.bd.query("infetado", colunas, null, null, null, null, "nome DESC");

        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do{
                Infetados infetado =  new Infetados();
                infetado.setId(cursor.getInt(0));
                infetado.setNome(cursor.getString(1));
                infetado.setDatadenascimento(cursor.getString(2));
                infetado.setTelemovel(cursor.getString(3));
                infetado.setLocalidade(cursor.getString(4));
                infetado.setSala(cursor.getString(5));
                infetado.setGenero(cursor.getString(6));
                lista.add(infetado);
            }while(cursor.moveToNext());
        }
        return lista;
    }
}
