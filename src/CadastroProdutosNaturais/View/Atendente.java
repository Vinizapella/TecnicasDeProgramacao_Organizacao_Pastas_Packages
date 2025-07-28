package CadastroProdutosNaturais.View;

import CadastroProdutosNaturais.Model.Suplemento;
import java.util.Scanner;

public class Atendente {
    private Scanner input;

    public Atendente() {
        input = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println("\n=== NATURAPP - Sistema de Produtos Naturais ===");
        System.out.println("1 - Cadastrar suplemento");
        System.out.println("2 - Listar todos os suplementos");
        System.out.println("3 - Remover suplemento por nome");
        System.out.println("4 - Pesquisar por nome");
        System.out.println("5 - Editar suplemento");
        System.out.println("6 - Contagem de suplementos cadastrados");
        System.out.println("7 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

    public String lerNome() {
        System.out.print("Digite o nome do suplemento: ");
        return input.nextLine();
    }

    public double lerPreco() {
        System.out.print("Digite o preço do suplemento: R$ ");
        return input.nextDouble();
    }

    public int lerQuantidade() {
        System.out.print("Digite a quantidade: ");
        return input.nextInt();
    }

    public String lerMarca() {
        input.nextLine();
        System.out.print("Digite a marca do suplemento: ");
        return input.nextLine();
    }

    public String lerNomeBusca() {
        System.out.print("Digite o nome do suplemento para buscar: ");
        return input.nextLine();
    }

    public String lerNomeRemover() {
        System.out.print("Digite o nome do suplemento para remover: ");
        return input.nextLine();
    }

    public String lerNomeEditar() {
        System.out.print("Digite o nome do suplemento para editar: ");
        return input.nextLine();
    }

    public void exibirSuplemento(Suplemento suplemento) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Nome: " + suplemento.getNome());
        System.out.println("Preço: R$ " + String.format("%.2f", suplemento.getPreco()));
        System.out.println("Quantidade: " + suplemento.getQuantidade());
        System.out.println("Marca: " + suplemento.getMarca());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    public void exibirMensagemSucesso(String acao) {
        System.out.println(" " + acao + " realizada com sucesso!");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println(" " + mensagem);
    }

    public void exibirTotalSuplementos(int total) {
        System.out.println(" Total de suplementos cadastrados: " + total);
    }

    public void finalizarSistema() {
        System.out.println(" Sistema encerrado. Obrigado por usar o NaturApp!");
        input.close();
    }

    public int menuEdicao() {
        System.out.println("\n--- O que deseja editar? ---");
        System.out.println("1 - Nome");
        System.out.println("2 - Preço");
        System.out.println("3 - Quantidade");
        System.out.println("4 - Marca");
        System.out.println("0 - Cancelar edição");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }
}