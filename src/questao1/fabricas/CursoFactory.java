package questao1.fabricas;

import questao1.produtos.Curso;
import questao1.produtos.Produto;

public class CursoFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Curso(codigo, nome);
    }
    
}
