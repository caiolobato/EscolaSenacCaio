package pa.senac.br.escolasenaccaio.modelo;

import java.io.Serializable;

/**
 * Created by TARDE on 16/03/2018.
 */

public class Aluno implements Serializable{
    private int idAluno;
    private String nome, telefone, endereco, email, sexo;

    // Metodos Construtores
    public Aluno() {

    }



    public Aluno(String nome, String telefone, String endereco, String email, String sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.sexo = sexo;
    }


    //Metodos GETs e SETs


    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

//    @Override
//    public String toString() {
//        return nome + " - "+ sexo;
//    }
}
