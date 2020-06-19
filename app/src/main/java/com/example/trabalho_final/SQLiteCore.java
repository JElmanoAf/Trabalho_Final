package com.example.trabalho_final;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteCore extends SQLiteOpenHelper {
    private static final String nomeBD = "BaseDeDados";
    private static final int versao = 1;

    public SQLiteCore(Context context){
        super(context, nomeBD, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE infetado(id integer primary key autoincrement, nome text, datadenascimento text, telemovel text, localidade text, sala text, genero text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        if ((oldVersion == 1) && (newVersion == 2)){
            bd.execSQL("ALTER TABLE infetados ADD COLUMN teste TEXT;");
        }
    }
}
