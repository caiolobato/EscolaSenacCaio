package pa.senac.br.escolasenaccaio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pa.senac.br.escolasenaccaio.modelo.Aluno;

/**
 * Created by TARDE on 20/03/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper {


    public AlunoDAO(Context context) {
        super(context, "AGENDA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE ALUNO(idAluno INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL, telefone TEXT, endereco TEXT, email TEXT, sexo TEXT)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public List<Aluno> buscaAlunos () {
        SQLiteDatabase db = getReadableDatabase(); // Criando objeto de leitura de banco
        Cursor cursor = db.rawQuery("select * from ALUNO order by nome",null);

        List<Aluno> listaDeAlunos = new ArrayList<Aluno>();

        while(cursor.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.setIdAluno(cursor.getInt(cursor.getColumnIndex("idAluno")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));

            listaDeAlunos.add(aluno);

        }

        return listaDeAlunos;
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(aluno);
        db.insert("Aluno",null,dados);
    }

    @NonNull
    public ContentValues getContentValues(Aluno aluno) {
        ContentValues dados = new ContentValues();

        dados.put("nome",aluno.getNome());
        dados.put("telefone",aluno.getTelefone());
        dados.put("endereco",aluno.getEndereco());
        dados.put("email",aluno.getEmail());

        //TIREI ESSAS COISAS PQ ESTOU TRATANDO TUDO NO HELPER
//        if(aluno.getTelefone().equals("")) dados.put("telefone","NÃO INFORMADO");
//        else dados.put("telefone",aluno.getTelefone());
//
//        if(aluno.getEndereco().equals("")) dados.put("endereco","NÃO INFORMADO");
//        else  dados.put("endereco",aluno.getEndereco());
//
//        if(aluno.getEmail().equals("")) dados.put("email","NÃO INFORMADO");
//        else  dados.put("email",aluno.getEmail());

        dados.put("sexo",aluno.getSexo()); //<<------ esse aqui era pra ser obrigatorio

        return dados;
    }


    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String [] parametro = {String.valueOf(aluno.getIdAluno())};
        db.delete("ALUNO","idAluno=?",parametro);
    }




    public void altera(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(aluno);
        String [] parametro = {String.valueOf((aluno.getIdAluno()))};
        db.update("ALUNO",dados,"idAluno=?",parametro);
    }
}
