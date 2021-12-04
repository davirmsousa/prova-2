package _testes;

import builders.ADSDiretor;
import builders.CursoBuilder;
import builders.EmentaBuilder;
import fabricas.DisciplinaFactory;
import fabricas.ProdutoFactory;
import produtos.Curso;
import produtos.Disciplina;
import produtos.Ementa;
import produtos.Livro;
import produtos.Produto;
import prototype.RegistroDeCursos;
import util.TipoProdutoEnum;

public class TestaProva1 implements ITeste {

    public void executar() {
        this.factoryDeProduto();
        System.out.println();

        this.builders();
        System.out.println();

        this.prototypeDeCurso();
        System.out.println();
    }

    private void factoryDeProduto() {
        Produto produto = ProdutoFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "DIS001", "DIS001");
        System.out.println(produto);

        produto = ProdutoFactory.obterProduto(TipoProdutoEnum.LIVRO, "LIVRO001", "LIVRO001");
        System.out.println(produto);
    }

    private void builders() {
        Curso curso = CursoBuilder.obter().resetar()
            .setCodigo("CRUSO001")
            .setNome("padroes criacionais")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Factory Method"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Abstract Factory"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Padrões de Projeto"))
            .construir();

        System.out.println(curso);

        Ementa ementa = EmentaBuilder.obter().resetar()
            .setCodigo("EMT001")
            .setNome("Ementa de ADS")
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D001", "Disciplina da Ementa 1"))
            .addDisciplina((Disciplina)DisciplinaFactory.obterProduto(TipoProdutoEnum.DISCIPLINA, "D002", "Disciplina da Ementa 2"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 1"))
            .addLivro((Livro)DisciplinaFactory.obterProduto(TipoProdutoEnum.LIVRO, "L001", "Livro da Ementa 2"))
            .construir();
            
        System.out.println(ementa);
    }

    private void prototypeDeCurso() {
        CursoBuilder cursoBuilder = CursoBuilder.obter();
        new ADSDiretor().construir(cursoBuilder);
        Curso curso = cursoBuilder.construir();

        RegistroDeCursos registro = RegistroDeCursos.instanciar();
        registro.registrar(curso);

        Curso curso2 = registro.obterPorNome(curso.getNome());
        curso2.atualizarProgresso("INF001", 50);

        System.out.println(this.relatorioDoCurso(curso));
        System.out.println(this.relatorioDoCurso(curso2));
    }

    private String relatorioDoCurso(Curso curso) {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append(curso + "\n");
        relatorio.append("CHTOTAL: " + curso.getChTotal() + "\n");
        relatorio.append("PROGRESSO: " + curso.getPctCumprido() + "\n");

        return relatorio.toString();
    }
}
