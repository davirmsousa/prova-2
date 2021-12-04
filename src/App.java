import _testes.*;

public class App {

    public void executar() {
        ITeste teste;

        //teste = new TestaProva1();
        teste = new TestaProva2();

        teste.executar();
    }

    public static void main(String[] args) throws Exception {
        new App().executar();
    }
}
