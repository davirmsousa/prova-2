package questao2.produtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import questao2.prototype.IPrototipavel;

public class Curso extends Produto {

    public class Memento {
        private Collection<Disciplina> disciplinas;
        private Collection<Livro> livros;
        private String codigo;
        private String nome;

        private Curso curso;

        private Memento(Curso curso, String codigo, String nome, Collection<Livro> livros, Collection<Disciplina> disciplinas) {
            this.curso = curso;

            this.disciplinas = (new ArrayList<Disciplina>(disciplinas)).stream()
                .map(d -> d.clonar())
                .collect(Collectors.toList());
            
            this.livros = (new ArrayList<Livro>(livros)).stream()
                .map(l -> l.clonar())
                .collect(Collectors.toList());
            
            this.codigo = codigo;
            this.nome = nome;
        }

        private void restaurar() {
            this.curso.disciplinas = this.disciplinas;
            this.curso.livros = this.livros;
            this.curso.codigo = this.codigo;
            this.curso.nome = this.nome;
        }
    }

    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;

    public Curso(String codigo, String nome, Collection<Disciplina> disciplinas, Collection<Livro> livros) {
        super(codigo, nome);
        this.livros = new ArrayList<Livro>(livros);
        this.disciplinas = new ArrayList<Disciplina>(disciplinas);
    }

    public Curso(String codigo, String nome) {
        super(codigo, nome);
    }

    public Curso(Curso produto) {
        super(produto);
        this.livros = new ArrayList<Livro>();
        this.disciplinas = new ArrayList<Disciplina>();

        for (Disciplina disciplina : produto.disciplinas) {
            this.addDisciplina(disciplina.clonar());
        }

        for (Livro livro : produto.livros) {
            this.addLivro(livro.clonar());
        }
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public double getPreco() {
        double precoDoCurso = 0;
        
        if (livros != null && livros.size() > 0) {
            for (Livro livro : livros) {
                precoDoCurso += livro.getPreco();
            }
        }
        
        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                precoDoCurso += disciplina.getPreco();
            }
        }

        return precoDoCurso * 1.1;
    }

    public int getChTotal() {
        int chTotal = 0;

        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                chTotal += disciplina.getChTotal();
            }
        }

        return chTotal;
    }

    public double getPctCumprido() {
        int chTotal = this.getChTotal();
        double horasCumpridas = 0;

        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                horasCumpridas += (disciplina.getPctCumprido() * disciplina.getChTotal()) / 100;
            }
        } 

        return horasCumpridas / chTotal * 100;
    }

    public void avancar(String codigoDisciplina, double percentual) {
        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                    disciplina.avancar(percentual);
                    return;
                }
            }
        }

        throw new NoSuchElementException(codigoDisciplina);
    }
    
    @Override
    public IPrototipavel clonar() {
        return new Curso(this);
    }

    @Override
    public String toString() {
        return "[Curso] [" + super.toString() + "]";
    }

    public Memento gerarMemento() {
        return new Memento(this, this.codigo, this.nome, this.livros, this.disciplinas);
    }

    public void restaurar(Memento status) {
        status.restaurar();
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
            relatorio.append(disciplina.getCodigo() + "\n\tCHTOTAL: " +
                disciplina.getChTotal() + "\n\tPROGRESSO: " +
                disciplina.getPctCumprido() + "\n");
        }

        return relatorio.toString();
    }

}
