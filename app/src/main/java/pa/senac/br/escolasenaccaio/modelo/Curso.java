package pa.senac.br.escolasenaccaio.modelo;

/**
 * Created by TARDE on 22/03/2018.
 */

public class Curso {

    private String curso,ch,site;

    //Métodos Construtores
    public Curso (){

    }

    public Curso(String curso, String ch, String site) {
        this.curso = curso;
        this.ch = ch;
        this.site = site;
    }


    //Métodos GETs e SETs
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return curso + " - " + ch + "h - " + site; //
    }
}
