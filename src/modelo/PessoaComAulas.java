package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa{
    protected GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero){
        super(nome, numero);
        this.gestorAulas = new GestorAulas();
    }

    protected abstract void associar(Aula aula);
    protected abstract void desassociar(Aula aula);

    public void adicionar(Aula aula) {
        this.gestorAulas.adicionar(aula);
    }

    public void remover(Aula aula){
        this.gestorAulas.remover(aula);
    }

    public void preencherSumario(Aula aula){
        if (!this.gestorAulas.contem(aula)){
            return;
        }
        this.escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula){}

    public LinkedList<Aula> getAulas() {
        return this.gestorAulas.getAulas();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return this.gestorAulas.getAulas(horario);
    }
}
