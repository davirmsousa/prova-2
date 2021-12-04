package questao1.produtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import questao1.prototype.IPrototipavel;

public class Curso extends Produto {
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

    public void atualizarProgresso(String codigoDisciplina, double pctCumprido) {
        if (disciplinas != null && disciplinas.size() > 0) {
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
                    disciplina.setPctCumprido(pctCumprido);
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

}
