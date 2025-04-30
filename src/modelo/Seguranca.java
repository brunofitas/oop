package modelo;

import java.util.LinkedList;

public class Seguranca extends Identificador {
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete){
        super(nome, numero);
        this.gabinete = gabinete;
        this.horariosAtendimento = new LinkedList<>();
    }

    public GabineteSeguranca getGabinete() { return this.gabinete; }

    public void setGabinete(GabineteSeguranca gabinete){
        if(gabinete == null || this.gabinete == gabinete){
            return;
        }
        this.gabinete = gabinete;
        this.gabinete.adicionar(this);
    }

    public void desassociarGabinete(){
        if(this.gabinete == null){
            return;
        }
        this.gabinete.remover(this);
        this.gabinete = null;
    }

    public void abrirGabinete(){
        if(this.gabinete == null || this.gabinete.isAberta()){
            return;
        }
        this.gabinete.abrir();
    }

    public void fecharGabinete(){
        if(this.gabinete == null || !this.gabinete.isAberta()){
            return;
        }
        this.gabinete.fechar();
    }

    public void abrir(Sala sala){
        if(sala.isAberta()){
            return;
        }
        sala.abrir();
    }

    public void fechar(Sala sala){
        if(!sala.isAberta()){
            return;
        }
        sala.fechar();
    }

    public void abrir(GabineteProfessor gabinete){
        if(gabinete.isAberta()){
            return;
        }
        gabinete.abrir();
    }

    public void fechar(GabineteProfessor gabinete){
        if(!gabinete.isAberta()){
            return;
        }
        gabinete.fechar();
    }

    public void abrir(GabineteSeguranca gabinete){
        if(gabinete.isAberta()){
            return;
        }
        gabinete.abrir();
    }

    public void fechar(GabineteSeguranca gabinete){
        if(!gabinete.isAberta()){
            return;
        }
        gabinete.fechar();
    }

}
