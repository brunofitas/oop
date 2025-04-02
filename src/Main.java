import modelo.*;

import java.util.LinkedList;

public class Main {

    public Main() {
        Aluno aluno1 = new Aluno("José Santos", 1);
        Professor professor1 = new Professor("Manuel Silva", 1);
        Aula aula1 = new Aula("Programação II TP1", 1, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2));

        Identificador identificador1 = aluno1;
        Identificador identificador2 = professor1;

        LinkedList<Identificador> identificadores = new LinkedList<>();
        identificadores.add(aula1);
        identificadores.add(professor1);
        identificadores.add(aluno1);

        for(Identificador identificador: identificadores){
            System.out.println(identificador.getNome());
        }


        System.out.println(aluno1.getNome());
        System.out.println(professor1.getNome());
        System.out.println(identificador1.getNome());
        System.out.println(identificador2.getNome());

        professor1.adicionar(aula1);
        aluno1.adicionar(aula1);
    }

    public static void main(String[] args) {
        new Main();
    }
}
