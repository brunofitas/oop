package modelo;

import java.util.LinkedList;

public interface Funcionario<TGabinete extends Gabinete, TDivisao extends Divisao> {
    void abrirGabinete();
    void fecharGabinete();
    void desassociarGabinete();
    void setGabinete(TGabinete gabinete);
    TGabinete getGabinete();
    LinkedList<Horario> getHorariosAtendimento();
    void adicionar(Horario horario);
    void remover(Horario horario);
    void abrir(TDivisao divisao);
    void fechar(TDivisao divisao);
}
