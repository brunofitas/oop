package modelo;

import java.util.LinkedList;

public abstract class Gabinete<T extends Funcionario> extends Divisao{
    private LinkedList<T> funcionarios;

    public Gabinete(String nome, boolean aberta){
        super(nome, aberta);
    }

    public void adicionar(T funcionario){
        if (funcionario == null || this.funcionarios.contains(funcionario)) {
            return;
        }
        this.funcionarios.add(funcionario);
        //TODO - funcionario.setGabinete(this);

    }
    public void remover(T funcionario){
        if(!this.funcionarios.contains(funcionario)){
            return;
        }
        this.funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }
    public LinkedList<T> getFuncionarios(){
        return new LinkedList<T>(this.funcionarios);
    }


}
