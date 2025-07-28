package CadastroCurso.View;

import CadastroCurso.Model.Curso;
import java.util.Scanner;

public class Secretaria {
    private Scanner input;

    public Secretaria() {
        input = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println("\n=== EDUCAPP - Sistema de Cadastro de Cursos ===");
        System.out.println("1 - Cadastrar curso");
        System.out.println("2 - Listar todos os cursos");
        System.out.println("3 - Remover curso pelo nome");
        System.out.println("4 - Buscar curso pelo nome");
        System.out.println("5 - Editar dados do curso");
        System.out.println("6 - Mostrar total de cursos cadastrados");
        System.out.println("7 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

    public String lerNome() {
        System.out.print("Digite o nome do curso: ");
        return input.nextLine();
    }

    public int lerDuracaoHoras() {
        System.out.print("Digite a duração do curso (em horas): ");
        return input.nextInt();
    }

    public String lerNivel() {
        input.nextLine();
        System.out.print("Digite o nível do curso (básico/intermediário/avançado): ");
        return input.nextLine();
    }

    public int lerVagas() {
        System.out.print("Digite o número de vagas: ");
        return input.nextInt();
    }

    public String lerNomeBusca() {
        System.out.print("Digite o nome do curso para buscar: ");
        return input.nextLine();
    }

    public String lerNomeRemover() {
        System.out.print("Digite o nome do curso para remover: ");
        return input.nextLine();
    }

    public String lerNomeEditar() {
        System.out.print("Digite o nome do curso para editar: ");
        return input.nextLine();
    }

    public void exibirCurso(Curso curso) {
        System.out.println(curso.toString());
    }

    public void exibirMensagemSucesso(String acao) {
        System.out.println(" " + acao + " realizada com sucesso!");
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println(" " + mensagem);
    }

    public void exibirTotalCursos(int total) {
        System.out.println("Total de cursos cadastrados: " + total);
    }

    public void finalizarSistema() {
        System.out.println(" Sistema encerrado. Obrigado por usar o EducApp!");
        input.close();
    }

    public int menuEdicao() {
        System.out.println("\n--- O que deseja editar? ---");
        System.out.println("1 - Nome");
        System.out.println("2 - Duração (horas)");
        System.out.println("3 - Nível");
        System.out.println("4 - Vagas");
        System.out.println("0 - Cancelar edição");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }
}