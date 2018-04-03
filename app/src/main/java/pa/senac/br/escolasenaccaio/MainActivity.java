package pa.senac.br.escolasenaccaio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton alunos,cursos;

    public void botaoAluno (View view) {
        Intent intent = new Intent(this,AlunoActivity.class);
        startActivity(intent);
    }


    public void botaoCurso (View view) {
        Intent intent = new Intent(this,CursoActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    @Override
    protected void onResume() {
        super.onResume();

        alunos = findViewById(R.id.main_alunoBtn);
        cursos = findViewById(R.id.main_cursosBtn);


    }
}
