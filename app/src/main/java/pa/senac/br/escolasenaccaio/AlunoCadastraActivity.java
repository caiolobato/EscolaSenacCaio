package pa.senac.br.escolasenaccaio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pa.senac.br.escolasenaccaio.Helper.AlunoHelper;
import pa.senac.br.escolasenaccaio.dao.AlunoDAO;
import pa.senac.br.escolasenaccaio.modelo.Aluno;

public class AlunoCadastraActivity extends AppCompatActivity {

    //MOVIDO PARA A CLASSE HELPER---
    //EditText campoNome,campoTelefone,campoEndereco,campoEmail;
    //RadioGroup campoSexo;
    //RadioButton campoSexoMasculino,campoSexoFeminino;
    //-------------------------------

    Button botaoCadastrar;
    AlunoHelper helper;
    Aluno aluno;
    AlunoDAO dao;
    boolean editar = false; //quando falso é porque é inserção

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_cadastra);

        //MOVIDO PARA A CLASSE HELPER------------
        //campoNome = findViewById(R.id.Id_cadastra_nome);
        //campoTelefone = findViewById(R.id.Id_cadastra_telefone);
        //campoEndereco = findViewById(R.id.Id_cadastra_endereco);
        //campoEmail = findViewById(R.id.Id_cadastra_email);
        //campoSexo = findViewById(R.id.Id_cadastra_sexo);
        //campoSexoMasculino = findViewById(R.id.Id_cadastra_botaoMasc);
        //campoSexoFeminino = findViewById(R.id.Id_cadastra_botaoFem);
        //------------------------------------------


        // NÃO PRECISA SETAR O ID PARA O BUTAO
        //botaoCadastrar = findViewById(R.id.Id_cadastra_botaoAdd);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("Aluno");

        helper = new AlunoHelper(this,aluno); //alterar
        dao = new AlunoDAO(this);

        //edição
        if(aluno!=null){
            editar = true;
            helper.carregaCampos(aluno);
        }
    }


    protected void botaoCadastrar (View view) {

        //--------- FALTA COLOCAR A CONDIÇÃO DE TER Q TA MARCADO O SEXO SE NÃO NÃO VAI

        aluno = helper.pegaAluno();

        //insercao
        if(!editar){
            dao.insere(aluno);
            Toast.makeText(AlunoCadastraActivity.this,"Aluno ''" + aluno.getNome() + "'' cadastrado",Toast.LENGTH_SHORT).show();
        }
        //alterar
        else {
            dao.altera(aluno);
            Toast.makeText(AlunoCadastraActivity.this,"Aluno ''" + aluno.getNome() + "'' alterado",Toast.LENGTH_SHORT).show();
        }

        finish();

    }






}
