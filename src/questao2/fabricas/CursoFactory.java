package questao2.fabricas;

import questao2.produtos.Curso;
import questao2.produtos.Produto;

public class CursoFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Curso(codigo, nome);
    }
    
}
