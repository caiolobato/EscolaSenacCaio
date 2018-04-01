package pa.senac.br.escolasenaccaio.Helper;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import pa.senac.br.escolasenaccaio.AlunoCadastraActivity;
import pa.senac.br.escolasenaccaio.R;
import pa.senac.br.escolasenaccaio.modelo.Aluno;

/**
 * Created by TARDE on 20/03/2018.
 */

public class AlunoHelper {

    EditText campoNome,campoTelefone,campoEndereco,campoEmail;
    RadioGroup campoSexo;
    RadioButton campoSexoMasculino,campoSexoFeminino;

    Aluno aluno;


    public AlunoHelper(AlunoCadastraActivity activity,Aluno aluno) {
        this.campoNome = activity.findViewById(R.id.Id_cadastra_nome);
        this.campoTelefone = activity.findViewById(R.id.Id_cadastra_telefone);
        this.campoEndereco = activity.findViewById(R.id.Id_cadastra_endereco);
        this.campoEmail = activity.findViewById(R.id.Id_cadastra_email);
        this.campoSexo = activity.findViewById(R.id.Id_cadastra_sexo);
        this.campoSexoMasculino = activity.findViewById(R.id.Id_cadastra_botaoMasc);
        this.campoSexoFeminino = activity.findViewById(R.id.Id_cadastra_botaoFem);
        this.aluno = aluno;
    }


    public Aluno pegaAluno(){
        //aluno = new Aluno(); //alterei aqui
        //aluno.setIdAluno(aluno.getIdAluno()); //alterei aqui

        if(aluno==null) aluno = new Aluno();


        aluno.setNome(campoNome.getText().toString());
//        aluno.setTelefone(campoTelefone.getText().toString());
//        aluno.setEndereco(campoEndereco.getText().toString());
//        aluno.setEmail(campoEmail.getText().toString());

        if(campoTelefone.getText().toString().equals("")) aluno.setTelefone("NÃO INFORMADO");
        else aluno.setTelefone(campoTelefone.getText().toString());

        if(campoEndereco.getText().toString().equals("")) aluno.setEndereco("NÃO INFORMADO");
        else aluno.setEndereco(campoEndereco.getText().toString());

        if(campoEmail.getText().toString().equals("")) aluno.setEmail("NÃO INFORMADO");
        else aluno.setEmail(campoEmail.getText().toString());



        switch (campoSexo.getCheckedRadioButtonId()){
            case R.id.Id_cadastra_botaoMasc:
                aluno.setSexo("M");
                break;
            case R.id.Id_cadastra_botaoFem:
                aluno.setSexo("F");
                break;
            default:
                aluno.setSexo("");
                break;
        }

        return aluno;
    }


    public void carregaCampos(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());

        if(aluno.getSexo().equals("M")) campoSexoMasculino.setChecked(true);
        else if(aluno.getSexo().equals("F")) campoSexoFeminino.setChecked(true);

    }
}
