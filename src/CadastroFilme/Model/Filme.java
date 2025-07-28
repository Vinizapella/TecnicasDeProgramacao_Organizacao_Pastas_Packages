package CadastroFilme.Model;

public class Filme {
    private String titulo;
    private String genero;
    private int duracao;
    private int anoLancamento;

    public Filme() {
        this.titulo = "";
        this.genero = "";
        this.duracao = 0;
        this.anoLancamento = 0;
    }

    public Filme(String titulo, String genero, int duracao, int anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Título: " + titulo + "\n" +
                "Gênero: " + genero + "\n" +
                "Duração: " + duracao + " minutos\n" +
                "Ano de Lançamento: " + anoLancamento + "\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    }
}