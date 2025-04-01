package modelo;

import java.util.LinkedList;

public class Aluno {
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    public Aluno(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        aulas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void adicionar(Aula aula){
        if (aula == null || aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.adicionar(this);
    }

    public void remover(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
        aula.remover(this);
    }

    public void preencherSumario(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }

        aula.adicionarLinhaSumario(nome);
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
