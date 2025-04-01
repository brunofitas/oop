package modelo;

public class Horario {
    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;

    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario){
        int horaInicio1 = horaInicio;
        int horaInicio2 = horario.horaInicio;
        int horaFim1 = horaInicio1 + duracao;
        int horaFim2 = horaInicio2 + horario.duracao;

        return diaSemana == horario.diaSemana
                && horaFim2 > horaInicio1 && horaFim1 > horaInicio2;

    }
}
