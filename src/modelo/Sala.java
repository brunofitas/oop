package modelo;

import java.util.LinkedList;

public class Sala {
    private String nome;
    private boolean aberta;
    private LinkedList<Aula> aulas;

    public Sala(String nome, boolean aberta){
        this.nome = nome;
        this.aberta = aberta;
    }

    public String getNome(){ return this.nome; }
    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ this.aberta = true;}
    public void fechar(){ this.aberta = false;}
    public void adicionar(Aula aula){
        if (aula == null || this.aulas.contains(aula)) {
            return;
        }
        this.aulas.add(aula);
        // TODO - aula.setAula(this)

    }
    public void remover(Aula aula){
        if (!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
        // TODO - aula.desassociarSala()
    }
    public LinkedList<Aula> getAulas(){ return new LinkedList<>(aulas);}
    public LinkedList<Aula> getAulas(Horario horario){
        LinkedList<Aula> listaAuxiliar = new LinkedList<>();
        for (Aula aula : aulas) {
            if (aula.getHorario().isSobre(horario)) {
                listaAuxiliar.add(aula);
            }
        }
        return listaAuxiliar;
    }


}
