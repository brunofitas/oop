package modelo;

import java.util.LinkedList;

public class GestorFuncionario<TGabinete extends Gabinete, TDivisao extends Divisao> {
    private Funcionario<TGabinete, TDivisao> funcionario;
    private LinkedList<Horario> horariosAtendimento;
    private TGabinete gabinete;

    public GestorFuncionario(Funcionario<TGabinete, TDivisao> funcionario) {
        this.funcionario = funcionario;
        this.horariosAtendimento = new LinkedList<>();
    }

    public void adicionar(Horario horario){
        if(this.horariosAtendimento.contains(horario)){
            return;
        }
        this.horariosAtendimento.add(horario);
    }

    public void remover(Horario horario){
        this.horariosAtendimento.remove(horario);
    }

    public LinkedList<Horario> getHorariosAtendimento(){
        return new LinkedList<>(this.horariosAtendimento);
    }

    public TGabinete getGabinete() { return this.gabinete; }

    public void setGabinete(TGabinete gabinete){
        if(gabinete == null || this.gabinete == gabinete){
            return;
        }
        this.gabinete = gabinete;
        this.gabinete.adicionar(this.funcionario);
    }
    public void desassociarGabinete(){
        if(this.gabinete == null){
            return;
        }
        this.gabinete.remover(this.funcionario);
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

    public void abrir(TDivisao divisao){
        if(divisao.isAberta()){
            return;
        }
        divisao.abrir();
    }

    public void fechar(TDivisao divisao){
        if(!divisao.isAberta()){
            return;
        }
        divisao.fechar();
    }
}
