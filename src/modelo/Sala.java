package modelo;

import java.util.LinkedList;

public class Sala extends Divisao {

    private LinkedList<Aula> aulas;

    public Sala(String nome, boolean aberta){
        super(nome, aberta);
        this.aulas = new LinkedList<Aula>();
    }

    public void adicionar(Aula aula){
        if(aula == null || this.aulas.contains(aula)){
            return;
        }
        this.aulas.add(aula);
        aula.setSala(this);
    }
    public void remover(Aula aula){
        if(!this.aulas.contains(aula)){
            return;
        }
        this.aulas.remove(aula);
        aula.desassociarSala();
    }
    public LinkedList<Aula> getAulas() {
        return new LinkedList<Aula>(this.aulas);
    }
    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> listaAuxiliar = new LinkedList<>();

        for(Aula a: this.aulas) {
           if(a.getHorario().isSobre(horario)){
               listaAuxiliar.add(a);
           }
        }
        return listaAuxiliar;

    }









}
