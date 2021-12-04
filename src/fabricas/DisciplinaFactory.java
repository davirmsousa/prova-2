package fabricas;

import produtos.Disciplina;
import produtos.Produto;

public class DisciplinaFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Disciplina(codigo, nome);
    }
}
