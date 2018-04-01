package pa.senac.br.escolasenaccaio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pa.senac.br.escolasenaccaio.modelo.Aluno;
import pa.senac.br.escolasenaccaio.modelo.Curso;

/**
 * Created by TARDE on 22/03/2018.
 */

public class CursoDAO extends SQLiteOpenHelper {


    public CursoDAO(Context context) {
        super(context, "Cursos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE CURSO(idCurso INTEGER PRIMARY KEY,curso TEXT NOT NULL, ch TEXT NOT NULL, site TEXT);"; // REGRAS DE NOT NULL, OPÇÃO POR TEXT, NUMBER, ETC É FEITA NO
        // BANCO OU ATRAVÉS DO APP? Melhor fazer no java as validações!!!
        // PRECISA DO ; NO STRING SQL? Não

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insere(Curso curso){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("curso",curso.getCurso());
        dados.put("ch",curso.getCh());
        dados.put("site",curso.getSite());

        db.insert("CURSO",null,dados);


    }

    public List<Curso> buscaCursos() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from CURSO order by curso",null);

        List<Curso> listaCursos = new ArrayList<Curso>();

        while(cursor.moveToNext()){
            Curso curso = new Curso();
            curso.setCurso(cursor.getString(cursor.getColumnIndex("curso")));
            curso.setCh(cursor.getString(cursor.getColumnIndex("ch")));
            curso.setSite(cursor.getString(cursor.getColumnIndex("site")));

            listaCursos.add(curso);

        }

        return listaCursos;
    }
}
