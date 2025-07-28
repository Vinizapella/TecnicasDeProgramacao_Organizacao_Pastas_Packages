package CadastroFilme.Main;

import CadastroFilme.Service.CatalogoFilmes;
import CadastroFilme.View.Operador;

public class Main {
    public static void main(String[] args) {
        Operador operador = new Operador();
        CatalogoFilmes catalogo = new CatalogoFilmes();
        int opcaoEscolhida;

        do {
            opcaoEscolhida = operador.menuPrincipal();

            if (opcaoEscolhida >= 1 && opcaoEscolhida <= 6) {
                catalogo.gerenciarSistema(opcaoEscolhida, operador);
            } else if (opcaoEscolhida != 7) {
                operador.exibirMensagemErro("Opção inválida! Tente novamente.");
            }

        } while (opcaoEscolhida != 7);

        operador.finalizarSistema();
    }
}