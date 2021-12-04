package questao3.observer;

import java.util.HashMap;
import java.util.Map.Entry;

public class SMSNotificador implements IObservadorDeCurso {

    @Override
    public void notificarAlteracaoNoCurso(String evento, HashMap<String, Double> percentualPorDisciplina) {
        System.out.print("[NOTIFICACAO SMS DO EVENTO " + evento +" ]");

        StringBuilder resultado = new StringBuilder();
        for (Entry<String, Double> disciplina : percentualPorDisciplina.entrySet()) {
            resultado.append("\n" + disciplina.getKey() + "    PROGRESSO: " + disciplina.getValue());
        }
        System.out.println(resultado);
    }
}
