package testes;

import modelo.*;

import java.security.InvalidParameterException;

public class Testes {

    public void testesSala(){
        Sala sala = new Sala("Sala1", false);
        assert sala.getNome() == "Sala1";
        assert sala.getAulas().size() == 0;
        assert sala.getAulas().isEmpty();
        assert sala.isAberta() == false;
        sala.abrir();
        assert sala.isAberta() == true;
        sala.fechar();
        assert sala.isAberta() == false;
    }

    public void testesAula(){
        Horario horario = new Horario(
                DiaSemana.SEGUNDA_FEIRA,
                8,
                1
        );
        Sala sala = new Sala("Sala1", false);
        Aula aula = new Aula("Aula 1",1234,horario, sala);
        assert aula.getNome() == "Aula 1";
        assert aula.getAlunos().isEmpty();
        assert aula.getProfessor() == null;
    }

    public void testesProfessor(){
        GabineteProfessor gabinete = new GabineteProfessor("gabinete", false);
        Professor professor = new Professor("John Doe", 1234, gabinete);
        assert professor.getNome() == "John Doe";
        assert professor.getNumero() == 1234;
        assert professor.getGabinete() == gabinete;
        professor.desassociarGabinete();
        assert professor.getGabinete() == null;
        professor.setGabinete(gabinete);
        assert professor.getGabinete() == gabinete;
        professor.abrirGabinete();
        assert professor.getGabinete().isAberta() == true;
        professor.fecharGabinete();
        assert professor.getGabinete().isAberta() == false;
    }

    public void testesSeguranca(){
        GabineteSeguranca gabinete = new GabineteSeguranca("Gabinete", false);
        Seguranca seguranca = new Seguranca("Rambo", 1234, gabinete);

        assert seguranca.getNome() == "Rambo";
        assert seguranca.getNumero() == 1234;
        assert seguranca.getGabinete().isAberta() == false;
        seguranca.abrirGabinete();
        assert seguranca.getGabinete().isAberta() == true;
        seguranca.fecharGabinete();
        assert seguranca.getGabinete().isAberta() == false;

        Sala sala = new Sala("sala1", false);
        assert sala.isAberta() == false;
        seguranca.abrir(sala);
        assert sala.isAberta() == true;
        seguranca.fechar(sala);
        assert sala.isAberta() == false;

    }

    public void testesAluno(){
        Aluno aluno = new Aluno("John Doe", 1234);
        assert aluno.getNome() == "John Doe";
        assert aluno.getNumero() == 1234;
        assert aluno.getAulas().size() == 0;
        DiaSemana segunda = DiaSemana.SEGUNDA_FEIRA;
        Sala sala = new Sala("sala1", false);
        Horario horario = new Horario(segunda, 8, 1);
        Aula aula = new Aula("aula 1", 987, horario,sala);
        aluno.adicionar(aula);
        assert aluno.getAulas().size() == 1;
    }

    public static void main(String[] args) {

        Testes test = new Testes();
        test.testesAluno();
        test.testesProfessor();
        test.testesSala();
        test.testesAula();
        test.testesSeguranca();
    }
}
