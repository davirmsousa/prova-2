package questao3.produtos;

import java.util.ArrayList;
import java.util.Collection;

public class Ementa {
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;
    private String codigo;
    private String nome;

    public Ementa(String codigo, String nome, Collection<Livro> livros, Collection<Disciplina> disciplinas) {
        this.disciplinas = new ArrayList<Disciplina>(disciplinas);
        this.livros = new ArrayList<Livro>(livros);
        this.codigo = codigo;
        this.nome = nome;
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[Ementa] " + ("COD: " + this.getCodigo()) + ("; NM: " + this.getNome());
    }
}
