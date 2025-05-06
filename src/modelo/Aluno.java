package modelo;

public class Aluno extends PessoaComAulas {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    @Override
    protected void associar(Aula aula){
        aula.adicionar(this);
    }

    @Override
    protected void desassociar(Aula aula){
        aula.remover(this);
    }

    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(this.nome);
    }



}
