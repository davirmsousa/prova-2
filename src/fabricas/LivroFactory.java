package fabricas;

import produtos.Livro;
import produtos.Produto;

public class LivroFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Livro(codigo, nome);
    }
}
