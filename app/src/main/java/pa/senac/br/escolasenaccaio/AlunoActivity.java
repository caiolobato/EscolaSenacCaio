package pa.senac.br.escolasenaccaio;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import pa.senac.br.escolasenaccaio.Adapter.AdapterAluno;
import pa.senac.br.escolasenaccaio.dao.AlunoDAO;
import pa.senac.br.escolasenaccaio.modelo.Aluno;

public class AlunoActivity extends AppCompatActivity {
//aaaaa
    ListView listViewAluno;
    FloatingActionButton botaoCadastrar;
    List<Aluno> listaDeAlunos;
    AlunoDAO alunoDAO;
    int i;
    Aluno aluno; // virou global pra usar lá no dialog

    protected void botaoCadastrar(View view) {
        Intent intent = new Intent(AlunoActivity.this,AlunoCadastraActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

//        String [] alunos = new String[]{"Caio","Luke","Leia","Maul","Chewbacca","Han Solo","Anakin","Mario","Luigi","Donkey King","Peach","Daisy","Wario","Waluigi",
//        "Yoshi","Toad","Link","Zelda","Ash","Pikachu"};

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                alunoDAO = new AlunoDAO(AlunoActivity.this);
//                      Aluno aluno = new Aluno(); // tirei esse aqui pq o Aluno aluno virou global pra usar no dialog
                aluno = new Aluno();

                AdapterView.AdapterContextMenuInfo menuInfo =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                int position = menuInfo.position;
                aluno = (Aluno) listViewAluno.getItemAtPosition(position);

                //Dialog box começa aqui
                AlertDialog.Builder dialog = new AlertDialog.Builder(AlunoActivity.this);
                dialog.setTitle("Excluir");
                dialog.setMessage("Tem certeza que deseja excluir este registro?");
                //dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.ic_delete);

                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alunoDAO.close();
                        carregaLista();
                    }
                });

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alunoDAO.deleta(aluno);
                        alunoDAO.close();
                        carregaLista();
                        Toast.makeText(AlunoActivity.this,"Aluno excluido",Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.create();
                dialog.show();
                //dialog termina aqui



// Assim que tava antes do dialog
//                alunoDAO = new AlunoDAO(AlunoActivity.this);
//                aluno = new Aluno();
//
//                AdapterView.AdapterContextMenuInfo menuInfo =
//                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
//                int position = menuInfo.position;
//
//                aluno = (Aluno) listViewAluno.getItemAtPosition(position);
//                alunoDAO.deleta(aluno);
//                alunoDAO.close();
//                carregaLista();
//                Toast.makeText(AlunoActivity.this,"Aluno excluido",Toast.LENGTH_SHORT).show();
//

                return false;
            }
        });

        //Comecei editar aqui
        menu.add("Editar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                alunoDAO = new AlunoDAO(AlunoActivity.this);
                Aluno aluno = new Aluno();

                AdapterView.AdapterContextMenuInfo menuInfo =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                int position = menuInfo.position;

                aluno = (Aluno) listViewAluno.getItemAtPosition(position);
                Intent intent = new Intent(AlunoActivity.this,AlunoCadastraActivity.class);
                intent.putExtra("Aluno", aluno);

                startActivity(intent);


                return false;
            }
        });
        // Editando Até aqui

    }

    @Override
    protected void onResume() {
        super.onResume();

        listViewAluno = findViewById(R.id.Id_main_listaAluno);
        botaoCadastrar = findViewById(R.id.Id_main_botaoCadastrar);

        registerForContextMenu(listViewAluno);
        carregaLista();

        // Editar antigo
//        listViewAluno.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Aluno aluno = new Aluno();
//                alunoDAO = new AlunoDAO(AlunoActivity.this);
//
//                aluno = (Aluno) listViewAluno.getItemAtPosition(i);
//                Intent intent = new Intent(AlunoActivity.this,AlunoCadastraActivity.class);
//                intent.putExtra("Aluno", aluno);
//
//                startActivity(intent);
//            }
//        });


    }

    protected void carregaLista() {
        // chamada antiga - lista do android
        // ArrayAdapter adapter = new ArrayAdapter(AlunoActivity.this,android.R.layout.simple_list_item_1,listaDeAlunos);

        alunoDAO = new AlunoDAO(this);
        listaDeAlunos = alunoDAO.buscaAlunos();
        //chamada da implementação lista
        AdapterAluno adapter = new AdapterAluno(listaDeAlunos, this);
        listViewAluno.setAdapter(adapter);
    }
}
