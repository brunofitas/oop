package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario {
    private GabineteProfessor gabinete;
    private GestorFuncionario gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        this.gestorFuncionario = new GestorFuncionario();
        this.setGabinete(gabinete);
    }

    @Override
    public void associar(Aula aula){
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula){
        aula.desassociarProfessor();
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);

        for (Aluno aluno : aula.getAlunos()){
            aluno.preencherSumario(aula);
        }
    }



    public GabineteProfessor getGabinete(){ return this.gabinete; }

    public void setGabinete(GabineteProfessor gabinete){
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

    public void adicionar(Horario horario){
        this.gestorFuncionario.adicionar(horario);
    }

    public void remover(Horario horario){

        this.gestorFuncionario.remover(horario);
    }

    public LinkedList<Horario> getHorariosatendimento(){
        return this.gestorFuncionario.getHorariosAtendimento();
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


}
