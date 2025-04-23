package testes;

import modelo.*;

public class Testes {

    public void testesSala(){
        Sala sala = new Sala();
    }

    public void testesProfessor(){
        Professor professor = new Professor("John Doe", 1234);
        assert professor.getNome() == "John Doe";
        assert professor.getNumero() == 1234;
    }

    public void testesAluno(){
        Aluno aluno = new Aluno("John Doe", 1234);
        assert aluno.getNome() == "John Doe";
        assert aluno.getNumero() == 1234;
        assert aluno.getAulas().size() == 0;
        DiaSemana segunda = DiaSemana.SEGUNDA_FEIRA;
        Horario horario = new Horario(segunda, 8, 1);
        Aula aula = new Aula("aula 1", 987, horario);
        aluno.adicionar(aula);
        assert aluno.getAulas().size() == 1;
    }

    public static void main(String[] args) {

        Testes test = new Testes();
        test.testesAluno();
        test.testesProfessor();
    }
}
