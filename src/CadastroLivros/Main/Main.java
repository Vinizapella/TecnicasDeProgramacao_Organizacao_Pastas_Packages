package CadastroLivros.Main;


import CadastroLivros.Service.Biblioteca;
import CadastroLivros.View.Atendente;

public class Main {
    public static void main(String[] args) {
        Atendente atendente = new Atendente();
        Biblioteca biblioteca = new Biblioteca();
        int opcaoEscolhida;

        do {
            opcaoEscolhida = atendente.menuPrincipal();

            if (opcaoEscolhida >= 1 && opcaoEscolhida <= 6) {
                biblioteca.gerenciarSistema(opcaoEscolhida, atendente);
            } else if (opcaoEscolhida != 7) {
                atendente.exibirMensagemErro("Opção inválida! Tente novamente.");
            }

        } while (opcaoEscolhida != 7);

        atendente.finalizarSistema();
    }
}
