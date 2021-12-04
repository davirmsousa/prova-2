package questao1.fabricas;

import java.util.HashMap;
import questao1.produtos.Produto;
import questao1.util.TipoProdutoEnum;

public abstract class ProdutoFactory {
    static HashMap<TipoProdutoEnum, ProdutoFactory> mapDeProduto;

    public static Produto obterProduto(TipoProdutoEnum tipo, String codigo, String nome) {
        ProdutoFactory.inicializar();

        if (!ProdutoFactory.mapDeProduto.containsKey(tipo)) {
            throw new IllegalArgumentException("tipo");
        }

        ProdutoFactory fabrica = ProdutoFactory.mapDeProduto.get(tipo);

        return fabrica.criarProduto(codigo, nome);
    }

    private static void inicializar() {
        if (ProdutoFactory.mapDeProduto != null) {
            return;
        }
        
        ProdutoFactory.mapDeProduto = new HashMap<>();
        ProdutoFactory.adicionarFabrica(TipoProdutoEnum.LIVRO, new LivroFactory());
        ProdutoFactory.adicionarFabrica(TipoProdutoEnum.DISCIPLINA, new DisciplinaFactory());
    }

    public static void adicionarFabrica(TipoProdutoEnum tipo, ProdutoFactory fabrica) {
        ProdutoFactory.mapDeProduto.put(tipo, fabrica);
    }

    protected abstract Produto criarProduto(String codigo, String nome);
}
