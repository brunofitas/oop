package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {
    protected LinkedList<Aula> aulas;

    public Pessoa(String nome, long numero){
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }

    public void adicionar(Aula aula) {
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }
        this.aulas.add(aula);
    }

    public void remover(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
    }

    public void preencherSumario(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }
        this.escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

}
