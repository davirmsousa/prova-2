package _testes;

import java.util.Stack;

import questao3.builders.CursoBuilder;
import questao3.fabricas.DisciplinaFactory;
import questao3.observer.EmailNotificador;
import questao3.observer.SMSNotificador;
import questao3.produtos.Curso;
import questao3.produtos.Disciplina;
import questao3.produtos.Livro;
import questao3.produtos.Curso.Memento;
import questao3.util.TipoProdutoEnum;

public class TestaProva2 implements ITeste {

    @Override
    public void executar() {
        this.testaGerarMementoDoCurso();
        System.out.println("_________________________________");
        
        this.testaNotificarAlteracoesNoCurso();
        System.out.println("_________________________________");
    }

    private void testaGerarMementoDoCurso() {
        Stack<Memento> historico = new Stack<Memento>();

        Curso curso = this.construirCurso();
        
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

    private void testaNotificarAlteracoesNoCurso() {
        Stack<Memento> historico = new Stack<Memento>();

        Curso curso = this.construirCurso();

        historico.push(curso.gerarMemento());

        curso.inscreverObservador(new EmailNotificador());

        curso.avancar("DAF001", 25);
        historico.push(curso.gerarMemento());
        
        curso.avancar("DFM001", 40);
        historico.push(curso.gerarMemento());

        curso.inscreverObservador(new SMSNotificador());
        curso.restaurar(historico.pop());
    }

    private Curso construirCurso() {
        Disciplina dFactoryMethod = (Disciplina) DisciplinaFactory
            .obterProduto(TipoProdutoEnum.DISCIPLINA, "DFM001", "Factory Method");
        dFactoryMethod.setChTotal(80);
        
        Disciplina dAbstractFactory = (Disciplina) DisciplinaFactory
            .obterProduto(TipoProdutoEnum.DISCIPLINA, "DAF001", "Abstract Factory");
        dAbstractFactory.setChTotal(60);

        Livro lPadroesProjeto = (Livro)DisciplinaFactory
            .obterProduto(TipoProdutoEnum.LIVRO, "LPP001", "Padrões de Projeto");
        
        return CursoBuilder.obter()
            .setNome("PRIMEIRO CURSO")
            .setCodigo("CURSO001")
            .addLivro(lPadroesProjeto)
            .addDisciplina(dFactoryMethod)
            .addDisciplina(dAbstractFactory)
            .construir();
    }
    
}
