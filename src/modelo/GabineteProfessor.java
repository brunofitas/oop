package modelo;

import java.util.LinkedList;

public class GabineteProfessor extends Descritor{

    private boolean aberta;
    private LinkedList<Professor> professores;

    public GabineteProfessor(String nome, boolean aberta){
        super(nome);
        this.aberta = aberta;
        this.professores = new LinkedList<Professor>();
    }

    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ this.aberta = true; }
    public void fechar(){ this.aberta = false; }
    public void adicionar(Professor professor){
        if (professor == null || this.professores.contains(professor)) {
            return;
        }
        this.professores.add(professor);
        professor.setGabinete(this);

    }
    public void remover(Professor professor){
        if(!this.professores.contains(professor)){
            return;
        }
        this.professores.remove(professor);
        professor.desassociarGabinete();
    }
    public LinkedList<Professor> getProfessores(){
        return new LinkedList<Professor>(professores);
    }


}
