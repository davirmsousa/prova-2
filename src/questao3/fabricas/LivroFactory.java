package questao3.fabricas;

import questao3.produtos.Livro;
import questao3.produtos.Produto;

public class LivroFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Livro(codigo, nome);
    }
}
