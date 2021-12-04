package questao3.produtos;

import questao3.prototype.IPrototipavel;

public abstract class Produto implements IPrototipavel {
    protected String codigo;
    protected String nome;

    public Produto(Produto produto) {
        this(produto.getCodigo(), produto.getNome());
    }
	
	public Produto(String codigo, String nome) {
        this.setCodigo(codigo);
        this.setNome(nome);
	}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return "[Produto] " + ("COD: " + this.getCodigo()) + ("; NM: " + this.getNome());
    }
}