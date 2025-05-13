package modelo;

import java.util.LinkedList;

public interface Funcionario<T extends Gabinete> {
    public LinkedList<Horario> getHorariosAtendimento();
    public void desassociarGabinete();
    public void adicionar(Horario horario);
    public void remover(Horario horario);
    public void abrirGabinete();
    public void fecharGabinete();
    public void setGabinete(T gabinete);
}
