package questao3.produtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import questao3.memento.ICursoMemento;
import questao3.observer.IObservadorDeCurso;
import questao3.prototype.IPrototipavel;
import questao3.states.EstadoDoCursoAbstrato;
import questao3.states.EstadoEmAndamento;

public class Curso extends Produto {

    private Collection<IObservadorDeCurso> observadores;
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;
    
    private EstadoDoCursoAbstrato estado;

    public Curso(String codigo, String nome, Collection<Disciplina> disciplinas, Collection<Livro> livros) {
        super(codigo, nome);
        this.estado = new EstadoEmAndamento(this);
        this.livros = new ArrayList<Livro>(livros);
        this.disciplinas = new ArrayList<Disciplina>(disciplinas);
        this.observadores = new ArrayList<IObservadorDeCurso>();
    }

    public Curso(String codigo, String nome) {
        this(codigo, nome, null, null);
    }

    public Curso(Curso produto) {
        super(produto);
        this.livros = new ArrayList<Livro>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.observadores = new ArrayList<IObservadorDeCurso>();
        
        for (Disciplina disciplina : produto.disciplinas) {
            this.addDisciplina(disciplina.clonar());
        }

        for (Livro livro : produto.livros) {
            this.addLivro(livro.clonar());
        }
    }

    public void setDisciplinas(Collection<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public Collection<Disciplina> obterDisciplinas() {
        return this.disciplinas;
    }

    public void setLivros(Collection<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public Collection<Livro> obterLivros() {
        return this.livros;
    }

    @Override
    public double getPreco() {
        double precoDoCurso = 0;
        
        if (this.livros != null && this.livros.size() > 0) {
            for (Livro livro : this.livros) {
                precoDoCurso += livro.getPreco();
            }
        }
        
        if (this.disciplinas != null && this.disciplinas.size() > 0) {
            for (Disciplina disciplina : this.disciplinas) {
                precoDoCurso += disciplina.getPreco();
            }
        }

        return precoDoCurso * 1.1;
    }

    public int getChTotal() {
        int chTotal = 0;

        if (this.disciplinas != null && this.disciplinas.size() > 0) {
            for (Disciplina disciplina : this.disciplinas) {
                chTotal += disciplina.getChTotal();
            }
        }

        return chTotal;
    }

    public double getPctCumprido() {
        int chTotal = this.getChTotal();
        double horasCumpridas = 0;

        if (this.disciplinas != null && this.disciplinas.size() > 0) {
            for (Disciplina disciplina : this.disciplinas) {
                horasCumpridas += (disciplina.getPctCumprido() * disciplina.getChTotal()) / 100;
            }
        } 

        return horasCumpridas / chTotal * 100;
    }

    public void avancar(String codigoDisciplina, double percentual) {
        estado.avancar(codigoDisciplina, percentual);
    }
    
    @Override
    public IPrototipavel clonar() {
        return new Curso(this);
    }

    public ICursoMemento gerarMemento() {
        return this.estado.gerarMemento();
    }

    public void restaurar(ICursoMemento status) {
        this.estado.restaurar(status);
    }

    public void inscreverObservador(IObservadorDeCurso observador) {
        this.observadores.add(observador);
    }

    public void desinscreverObservador(IObservadorDeCurso observador) {
        this.observadores.remove(observador);
    }

    public void notificarAlteracaoNoCurso(String evento) {
        HashMap<String, Double> percentualPorDisciplina = new HashMap<String, Double>();

        for (Disciplina disciplina : this.disciplinas) {
            percentualPorDisciplina.put(disciplina.getCodigo(), disciplina.getPctCumprido());
        }

        for (IObservadorDeCurso observador : this.observadores) {
            observador.notificarAlteracaoNoCurso(evento, percentualPorDisciplina);
        }
    }

    public void setEstado(EstadoDoCursoAbstrato estado) {
        this.estado = estado;
    }

    public EstadoDoCursoAbstrato obterEstado() {
        return this.estado;
    }

    public void retomar() {
        this.estado.retomar();
    }

    public void suspender() {
        this.estado.suspender();
    }

    public void cancelar() {
        this.estado.cancelar();
    }

    public void concluir() {
        this.estado.concluir();
    }

    public String gerarCertificado() {
        return this.estado.gerarCertificado();
    }

    public String gerarRelatorioSimplificado() {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append(this + "\n");
        relatorio.append("CHTOTAL: " + this.getChTotal() + "\n");
        relatorio.append("PROGRESSO: " + this.getPctCumprido() + "\n");

        return relatorio.toString();
    }

    public String gerarRelatorioCompleto() {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append(this + "\n");

        for (Disciplina disciplina : this.disciplinas) {
            relatorio.append(disciplina.getCodigo() + "\tCHTOTAL: " +
                disciplina.getChTotal() + "\tPROGRESSO: " +
                disciplina.getPctCumprido() + "\n");
        }

        return relatorio.toString();
    }

    @Override
    public String toString() {
        return "[Curso " + this.estado + "] [" + super.toString() + "]";
    }

}
