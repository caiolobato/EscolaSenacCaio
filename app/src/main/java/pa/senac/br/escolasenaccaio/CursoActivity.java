package pa.senac.br.escolasenaccaio;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import pa.senac.br.escolasenaccaio.dao.CursoDAO;
import pa.senac.br.escolasenaccaio.modelo.Curso;

public class CursoActivity extends AppCompatActivity {

    FloatingActionButton botaoCadastrar;
    ListView listViewCurso;
    List<Curso> listaCurso;
    CursoDAO cursoDAO;


    protected void botaoCadastrar(View view){

        Intent intent = new Intent(CursoActivity.this,CursoCadastraActivity.class);

        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

    }

    @Override
    protected void onResume() {
        super.onResume();

        listViewCurso = findViewById(R.id.Id_cadastraCurso_listaCurso);
        botaoCadastrar = findViewById(R.id.Id_curso_botaoCadastrar);


        cursoDAO = new CursoDAO(this);
        listaCurso = cursoDAO.buscaCursos();



        ArrayAdapter adapter = new ArrayAdapter(CursoActivity.this,android.R.layout.simple_list_item_1,listaCurso);

        listViewCurso.setAdapter(adapter);

    }
}
