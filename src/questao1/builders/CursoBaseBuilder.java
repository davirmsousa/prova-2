package questao1.builders;

import java.util.ArrayList;
import java.util.Collection;
import questao1.produtos.Disciplina;
import questao1.produtos.Livro;

public abstract class CursoBaseBuilder<T> implements IBuilder<T> {
	protected Collection<Disciplina> disciplinas;
	protected Collection<Livro> livros;	
    protected String codigo;
	protected String nome;

	public CursoBaseBuilder() {
		this.resetar();
	}

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
