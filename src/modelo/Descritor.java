package modelo;

public abstract class Descritor {
    protected String nome;

    public Descritor(String nome){
        this.nome = nome;
    }

    public String getNome(){ return nome; }
}
