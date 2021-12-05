package questao3.states;

import java.util.Collection;
import java.util.NoSuchElementException;

import questao3.memento.CursoMemento;
import questao3.memento.ICursoMemento;
import questao3.produtos.Curso;
import questao3.produtos.Disciplina;

public class EstadoEmAndamento extends EstadoDoCursoAbstrato {

    public EstadoEmAndamento(Curso curso) {
        super(curso);
    }

    @Override
    public void avancar(String codigoDisciplina, double percentual) {
        Collection<Disciplina> disciplinas = this.curso.obterDisciplinas();

        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                    disciplina.avancar(percentual);
                    return;
                }
            }
        }

        throw new NoSuchElementException(codigoDisciplina);
    }

    @Override
    public ICursoMemento gerarMemento() {
        CursoMemento cursoMemento = new CursoMemento(this.curso.getCodigo(), this.curso.getNome(), this.curso.obterLivros(), this.curso.obterDisciplinas());
        this.curso.notificarAlteracaoNoCurso("[CHECKPOINT SALVO]");
        return cursoMemento;
    }

    @Override
    public void restaurar(ICursoMemento status) {
        if (!(status instanceof CursoMemento))
            throw new IllegalArgumentException("status não é uma instância de CursoMemento");
        
        CursoMemento statusDoCurso = (CursoMemento) status;

        this.curso.setDisciplinas(statusDoCurso.obterDisciplinas());
        this.curso.setLivros(statusDoCurso.obterLivros());
        this.curso.setCodigo(statusDoCurso.obterCodigo());
        this.curso.setNome(statusDoCurso.obterNome());

        this.curso.notificarAlteracaoNoCurso("[CHECKPOINT RESTAURADO]");
    }

    @Override
    public void suspender() {
        this.curso.setEstado(new EstadoSuspenso(this.curso));
    }

    @Override
    public void concluir() {
        if (this.curso.getPctCumprido() == 100)
            this.curso.setEstado(new EstadoConcluido(this.curso));
    }

    @Override
    public String toString() {
        return "|EmAndamento|";
    }
    
}
