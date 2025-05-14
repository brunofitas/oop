package modelo;

import java.util.LinkedList;

public class GestorFuncionario {
    private LinkedList<Horario> horariosAtendimento;

    public GestorFuncionario() {
        this.horariosAtendimento = new LinkedList<>();
    }

    public void adicionar(Horario horario){
        if(this.horariosAtendimento.contains(horario)){
            return;
        }
        this.horariosAtendimento.add(horario);
    }

    public void remover(Horario horario){
        this.horariosAtendimento.remove(horario);
    }

    public LinkedList<Horario> getHorariosAtendimento(){
        return new LinkedList<>(this.horariosAtendimento);
    }
}
