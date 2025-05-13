package modelo;

import java.util.LinkedList;

public interface RepositorioAulas {
    void adicionar(Aula aula);
    void remover(Aula aula);
    LinkedList<Aula> getAulas();
    LinkedList<Aula> getAulas(Horario horaio);
    void associar(Aula aula);
    void desassociar(Aula aula);
    boolean contem(Aula aula);

}
