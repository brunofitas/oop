package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Descritor{
    private boolean aberta;
    private LinkedList<Seguranca> segurancas;

    public GabineteSeguranca(String nome, boolean aberta){
        super(nome);
        this.aberta = aberta;
        this.segurancas = new LinkedList<Seguranca>();
    }

    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ this.aberta = true; }
    public void fechar(){ this.aberta = false; }
    public void adicionar(Seguranca seguranca){
        if(seguranca == null || this.segurancas.contains(seguranca)){
            return;
        }
        this.segurancas.add(seguranca);
        seguranca.setGabinete(this);

    }
    public void remover(Seguranca seguranca){
        if(!this.segurancas.contains(seguranca)){
            return;
        }
        this.segurancas.remove(seguranca);
        seguranca.desassociarGabinete();
    }
    public LinkedList<Seguranca> getSegurancas(){
        return new LinkedList<Seguranca>(this.segurancas);
    }
}
