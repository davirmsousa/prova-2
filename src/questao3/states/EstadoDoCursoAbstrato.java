package questao3.states;

import questao3.memento.ICursoMemento;
import questao3.produtos.Curso;

public abstract class EstadoDoCursoAbstrato implements IEstadoDoCurso {

    protected Curso curso;

    public EstadoDoCursoAbstrato(Curso curso) {
        this.setCurso(curso);
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void avancar(String codigoDisciplina, double percentual) {
        return;
    }

    @Override
    public void cancelar() {
        return;
    }

    @Override
    public void concluir() {
        return;
    }

    @Override
    public void retomar() {
        return;
    }

    @Override
    public String gerarCertificado() {
        return null;
    }

    @Override
    public ICursoMemento gerarMemento() {
        return null;
    }

    @Override
    public void restaurar(ICursoMemento status) {
        return;
    }

    @Override
    public void suspender() {
        return;
    }
}
