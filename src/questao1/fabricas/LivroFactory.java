package questao1.fabricas;

import questao1.produtos.Livro;
import questao1.produtos.Produto;

public class LivroFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Livro(codigo, nome);
    }
}
