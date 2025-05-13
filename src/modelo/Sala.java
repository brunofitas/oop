package modelo;

import java.util.LinkedList;

public class Sala extends Divisao {

    private GestorAulas gestorAulas;

    public Sala(String nome, boolean aberta){
        super(nome, aberta);
        this.gestorAulas = new GestorAulas();
    }

    public void adicionar(Aula aula){
        this.gestorAulas.adicionar(aula);
    }
    public void remover(Aula aula){
        this.gestorAulas.remover(aula);
    }
    public LinkedList<Aula> getAulas() {
       return this.gestorAulas.getAulas();
    }
    public LinkedList<Aula> getAulas(Horario horario) {
        return this.gestorAulas.getAulas(horario);
    }









}
