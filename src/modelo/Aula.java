package modelo;

import java.util.LinkedList;

public class Aula extends Identificador{

    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;

    public Aula(String nome, long numero, Horario horario, Sala sala) {

        this(nome, numero, horario, sala, null, new LinkedList<>());
    }

    public Aula(
            String nome,
            long numero,
            Horario horario,
            Sala sala,
            Professor professor,
            LinkedList<Aluno> alunos
    ) {
        super(nome, numero);
        sumario = new StringBuilder();
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos){
            adicionar(aluno);
        }
        this.horario = horario;
        this.sala = sala;
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

    public Sala getSala(){ return this.sala; }

    public void setSala(Sala sala){
        if(sala ==  null || this.sala == sala){
            return;
        }
        if(this.sala != null){
            this.sala.remover(this);
        }
        this.sala = sala;
        sala.adicionar(this);
    }

    public void desassociarSala(){
        if(this.sala == null){
            return;
        }
        this.sala.remover(this);
        this.sala = null;
    }


}
