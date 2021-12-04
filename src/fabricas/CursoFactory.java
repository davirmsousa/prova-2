package fabricas;

import produtos.Curso;
import produtos.Produto;

public class CursoFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Curso(codigo, nome);
    }
    
}
