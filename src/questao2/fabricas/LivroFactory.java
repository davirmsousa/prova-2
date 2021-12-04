package questao2.fabricas;

import questao2.produtos.Livro;
import questao2.produtos.Produto;

public class LivroFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Livro(codigo, nome);
    }
}
