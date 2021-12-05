package questao3.states;

import questao3.memento.ICursoMemento;

public interface IEstadoDoCurso {
    // acoes de mudanca de estado
    void retomar();
    void concluir();
    void suspender();
    void cancelar();

    // acoes gerais
    void avancar(String codigoDisciplina, double percentual);
    ICursoMemento gerarMemento();
    void restaurar(ICursoMemento status);
    String gerarCertificado();
}
