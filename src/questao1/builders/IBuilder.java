package questao1.builders;

import questao1.produtos.Disciplina;
import questao1.produtos.Livro;

public interface IBuilder<T> {
    IBuilder<T> resetar();
    IBuilder<T> setNome(String nome);
    IBuilder<T> setCodigo(String codigo);
    IBuilder<T> addDisciplina(Disciplina disciplina);
    IBuilder<T> addLivro(Livro livro);
    T construir();
}