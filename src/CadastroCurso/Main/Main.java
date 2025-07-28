package CadastroCurso.Main;

import CadastroCurso.Service.GerenciadorCursos;
import CadastroCurso.View.Secretaria;

public class Main{
    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();
        GerenciadorCursos gerenciador = new GerenciadorCursos();
        int opcaoEscolhida;

        do {
            opcaoEscolhida = secretaria.menuPrincipal();

            if (opcaoEscolhida >= 1 && opcaoEscolhida <= 6) {
                gerenciador.gerenciarSistema(opcaoEscolhida, secretaria);
            } else if (opcaoEscolhida != 7) {
                secretaria.exibirMensagemErro("Opção inválida! Tente novamente.");
            }

        } while (opcaoEscolhida != 7);

        secretaria.finalizarSistema();
    }
}