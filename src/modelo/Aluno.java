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

    public void remover(Aula aula){
        super.remover(aula);
        aula.remover(this);
    }

    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(this.nome);
    }

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
