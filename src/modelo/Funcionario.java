package modelo;

import java.util.LinkedList;

public interface Funcionario {
    public LinkedList<Horario> getHorariosatendimento();
    public void desassociarGabinete();
    public void adicionar(Horario horario);
    public void remover(Horario horario);
    public void abrirGabinete();
    public void fecharGabinete();
}
