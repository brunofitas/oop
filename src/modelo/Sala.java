package modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas{

    private GestorAulas gestorAulas;

    public Sala(String nome, boolean aberta){
        super(nome, aberta);
        this.gestorAulas = new GestorAulas(this);
    }

    public boolean contem(Aula aula){ return this.gestorAulas.contem(aula);}
    public void associar(Aula aula){ aula.setSala(this);}
    public void desassociar(Aula aula){ aula.desassociarSala();}
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
