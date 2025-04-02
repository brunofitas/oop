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

    @Override
    public void remover(Aula aula) {
        super.remover(aula);
        aula.desassociarProfessor();
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);

        for (Aluno aluno : aula.getAlunos()){
            aluno.preencherSumario(aula);
        }
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
