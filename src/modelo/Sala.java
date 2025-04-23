package modelo;

import java.util.LinkedList;

public class Sala {
    private String nome;
    private boolean aberta;
    private LinkedList<Aula> aulas;

    public Sala(String nome, boolean aberta){

    }

    public String getNome() { return this.nome; }
    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ this.aberta = true; }
    public void fechar() { this.aberta = false; }
    public void adicionar(Aula aula){ /** TODO - adicionar **/ }
    public void remover(Aula aula){ /** TODO - remover **/ }
    public LinkedList<Aula> getAulas() { return new LinkedList<Aula>(this.aulas);}
    public LinkedList<Aula> getAulas(Horario horario) {
        // TODO - getAulas
        return null;
    }









}
