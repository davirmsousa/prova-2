package builders;

import produtos.Curso;

public class CursoBuilder extends CursoBaseBuilder<Curso> {

    public static CursoBuilder obter() {
        return new CursoBuilder();
    }

    @Override
    public Curso construir() {
        return new Curso(this.codigo, this.nome, this.disciplinas, this.livros);
    }
    
}
