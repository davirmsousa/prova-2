package questao1.builders;

import questao1.produtos.Ementa;

public class EmentaBuilder extends CursoBaseBuilder<Ementa> {

    private EmentaBuilder() {
        super();
    }

    public static EmentaBuilder obter() {
        return new EmentaBuilder();
    }

    @Override
    public Ementa construir() {
        return new Ementa(this.codigo, this.nome, this.livros, this.disciplinas);
    }
    
}
