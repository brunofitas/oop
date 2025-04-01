package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa {

    public Professor(String nome, long numero) {
        super(nome, numero);
    }

    @Override
    public void adicionar(Aula aula) {
        super.adicionar(aula);
        aula.setProfessor(this);
    }

    public void remover(Aula aula) {
        super.remover(aula);
        aula.desassociarProfessor();
    }



    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(this.nome);

        for (Aluno aluno : aula.getAlunos()){
            aluno.preencherSumario(aula);
        }
    }


}
