package CadastroLivros.Model;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int quantidade;
    private String editora;

    // Construtor vazio
    public Livro() {
        this.titulo = "";
        this.autor = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.editora = "";
    }

    // Construtor com parâmetros
    public Livro(String titulo, String autor, double preco, int quantidade, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.editora = editora;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}