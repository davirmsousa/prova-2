package questao3.fabricas;

import questao3.produtos.Disciplina;
import questao3.produtos.Produto;

public class DisciplinaFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Disciplina(codigo, nome);
    }
}
