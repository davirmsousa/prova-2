package questao2.fabricas;

import questao2.produtos.Disciplina;
import questao2.produtos.Produto;

public class DisciplinaFactory extends ProdutoFactory {

    @Override
    protected Produto criarProduto(String codigo, String nome) {
        return new Disciplina(codigo, nome);
    }
}
