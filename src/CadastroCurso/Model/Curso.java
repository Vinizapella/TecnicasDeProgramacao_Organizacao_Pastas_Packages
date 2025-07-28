package CadastroCurso.Model;

public class Curso {
    private String nome;
    private int duracaoHoras;
    private String nivel;
    private int vagas;

    public Curso() {
        this.nome = "";
        this.duracaoHoras = 0;
        this.nivel = "";
        this.vagas = 0;
    }

    public Curso(String nome, int duracaoHoras, String nivel, int vagas) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.nivel = nivel;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Nome: " + nome + "\n" +
                "Duração: " + duracaoHoras + " horas\n" +
                "Nível: " + nivel + "\n" +
                "Vagas: " + vagas + "\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    }
}
