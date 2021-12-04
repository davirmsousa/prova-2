package questao3.observer;

import java.util.HashMap;

public interface IObservadorDeCurso {
    void notificarAlteracaoNoCurso(String evento, HashMap<String, Double> percentualPorDisciplina);
}
