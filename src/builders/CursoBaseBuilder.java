package builders;

import java.util.ArrayList;
import java.util.Collection;
import produtos.Disciplina;
import produtos.Livro;

public abstract class CursoBaseBuilder<T> implements IBuilder<T> {
	protected Collection<Disciplina> disciplinas;
	protected Collection<Livro> livros;	
    protected String codigo;
	protected String nome;

	@Override
	public IBuilder<T> resetar() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.livros = new ArrayList<Livro>();	
		this.codigo = "";
		this.nome = "";
		return this;
	}

	@Override
	public IBuilder<T> setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public IBuilder<T> setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	@Override
	public IBuilder<T> addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		return this;
	}
	
	@Override
	public IBuilder<T> addLivro(Livro livro) {
		this.livros.add(livro);
		return this;
	}
}
