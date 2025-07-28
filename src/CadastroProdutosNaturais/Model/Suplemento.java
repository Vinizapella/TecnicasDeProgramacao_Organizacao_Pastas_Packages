package CadastroProdutosNaturais.Model;

public class Suplemento {
    private String nome;
    private double preco;
    private int quantidade;
    private String marca;

    public Suplemento() {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.marca = "";
    }

    public Suplemento(String nome, double preco, int quantidade, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}