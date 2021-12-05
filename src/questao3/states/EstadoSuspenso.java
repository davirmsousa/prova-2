package questao3.states;

import questao3.memento.CursoMemento;
import questao3.memento.ICursoMemento;
import questao3.produtos.Curso;

public class EstadoSuspenso extends EstadoDoCursoAbstrato {

    public EstadoSuspenso(Curso curso) {
        super(curso);
    }

    @Override
    public void cancelar() {
        this.curso.setEstado(new EstadoCancelado(this.curso));
    }

    @Override
    public void retomar() {
        this.curso.setEstado(new EstadoEmAndamento(this.curso));
    }

    @Override
    public ICursoMemento gerarMemento() {
        CursoMemento cursoMemento = new CursoMemento(this.curso.getCodigo(), this.curso.getNome(), this.curso.obterLivros(), this.curso.obterDisciplinas());
        this.curso.notificarAlteracaoNoCurso("[CHECKPOINT SALVO]");
        return cursoMemento;
    }

    @Override
    public String toString() {
        return "|Suspenso|";
    }
    
}
