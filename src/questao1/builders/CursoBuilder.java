package questao1.builders;

import questao1.produtos.Curso;

public class CursoBuilder extends CursoBaseBuilder<Curso> {

    private CursoBuilder() {
        super();
    }

    public static CursoBuilder obter() {
        return new CursoBuilder();
    }

    @Override
    public Curso construir() {
        return new Curso(this.codigo, this.nome, this.disciplinas, this.livros);
    }
    
}
