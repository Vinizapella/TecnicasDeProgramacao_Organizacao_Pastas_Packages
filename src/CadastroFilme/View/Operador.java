package CadastroFilme.View;

import CadastroFilme.Model.Filme;
import java.util.Scanner;

public class Operador {
    private Scanner input;

    public Operador() {
        input = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println("\n=== CINEAPP - Sistema de Catálogo de Filmes ===");
        System.out.println("1 - Cadastrar filme");
        System.out.println("2 - Listar todos os filmes");
        System.out.println("3 - Remover filme pelo título");
        System.out.println("4 - Buscar filme pelo título");
        System.out.println("5 - Editar dados de um filme");
        System.out.println("6 - Mostrar total de filmes cadastrados");
        System.out.println("7 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

    public String lerTitulo() {
        System.out.print("Digite o título do filme: ");
        return input.nextLine();
    }

    public String lerGenero() {
        System.out.print("Digite o gênero do filme: ");
        return input.nextLine();
    }

    public int lerDuracao() {
        System.out.print("Digite a duração do filme (em minutos): ");
        return input.nextInt();
    }

    public int lerAnoLancamento() {
        System.out.print("Digite o ano de lançamento: ");
        return input.nextInt();
    }

    public String lerTituloBusca() {
        System.out.print("Digite o título do filme para buscar: ");
        return input.nextLine();
    }

    public String lerTituloRemover() {
        System.out.print("Digite o título do filme para remover: ");
        return input.nextLine();
    }

    public String lerTituloEditar() {
        System.out.print("Digite o título do filme para editar: ");
        return input.nextLine();
    }

    public void exibirFilme(Filme filme) {
        System.out.println(filme.toString());
    }

    public void exibirMensagemSucesso(String acao) {
        System.out.println(" " + acao + " realizada com sucesso!");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println(" " + mensagem);
    }

    public void exibirTotalFilmes(int total) {
        System.out.println(" Total de filmes cadastrados: " + total);
    }

    public void finalizarSistema() {
        System.out.println(" Sistema encerrado. Obrigado por usar o CineApp!");
        input.close();
    }

    public int menuEdicao() {
        System.out.println("\n--- O que deseja editar? ---");
        System.out.println("1 - Título");
        System.out.println("2 - Gênero");
        System.out.println("3 - Duração");
        System.out.println("4 - Ano de Lançamento");
        System.out.println("0 - Cancelar edição");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }
}