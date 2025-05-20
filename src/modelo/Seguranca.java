package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario<GabineteSeguranca, Divisao> {
    private GestorFuncionario<GabineteSeguranca, Divisao> gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete){
        super(nome, numero);
        this.gestorFuncionario = new GestorFuncionario(this);
        this.setGabinete(gabinete);
    }

    @Override
    public GabineteSeguranca getGabinete() { return this.gestorFuncionario.getGabinete(); }

    @Override
    public void setGabinete(GabineteSeguranca gabinete){
        this.gestorFuncionario.setGabinete(gabinete);
    }

    @Override
    public void desassociarGabinete(){
        this.gestorFuncionario.desassociarGabinete();
    }

    @Override
    public void abrirGabinete(){
        this.gestorFuncionario.abrirGabinete();
    }

    @Override
    public void fecharGabinete(){
        this.gestorFuncionario.fecharGabinete();
    }

    @Override
    public void abrir(Divisao divisao){
        this.gestorFuncionario.abrir(divisao);
    }

    @Override
    public void fechar(Divisao divisao){
        this.gestorFuncionario.fechar(divisao);
    }

    @Override
    public void adicionar(Horario horario){
        this.gestorFuncionario.adicionar(horario);
    }

    @Override
    public void remover(Horario horario){
        this.gestorFuncionario.remover(horario);
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento(){
        return this.gestorFuncionario.getHorariosAtendimento();
    }


}
