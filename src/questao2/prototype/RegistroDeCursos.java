package questao2.prototype;

import java.util.HashMap;
import java.util.Map;
import questao2.produtos.Curso;

public class RegistroDeCursos {
    private static RegistroDeCursos instancia;
    private Map<String, Curso> cursos;

    private RegistroDeCursos() {
        this.cursos = new HashMap<String, Curso>();
    }

    public static RegistroDeCursos instanciar() {
        if (RegistroDeCursos.instancia == null) {
            RegistroDeCursos.instancia = new RegistroDeCursos();
        }

        return RegistroDeCursos.instancia;
    }

    public void registrar(Curso curso) {
        this.cursos.put(curso.getNome(), curso);
    }

    public Curso obterPorNome(String nome) {
		Curso curso = this.cursos.get(nome);
		return (Curso) ((curso != null) ? curso.clonar() : null);
    }
}
