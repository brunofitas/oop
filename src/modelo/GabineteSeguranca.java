package modelo;

import java.util.LinkedList;

public class GabineteSeguranca {
    private String nome;
    private boolean aberta;
    private LinkedList<Seguranca> segurancas;

    // TODO - Constructor

    public String getNome(){ return this.nome; }
    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ /** TODO - abrir **/ }
    public void fechar(){ /** TODO - fechar **/ }
    public void adicionar(Seguranca seguranca){ /** TODO - adicionar **/ }
    public void remover(Seguranca seguranca){ /** TODO - remover **/ }
    public LinkedList<Seguranca> getSegurancas(){
        return new LinkedList<Seguranca>(this.segurancas);
    }
}
