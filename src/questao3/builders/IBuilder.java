package questao3.builders;

import questao3.produtos.Disciplina;
import questao3.produtos.Livro;

public interface IBuilder<T> {
    IBuilder<T> resetar();
    IBuilder<T> setNome(String nome);
    IBuilder<T> setCodigo(String codigo);
    IBuilder<T> addDisciplina(Disciplina disciplina);
    IBuilder<T> addLivro(Livro livro);
    T construir();
}