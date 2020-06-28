package com.example.trabalho_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProfissionaisBD {
    private SQLiteDatabase bd;

    public ProfissionaisBD(Context context){ this.bd = new SQLiteCore(context).getWritableDatabase(); }

    public void insert(Profissionais profissional){
        ContentValues dados = new ContentValues();
        dados.put("nome",profissional.getNomeP());
        dados.put("datadenascimento",profissional.getDatadenascimentoP());
        dados.put("telemovel",profissional.getTelemovelP());
        dados.put("localidade",profissional.getLocalidadeP());
        dados.put("genero",profissional.getGeneroP());

        this.bd.insert("profissional",null, dados);
    }

    public void update(Profissionais profissional){
        ContentValues dados = new ContentValues();
        dados.put("nome",profissional.getNomeP());
        dados.put("datadenascimento",profissional.getDatadenascimentoP());
        dados.put("telemovel",profissional.getTelemovelP());
        dados.put("localidade",profissional.getLocalidadeP());
        dados.put("genero",profissional.getGeneroP());

        this.bd.update("profissional", dados, "id = ?", new String[]{"" + profissional.getIdP()});
    }

    public void delete(Profissionais profissional){
        this.bd.delete("profissional","id = ?", new String[]{"" + profissional.getIdP()});
    }

    public ArrayList<Profissionais> pesquisar(){
        ArrayList<Profissionais> lista = new ArrayList<>();
        String[] colunas = new String[]{"id", "nome", "datadenascimento", "telemovel", "localidade", "genero"};
        Cursor cursor = this.bd.query("profissional", colunas, null, null, null, null, "nome DESC");

        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do{
                Profissionais profissional =  new Profissionais();
                profissional.setIdP(cursor.getInt(0));
                profissional.setNomeP(cursor.getString(1));
                profissional.setDatadenascimentoP(cursor.getString(2));
                profissional.setTelemovelP(cursor.getString(3));
                profissional.setLocalidadeP(cursor.getString(4));
                profissional.setGeneroP(cursor.getString(5));
                lista.add(profissional);
            }while(cursor.moveToNext());
        }
        return lista;
    }
}
