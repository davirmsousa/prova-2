package questao3.memento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import questao3.produtos.Disciplina;
import questao3.produtos.Livro;

public class CursoMemento implements ICursoMemento {
    private Collection<Disciplina> disciplinas;
    private Collection<Livro> livros;
    private String codigo;
    private String nome;

    public CursoMemento(String codigo, String nome, Collection<Livro> livros, Collection<Disciplina> disciplinas) {
        this.disciplinas = (new ArrayList<Disciplina>(disciplinas)).stream()
            .map(d -> d.clonar())
            .collect(Collectors.toList());
        
        this.livros = (new ArrayList<Livro>(livros)).stream()
            .map(l -> l.clonar())
            .collect(Collectors.toList());
        
        this.codigo = codigo;
        this.nome = nome;
    }

    public String obterCodigo() {
        return codigo;
    }

    public Collection<Disciplina> obterDisciplinas() {
        return disciplinas;
    }

    public Collection<Livro> obterLivros() {
        return livros;
    }

    public String obterNome() {
        return nome;
    }
}
