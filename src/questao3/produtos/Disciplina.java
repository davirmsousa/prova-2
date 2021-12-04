package questao3.produtos;

public class Disciplina extends Produto {
    private double pctCumprido;
	private double preco;
    private int chTotal;

    public Disciplina(String codigo, String nome, double pctCumprido, double preco, int chTotal) {
        super(codigo, nome);
        this.setPreco(preco);
        this.setChTotal(chTotal);
        this.setPctCumprido(pctCumprido);
    }

    public Disciplina(String codigo, String nome) {
        super(codigo, nome);
    }

    public Disciplina(Disciplina produto) {
        super(produto);
        this.setPreco(produto.getPreco());
        this.setChTotal(produto.getChTotal());
        this.setPctCumprido(produto.getPctCumprido());
    }

    public double getPctCumprido() {
        return this.pctCumprido;
    }

    private void setPctCumprido(double pctCumprido) {
        this.pctCumprido = pctCumprido;
    }

    public void avancar(double percentual) {
        double pctResultante = this.pctCumprido + percentual;
        this.setPctCumprido(pctResultante <= 100 ? pctResultante : 100);
    }

    public int getChTotal() {
        return this.chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    @Override
    public Disciplina clonar() {
        return new Disciplina(this);
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "[Disciplina] [" + super.toString() + "]";
    }
    
}
