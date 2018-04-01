package pa.senac.br.escolasenaccaio.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pa.senac.br.escolasenaccaio.R;
import pa.senac.br.escolasenaccaio.modelo.Aluno;

/**
 * Created by TARDE on 23/03/2018.
 */

public class AdapterAluno extends BaseAdapter {

    private final List<Aluno> alunos;
    private final Activity activity;

    public AdapterAluno (List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.lista_aluno_personalizada,parent,false);
        Aluno aluno = alunos.get(position);

        //pegando as referencias das Views
        TextView nome = view.findViewById(R.id.lista_aluno_personalizada_nome);
        TextView email = view.findViewById(R.id.lista_aluno_personalizada_email);
        TextView telefone = view.findViewById(R.id.lista_aluno_personalizada_telefone);
        TextView endereco = view.findViewById(R.id.lista_aluno_personalizada_endereco);

        ImageView imagem = view.findViewById(R.id.lista_aluno_personalizada_imagem);

        //populando as views
        // Falta colocar as condições se for null = setar o texto para "Nâo informado"'
        nome.setText(aluno.getNome());
        email.setText("E-mail: "+ aluno.getEmail());
        telefone.setText("Telefone: " + aluno.getTelefone());
        endereco.setText("Endereço: " + aluno.getEndereco());

        if(aluno.getSexo()!=null){
            if(aluno.getSexo().equals("M")) imagem.setImageResource(R.drawable.boy);
            else if(aluno.getSexo().equals("F")) imagem.setImageResource(R.drawable.girl);
        }

        //else imagem.setImageResource(R.drawable.icone_aluno);

        //        imagem.setImageResource(R.drawable.icone_aluno); // bota imagem padrao pra todos

        return view;
    }

}
