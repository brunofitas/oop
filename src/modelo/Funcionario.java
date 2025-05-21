package modelo;

import java.util.LinkedList;

public interface Funcionario<T extends Gabinete, TDivisao extends Divisao> {
    void abrirGabinete();
    void fecharGabinete();
    void desassociarGabinete();
    void setGabinete(T gabinete);
    T getGabinete();
    LinkedList<Horario> getHorariosAtendimento();
    void adicionar(Horario horario);
    void remover(Horario horario);
    void abrir(TDivisao divisao);
    void fechar(TDivisao divisao);
}
