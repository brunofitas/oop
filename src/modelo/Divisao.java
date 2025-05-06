package modelo;

public abstract class Divisao extends Descritor{
    protected boolean aberta;

    public Divisao(String nome, boolean aberta){
        super(nome);
        this.aberta = aberta;
    }

    public boolean isAberta(){ return this.aberta; }
    public void abrir(){ this.aberta = true; }
    public void fechar(){ this.aberta = false; }
}
