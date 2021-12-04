package questao3.fabricas;

import questao3.produtos.Curso;
import questao3.produtos.Produto;

public class CursoFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Curso(codigo, nome);
    }
    
}
