package CadastroLivros.View;

import CadastroLivros.Model.Livro;
import java.util.Scanner;

public class Atendente {
    private Scanner input;

    public Atendente() {
        input = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println("\n=== BIBLIOTECH - Sistema de Livros ===");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar todos os livros");
        System.out.println("3 - Remover livro por título");
        System.out.println("4 - Buscar livro por título");
        System.out.println("5 - Editar dados de um livro");
        System.out.println("6 - Mostrar total de livros cadastrados");
        System.out.println("7 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine(); // limpa quebra de linha
        return opcao;
    }

    public String lerTitulo() {
        System.out.print("Digite o título do livro: ");
        return input.nextLine();
    }

    public String lerAutor() {
        System.out.print("Digite o autor do livro: ");
        return input.nextLine();
    }

    public double lerPreco() {
        System.out.print("Digite o preço do livro: R$ ");
        return input.nextDouble();
    }

    public int lerQuantidade() {
        System.out.print("Digite a quantidade: ");
        return input.nextInt();
    }

    public String lerEditora() {
        input.nextLine(); // limpa quebra de linha
        System.out.print("Digite a editora do livro: ");
        return input.nextLine();
    }

    public void exibirLivro(Livro livro) {
    }

    public String lerTituloBusca() {
        System.out.print("Digite o título do livro para buscar: ");
        return input.nextLine();
    }

    public String lerTituloRemover() {
        System.out.print("Digite o título do livro para remover: ");
        return input.nextLine();
    }

    public String lerTituloEditar() {
        System.out.print("Digite o título do livro para editar: ");
        return input.nextLine();
    }

    public void exibirMensagemSucesso(String acao) {
        System.out.println(" " + acao + " realizada com sucesso!");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println(" " + mensagem);
    }

    public void exibirTotalLivros(int total) {
        System.out.println(" Total de livros cadastrados: " + total);
    }

    public void finalizarSistema() {
        System.out.println(" Sistema encerrado. Obrigado por usar o BiblioTech!");
        input.close();
    }

    public int menuEdicao() {
        System.out.println("\n--- O que deseja editar? ---");
        System.out.println("1 - Título");
        System.out.println("2 - Autor");
        System.out.println("3 - Preço");
        System.out.println("4 - Quantidade");
        System.out.println("5 - Editora");
        System.out.println("0 - Cancelar edição");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }
}
