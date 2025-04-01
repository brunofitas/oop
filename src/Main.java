import modelo.*;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public Main() {
        System.out.println(DiaSemana.DOMINGO);
        System.out.println(DiaSemana.DOMINGO.ordinal());
        System.out.println(Arrays.toString(DiaSemana.values()));
        System.out.println(DiaSemana.values().length);

        Professor professor1 = new Professor("Manuel Gomes", 1);
        Professor professor2 = new Professor("Carlos Miguel", 2);

        Aluno aluno1 = new Aluno("José António", 2190354);
        Aluno aluno2 = new Aluno("Carlos Santos", 2191187);

        LinkedList<Aluno> alunos = new LinkedList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);

        Aula aula1 = new Aula("Programação 2 TP1", 1, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2), professor1, alunos);
        Aula aula2 = new Aula("Programação 2 PL1", 1, new Horario(DiaSemana.TERCA_FEIRA, 11, 3));
        Aula aula3 = new Aula("Programação 2 PL2", 1, new Horario(DiaSemana.TERCA_FEIRA, 15, 3));

        aula2.setProfessor(professor2);
        aula2.adicionar(aluno1);

        aula3.setProfessor(professor2);
        aula3.adicionar(aluno2);

        LinkedList<Aula> aulasProfessor1 = professor1.getAulas();
        LinkedList<Aula> aulasAluno1 = aluno1.getAulas();

        LinkedList<Aula> aulasProfessor1SegundaFeiraManha = professor1.getAulas(new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 6));
        LinkedList<Aula> aulasProfessor1SegundaFeiraTarde = professor1.getAulas(new Horario(DiaSemana.SEGUNDA_FEIRA, 14, 10));

        LinkedList<Aula> aulasProfessor2TercaFeiraManha = professor2.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 8, 6));
        LinkedList<Aula> aulasProfessor2TercaFeira = professor2.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 8, 16));

        LinkedList<Aula> aulasAluno1TercaFeira = aluno1.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 8, 16));

        Professor professor3 = new Professor("António João", 3);
        Aluno aluno3 = new Aluno("João Santos", 2192312);
        Aula aula4 = new Aula("Matemática Discreta", 1, new Horario(DiaSemana.TERCA_FEIRA, 18, 2));

        aula4.setProfessor(professor3);
        for (Aluno aluno : alunos) {
            aula4.adicionar(aluno);
        }
        aula4.adicionar(aluno3);

        LinkedList<Aula> aulasAluno2TercaFeiraTarde = aluno2.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 14, 10));
        LinkedList<Aula> aulasAluno2TercaFeiraAposAsDezanoveHoras = aluno2.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 19, 5));
        LinkedList<Aula> aulasAluno2TercaFeiraAposAsVinteHoras = aluno2.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 20, 4));

        LinkedList<Aula> aulasAluno3TercaFeira = aluno3.getAulas(new Horario(DiaSemana.TERCA_FEIRA, 8, 16));
    }

    public static void main(String[] args) {
        new Main();
    }
}
