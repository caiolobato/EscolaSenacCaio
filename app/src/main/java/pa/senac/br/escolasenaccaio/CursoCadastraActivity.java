package pa.senac.br.escolasenaccaio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import pa.senac.br.escolasenaccaio.Helper.CursoHelper;
import pa.senac.br.escolasenaccaio.dao.CursoDAO;
import pa.senac.br.escolasenaccaio.modelo.Curso;

public class CursoCadastraActivity extends AppCompatActivity {



    protected void botaoCadastrar(View view){

        Curso curso = new Curso();
        CursoHelper helper = new CursoHelper(this);

        curso = helper.pegaCurso();

        CursoDAO dao = new CursoDAO(this);
        dao.insere(curso);


        Toast.makeText(CursoCadastraActivity.this,"Curso ''" + curso.getCurso() + "'' cadastrado",Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_cadastra);
    }






}
