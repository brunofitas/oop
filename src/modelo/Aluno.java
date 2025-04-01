package modelo;

import java.util.LinkedList;

public class Aluno extends Pessoa {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    @Override
    public void adicionar(Aula aula){
        super.adicionar(aula);
        aula.adicionar(this);
    }

    @Override
    public void remover(Aula aula){
        super.remover(aula);
        aula.remover(this);
    }

    public void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(nome);
    }


}
