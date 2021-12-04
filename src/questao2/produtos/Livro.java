package questao2.produtos;

public class Livro extends Produto {
    private double preco;
    private String isbn;

    public Livro(String codigo, String nome, double preco, String isbn) {
        this(codigo, nome);
        this.setIsbn(isbn);
        this.setPreco(preco);
    }

    public Livro(String codigo, String nome) {
        super(codigo, nome);
    }

    public Livro(Livro produto) {
        super(produto);
        this.setIsbn(produto.getIsbn());
        this.setPreco(produto.getPreco());
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public Livro clonar() {
        return new Livro(this);
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "[Livro] [" + super.toString() + "]";
    }
    
}
