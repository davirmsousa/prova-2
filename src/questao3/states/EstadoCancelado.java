package questao3.states;

import questao3.produtos.Curso;

public class EstadoCancelado extends EstadoDoCursoAbstrato {

    public EstadoCancelado(Curso curso) {
        super(curso);
    }

    @Override
    public String toString() {
        return "|Cancelado|";
    }
    
}
