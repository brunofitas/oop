package modelo;

import java.util.LinkedList;

public class GabineteProfessor {
    private String nome;
    private boolean aberta;
    private LinkedList<Professor> professores;

    // TODO - Constructor

    public String getNome(){ return this.nome; }
    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ /** TODO - abrir **/ }
    public void fechar(){ /** TODO - fechar **/ }
    public void adicionar(Professor professor){ /** TODO - adicionar **/ }
    public void remover(Professor professor){ /** TODO - remover **/ }
    public LinkedList<Professor> getProfessores(){
        return new LinkedList<Professor>(professores);
    }


}
