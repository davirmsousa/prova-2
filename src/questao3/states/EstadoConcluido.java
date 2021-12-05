package questao3.states;

import questao3.produtos.Curso;
import questao3.produtos.Disciplina;

public class EstadoConcluido extends EstadoDoCursoAbstrato {

    public EstadoConcluido(Curso curso) {
        super(curso);
    }

    @Override
    public String gerarCertificado() {
        StringBuilder certificado = new StringBuilder();
        certificado.append("Atestamos para os devidos fins que alguém concluiu o curso " + this.curso.getNome() +
            " [" + this.curso.getChTotal() + " horas].");
        
        certificado.append("\nDisciplinas:");

        for (Disciplina disciplina : this.curso.obterDisciplinas()) {
            certificado.append("\n" + disciplina.getNome() + "    CH: " + disciplina.getChTotal());
        }

        return certificado.toString();
    }

    @Override
    public String toString() {
        return "|Concluido|";
    }
    
}
