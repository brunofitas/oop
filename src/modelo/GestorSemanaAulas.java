package modelo;

import java.util.LinkedList;

public enum GestorSemanaAulas {
    INSTANCIA;

    private LinkedList<Professor> professores;
    private LinkedList<Seguranca> segurancas;
    private LinkedList<Aluno> alunos;
    private LinkedList<Aula> aulas;

    GestorSemanaAulas() {
        professores = new LinkedList<>();
        segurancas = new LinkedList<>();
        alunos = new LinkedList<>();
        aulas = new LinkedList<>();

        popularDados();
    }

    public void adicionar(Professor professor) {
        if (professor == null || professores.contains(professor)) {
            return;
        }
        professores.add(professor);
        for (Aula aula : professor.getAulas()) {
            adicionar(aula);
        }
    }

    public void remover(Professor professor) {
        professores.remove(professor);
    }

    public void adicionar(Seguranca seguranca) {
        if (seguranca == null || segurancas.contains(seguranca)) {
            return;
        }
        segurancas.add(seguranca);
    }

    public void remover(Seguranca seguranca) {
        segurancas.remove(seguranca);
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }

        aulas.add(aula);
        adicionar(aula.getProfessor());

        for (Aluno aluno : aula.getAlunos()) {
            adicionar(aluno);
        }
    }

    public void remover(Aula aula) {
        aulas.remove(aula);
    }

    public void adicionar(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)) {
            return;
        }

        alunos.add(aluno);

        for (Aula aula : aluno.getAulas()) {
            adicionar(aula);
        }
    }

    public void remover(Aluno aluno) {
        alunos.remove(aluno);
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public Aula getAula(int indiceAula) {
        return aulas.get(indiceAula);
    }



    private void popularDados() {
        GabineteProfessor gabineteProfessorA1 = new GabineteProfessor("Gabinete Professor - A.1", false);
        GabineteProfessor gabineteProfessorD1 = new GabineteProfessor("Gabinete Professor - D.1", true);

        GabineteSeguranca gabineteSegurancaA = new GabineteSeguranca("Gabinete Segurança - Edifício A", false);
        GabineteSeguranca gabineteSegurancaD = new GabineteSeguranca("Gabinete Segurança - Edifício D", false);

        Professor professorManuelSilva = new Professor("Manuel Silva", 1, gabineteProfessorA1);
        Professor professorCarlosSantos = new Professor("Carlos Santos", 2, gabineteProfessorA1);
        Professor professorJoseMonteiro = new Professor("José Monteiro", 3, gabineteProfessorD1);

        professorManuelSilva.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 17, 2));
        professorCarlosSantos.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 17, 2));
        professorJoseMonteiro.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 17, 2));

        Seguranca segurancaMiguelMarques = new Seguranca("Miguel Marques", 4, gabineteSegurancaA);
        Seguranca segurancaJoaoSantos = new Seguranca("João Santos", 5, gabineteSegurancaA);
        Seguranca segurancaAntonioSilva = new Seguranca("António Silva", 5, gabineteSegurancaD);

        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.QUINTA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.SEXTA_FEIRA, 8, 8));

        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.QUINTA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.SEXTA_FEIRA, 16, 8));

        segurancaAntonioSilva.adicionar(new Horario(DiaSemana.SABADO, 8, 8));

        Sala salaA1 = new Sala("Sala A1", true);
        Sala salaA2 = new Sala("Sala A2", true);
        Sala salaLAI1 = new Sala("Sala LAI1", false);

        Aula aula1 = new Aula("Programação II TP1", 1, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2), salaA1);
        Aula aula2 = new Aula("Programação II TP2", 2, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2), salaA2);
        Aula aula3 = new Aula("Programação II PL1", 3, new Horario(DiaSemana.SEGUNDA_FEIRA, 10, 3), salaLAI1);

        Aluno aluno1 = new Aluno("José António", 2170001);
        Aluno aluno2 = new Aluno("Miguel Afonso", 2170002);
        Aluno aluno3 = new Aluno("Susana Lopes", 2170003);

        adicionar(professorManuelSilva);
        adicionar(professorCarlosSantos);
        adicionar(professorJoseMonteiro);

        adicionar(aula1);
        adicionar(aula2);
        adicionar(aula3);

        adicionar(segurancaMiguelMarques);
        adicionar(segurancaAntonioSilva);
        adicionar(segurancaJoaoSantos);

        adicionar(aluno1);
        adicionar(aluno2);
        adicionar(aluno3);

        aula1.setProfessor(professorManuelSilva);
        aula2.setProfessor(professorCarlosSantos);
        aula3.setProfessor(professorJoseMonteiro);

        aula1.adicionar(aluno1);
        aula1.adicionar(aluno2);

        aula2.adicionar(aluno3);

        aula3.adicionar(aluno1);
        aula3.adicionar(aluno2);
        aula3.adicionar(aluno3);
    }
}
