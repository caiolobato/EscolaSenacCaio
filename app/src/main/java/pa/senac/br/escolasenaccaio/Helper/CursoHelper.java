package pa.senac.br.escolasenaccaio.Helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pa.senac.br.escolasenaccaio.CursoCadastraActivity;
import pa.senac.br.escolasenaccaio.R;
import pa.senac.br.escolasenaccaio.modelo.Curso;

/**
 * Created by TARDE on 22/03/2018.
 */

public class CursoHelper {

    EditText campoCurso,campoCH,campoSite;
    Curso curso;

    public CursoHelper(CursoCadastraActivity activity) {
        this.campoCurso = activity.findViewById(R.id.Id_cursoCadastra_nome);
        this.campoCH = activity.findViewById(R.id.Id_cursoCadastra_ch);;
        this.campoSite = activity.findViewById(R.id.Id_cursoCadastra_site);;
        curso = new Curso();// Duvida -> pra que isso aqui? Poderia ser só no inicio do metodo pegaCurso()? Poderia ser no metodo pegaCurso() mas se tivesse outros metodos ia ter
        // q instanciar sempre, por isso é melhor deixar no Construtor
    }

    public Curso pegaCurso() {

        curso.setCurso(campoCurso.getText().toString());
        curso.setCh(campoCH.getText().toString());
        curso.setSite(campoSite.getText().toString());

        return curso;

    }


}
