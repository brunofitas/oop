package modelo;

import java.util.LinkedList;

public class GestorAulas {
    private LinkedList<Aula> aulas;

    public GestorAulas(){
        this.aulas = new LinkedList<Aula>();
    }

    public void adicionar(Aula aula) {
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }
        this.aulas.add(aula);
        // TODO - aula.setSala(this)
    }

    public void remover(Aula aula){
        if (!this.aulas.contains(aula)){
            return;
        }
        this.aulas.remove(aula);
        // TODO - aula.desassociarSala();
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(this.aulas);
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

    public boolean contem(Aula aula){
        return this.aulas.contains(aula);
    }



}
