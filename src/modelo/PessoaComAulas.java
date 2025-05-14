package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas{
    protected GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero){
        super(nome, numero);
        this.gestorAulas = new GestorAulas(this);
    }

    public void preencherSumario(Aula aula){
        if (!this.gestorAulas.contem(aula)){
            return;
        }
        this.escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula){}

    @Override
    public boolean contem(Aula aula){ return this.gestorAulas.contem(aula);}

    @Override
    public LinkedList<Aula> getAulas() {
        return this.gestorAulas.getAulas();
    }
    @Override
    public LinkedList<Aula> getAulas(Horario horario) {
        return this.gestorAulas.getAulas(horario);
    }
    @Override
    public void adicionar(Aula aula) {
        this.gestorAulas.adicionar(aula);
    }

    @Override
    public void remover(Aula aula){
        this.gestorAulas.remover(aula);
    }
}
