package modelo;

import java.util.LinkedList;

public class Aula {
    private String nome;
    private long numero;
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    public Aula(String nome, long numero, Horario horario) {
        this(nome, numero, horario, null, new LinkedList<>());
    }

    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos) {
        this.nome = nome;
        this.numero = numero;
        sumario = new StringBuilder();
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos){
            adicionar(aluno);
        }
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null || this.professor == professor) {
            return;
        }
        if (this.professor != null) {
            this.professor.remover(this);
        }
        this.professor = professor;
        professor.adicionar(this);
    }

    public String getSumario() {
        return sumario.toString();
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }


    public Horario getHorario() {
        return horario;
    }

    public void adicionar(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)){
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno) {
        if (!alunos.contains(aluno)){
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);
    }

    public void desassociarProfessor() {
        if (professor == null) {
            return;
        }
        Professor professorARemover = professor;
        professor = null;
        professorARemover.remover(this);
    }


    public void adicionarLinhaSumario(String linha) {
        sumario.append(linha).append("\n");
    }
}
