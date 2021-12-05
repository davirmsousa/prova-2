package _testes;

import java.util.Stack;

import questao3.builders.CursoBuilder;
import questao3.fabricas.DisciplinaFactory;
import questao3.memento.ICursoMemento;
import questao3.observer.EmailNotificador;
import questao3.observer.SMSNotificador;
import questao3.produtos.Curso;
import questao3.produtos.Disciplina;
import questao3.produtos.Livro;
import questao3.util.TipoProdutoEnum;

public class TestaProva2 implements ITeste {

    @Override
    public void executar() {
        this.testaGerarMementoDoCurso();
        System.out.println("__________________________________________________________________");
        
        this.testaNotificarAlteracoesNoCurso();
        System.out.println("__________________________________________________________________");
        
        this.testaAlteracaoDeStatus();
        System.out.println("__________________________________________________________________");
    }

    private void testaGerarMementoDoCurso() {
        Stack<ICursoMemento> historico = new Stack<ICursoMemento>();

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
        Stack<ICursoMemento> historico = new Stack<ICursoMemento>();

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

    private void testaAlteracaoDeStatus() {
        System.out.println("testaEstadoEmAndamento~~~~~~~~~~~~~~~~~~");
        this.testaEstadoEmAndamento();

        System.out.println("testaEstadoCancelado~~~~~~~~~~~~~~~~~~");
        this.testaEstadoCancelado();

        System.out.println("testaEstadoConcluido~~~~~~~~~~~~~~~~~~");
        this.testaEstadoConcluido();

        System.out.println("testaEstadoSuspenso~~~~~~~~~~~~~~~~~~");
        this.testaEstadoSuspenso();
    }

    private void testaEstadoEmAndamento() {
        Stack<ICursoMemento> historico = new Stack<ICursoMemento>();

        Curso curso = this.construirCurso();
        System.out.println("- -- - -- - -- - --\n" + curso.gerarRelatorioCompleto());

        ICursoMemento memento = curso.gerarMemento();
        System.out.println("- -- - -- - -- - --\n" + memento);
        historico.push(memento);

        curso.avancar("DAF001", 25);
        System.out.println("- -- - -- - -- - --\n" + curso.gerarRelatorioCompleto());

        curso.restaurar(historico.pop());
        System.out.println("- -- - -- - -- - --\n" + curso.gerarRelatorioCompleto());

        System.out.println("- -- - -- - -- - --CERTIFICADO\n" + curso.gerarCertificado() + "\n");

        curso.concluir();
        System.out.println(curso);

        curso.avancar("DFM001", 100);
        curso.avancar("DAF001", 100);
        curso.concluir();
        System.out.println(curso);

        curso = this.construirCurso();
        curso.cancelar();
        System.out.println(curso);

        curso = this.construirCurso();
        curso.suspender();
        System.out.println(curso.toString() + curso.obterEstado());
    }

    private void testaEstadoConcluido() {

    }

    private void testaEstadoSuspenso() {

    }

    private void testaEstadoCancelado() {

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
