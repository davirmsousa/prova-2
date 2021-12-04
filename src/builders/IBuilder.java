package builders;

import produtos.Disciplina;
import produtos.Livro;

public interface IBuilder<T> {
    IBuilder<T> resetar();
    IBuilder<T> setNome(String nome);
    IBuilder<T> setCodigo(String codigo);
    IBuilder<T> addDisciplina(Disciplina disciplina);
    IBuilder<T> addLivro(Livro livro);
    T construir();
}