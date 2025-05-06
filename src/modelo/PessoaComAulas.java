package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa{
    protected LinkedList<Aula> aulas;

    public PessoaComAulas(String nome, long numero){
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }

    protected abstract void associar(Aula aula);
    protected abstract void desassociar(Aula aula);

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

    protected void assinarSumario(Aula aula){}

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> listaAuxiliar = new LinkedList<>();
        for (Aula aula : aulas) {
            if (aula.getHorario().isSobre(horario)) {
                listaAuxiliar.add(aula);
            }
        }
        return listaAuxiliar;
    }
}
