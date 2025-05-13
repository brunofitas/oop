package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa {
    private GabineteSeguranca gabinete;
    private GestorFuncionario gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete){
        super(nome, numero);
        this.gabinete = gabinete;
        this.gestorFuncionario = new GestorFuncionario();
    }

    public LinkedList<Horario> getHorariosAtendimento(){
        return this.gestorFuncionario.getHorariosAtendimento();
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
        this.abrir(this.gabinete);
    }

    public void fecharGabinete(){
        this.fechar(this.gabinete);
    }

    public void abrir(Divisao divisao){
        if(divisao.isAberta()){
            return;
        }
        divisao.abrir();
    }

    public void fechar(Divisao divisao){
        if(!divisao.isAberta()){
            return;
        }
        divisao.fechar();
    }


}
