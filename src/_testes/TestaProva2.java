package _testes;

import java.util.Stack;

import questao1.builders.CursoBuilder;
import questao1.fabricas.DisciplinaFactory;
import questao1.produtos.Curso;
import questao1.produtos.Disciplina;
import questao1.produtos.Livro;
import questao1.produtos.Curso.Memento;
import questao1.util.TipoProdutoEnum;

public class TestaProva2 implements ITeste {

    @Override
    public void executar() {
        this.gerarMementoDoCurso();
        System.out.println();
    }

    private void gerarMementoDoCurso() {
        Stack<Memento> historico = new Stack<Memento>();

        Disciplina dFactoryMethod = (Disciplina) DisciplinaFactory
            .obterProduto(TipoProdutoEnum.DISCIPLINA, "DFM001", "Factory Method");
        dFactoryMethod.setChTotal(80);
        
        Disciplina dAbstractFactory = (Disciplina) DisciplinaFactory
            .obterProduto(TipoProdutoEnum.DISCIPLINA, "DAF001", "Abstract Factory");
        dAbstractFactory.setChTotal(60);

        Livro lPadroesProjeto = (Livro)DisciplinaFactory
            .obterProduto(TipoProdutoEnum.LIVRO, "LPP001", "Padrões de Projeto");
        
        Curso curso = CursoBuilder.obter()
            .setNome("PRIMEIRO CURSO")
            .setCodigo("CURSO001")
            .addLivro(lPadroesProjeto)
            .addDisciplina(dFactoryMethod)
            .addDisciplina(dAbstractFactory)
            .construir();
        
        historico.push(curso.gerarMemento());
        System.out.println("=========\n" + curso.gerarRelatorioCompleto());
        
        curso.avancar("DAF001", 25);
        historico.push(curso.gerarMemento());
        System.out.println("=========\n" + curso.gerarRelatorioCompleto());
        
        curso.avancar("DFM001", 40);
        System.out.println("=========\n" + curso.gerarRelatorioCompleto());

        curso.restaurar(historico.pop());
        System.out.println("=========\n" + curso.gerarRelatorioCompleto());
    }
    
}
