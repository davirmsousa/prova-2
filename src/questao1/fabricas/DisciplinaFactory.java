package questao1.fabricas;

import questao1.produtos.Disciplina;
import questao1.produtos.Produto;

public class DisciplinaFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Disciplina(codigo, nome);
    }
}
