package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor, Sala> {
    private GestorFuncionario<GabineteProfessor, Sala> gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        this.gestorFuncionario = new GestorFuncionario<>();
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

    @Override
    public GabineteProfessor getGabinete(){
        return this.gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete(GabineteProfessor gabinete){
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
    public void abrir(Sala sala){
        this.gestorFuncionario.abrir(sala);
    }

    @Override
    public void fechar(Sala sala){
        this.gestorFuncionario.fechar(sala);
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
