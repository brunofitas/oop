package modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas {

    private GestorAulas gestorAulas;

    public Sala(String nome, boolean aberta){
        super(nome, aberta);
        this.gestorAulas = new GestorAulas(this);
    }

    @Override
    public boolean contem(Aula aula){ return this.gestorAulas.contem(aula);}

    @Override
    public void associar(Aula aula){ aula.setSala(this);}

    @Override
    public void desassociar(Aula aula){ aula.desassociarSala();}

    @Override
    public void adicionar(Aula aula){
        this.gestorAulas.adicionar(aula);
    }
    @Override
    public void remover(Aula aula){
        this.gestorAulas.remover(aula);
    }
    @Override
    public LinkedList<Aula> getAulas() {
       return this.gestorAulas.getAulas();
    }
    @Override
    public LinkedList<Aula> getAulas(Horario horario) {
        return this.gestorAulas.getAulas(horario);
    }









}
