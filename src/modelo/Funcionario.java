package modelo;

import java.util.LinkedList;

public interface Funcionario<T extends Gabinete> {
    void abrirGabinete();
    void fecharGabinete();
    void desassociarGabinete();
    void setGabinete(T gabinete);
    LinkedList<Horario> getHorariosAtendimento();
    void adicionar(Horario horario);
    void remover(Horario horario);
}
