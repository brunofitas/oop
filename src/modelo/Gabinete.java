package modelo;

import java.util.LinkedList;

public abstract class Gabinete<T extends Funcionario> extends Divisao{
    private LinkedList<T> funcionarios;

    public Gabinete(String nome, boolean aberta){
        super(nome, aberta);
        this.funcionarios = new LinkedList<T>();
    }

    public void adicionar(T funcionario){
        if (funcionario == null || this.funcionarios.contains(funcionario)) {
            return;
        }
        this.funcionarios.add(funcionario);
        //funcionario.setGabinete(this);

    }
    public void remover(T funcionario){
        if(!this.funcionarios.contains(funcionario)){
            return;
        }
        this.funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }


}
