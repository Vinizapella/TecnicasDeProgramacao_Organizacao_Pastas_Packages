package CadastroProdutosNaturais.Main;

import CadastroProdutosNaturais.Service.Estoque;
import CadastroProdutosNaturais.View.Atendente;

public class Main {
    public static void main(String[] args) {
        Atendente atendente = new Atendente();
        Estoque estoque = new Estoque();
        int opcaoEscolhida;

        do {
            opcaoEscolhida = atendente.menuPrincipal();

            if (opcaoEscolhida >= 1 && opcaoEscolhida <= 6) {
                estoque.gerenciarSistema(opcaoEscolhida, atendente);
            } else if (opcaoEscolhida != 7) {
                atendente.exibirMensagemErro("Opção inválida! Tente novamente.");
            }

        } while (opcaoEscolhida != 7);

        atendente.finalizarSistema();
    }
}