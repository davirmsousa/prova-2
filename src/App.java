import _testes.ITeste;
import _testes.TestaProva1;

public class App {

    public void executar() {
        ITeste teste;

        teste = new TestaProva1();

        teste.executar();
    }

    public static void main(String[] args) throws Exception {
        new App().executar();
    }
}
