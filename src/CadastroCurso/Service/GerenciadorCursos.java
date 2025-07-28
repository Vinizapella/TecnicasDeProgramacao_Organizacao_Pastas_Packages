package CadastroCurso.Service;

import CadastroCurso.Model.Curso;
import CadastroCurso.View.Secretaria;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorCursos {
    private List<Curso> listaCursos;

    public GerenciadorCursos() {
        listaCursos = new ArrayList<>();
    }

    public void gerenciarSistema(int opcao, Secretaria secretaria) {
        switch (opcao) {
            case 1 -> cadastrarCurso(secretaria);
            case 2 -> listarTodosCursos(secretaria);
            case 3 -> removerCurso(secretaria);
            case 4 -> buscarCurso(secretaria);
            case 5 -> editarCurso(secretaria);
            case 6 -> mostrarTotalCursos(secretaria);
        }
    }

    private void cadastrarCurso(Secretaria secretaria) {
        String nome = secretaria.lerNome();
        int duracaoHoras = secretaria.lerDuracaoHoras();
        String nivel = secretaria.lerNivel();
        int vagas = secretaria.lerVagas();

        Curso curso = new Curso(nome, duracaoHoras, nivel, vagas);
        listaCursos.add(curso);
        secretaria.exibirMensagemSucesso("Cadastro do curso");
    }

    private void listarTodosCursos(Secretaria secretaria) {
        if (listaCursos.isEmpty()) {
            secretaria.exibirMensagemErro("Nenhum curso cadastrado.");
            return;
        }

        System.out.println("\n Lista de Cursos Cadastrados:");
        for (Curso curso : listaCursos) {
            secretaria.exibirCurso(curso);
        }
    }

    private void removerCurso(Secretaria secretaria) {
        if (listaCursos.isEmpty()) {
            secretaria.exibirMensagemErro("Nenhum curso cadastrado para remover.");
            return;
        }

        String nome = secretaria.lerNomeRemover();
        boolean removido = false;

        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaCursos.remove(i);
                removido = true;
                break;
            }
        }

        if (removido) {
            secretaria.exibirMensagemSucesso("Remoção do curso '" + nome + "'");
        } else {
            secretaria.exibirMensagemErro("Curso '" + nome + "' não encontrado.");
        }
    }

    private void buscarCurso(Secretaria secretaria) {
        if (listaCursos.isEmpty()) {
            secretaria.exibirMensagemErro("Nenhum curso cadastrado para buscar.");
            return;
        }

        String nome = secretaria.lerNomeBusca();
        boolean encontrado = false;

        for (Curso curso : listaCursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                System.out.println("\n Curso encontrado:");
                secretaria.exibirCurso(curso);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            secretaria.exibirMensagemErro("Curso '" + nome + "' não encontrado.");
        }
    }

    private void editarCurso(Secretaria secretaria) {
        if (listaCursos.isEmpty()) {
            secretaria.exibirMensagemErro("Nenhum curso cadastrado para editar.");
            return;
        }

        String nome = secretaria.lerNomeEditar();
        Curso cursoParaEditar = null;

        for (Curso curso : listaCursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                cursoParaEditar = curso;
                break;
            }
        }

        if (cursoParaEditar == null) {
            secretaria.exibirMensagemErro("Curso '" + nome + "' não encontrado.");
            return;
        }

        System.out.println("\n Curso atual:");
        secretaria.exibirCurso(cursoParaEditar);

        int opcaoEdicao = secretaria.menuEdicao();

        switch (opcaoEdicao) {
            case 1 -> {
                String novoNome = secretaria.lerNome();
                cursoParaEditar.setNome(novoNome);
                secretaria.exibirMensagemSucesso("Edição do nome");
            }
            case 2 -> {
                int novaDuracao = secretaria.lerDuracaoHoras();
                cursoParaEditar.setDuracaoHoras(novaDuracao);
                secretaria.exibirMensagemSucesso("Edição da duração");
            }
            case 3 -> {
                String novoNivel = secretaria.lerNivel();
                cursoParaEditar.setNivel(novoNivel);
                secretaria.exibirMensagemSucesso("Edição do nível");
            }
            case 4 -> {
                int novasVagas = secretaria.lerVagas();
                cursoParaEditar.setVagas(novasVagas);
                secretaria.exibirMensagemSucesso("Edição das vagas");
            }
            case 0 -> secretaria.exibirMensagemErro("Edição cancelada.");
            default -> secretaria.exibirMensagemErro("Opção inválida.");
        }
    }

    private void mostrarTotalCursos(Secretaria secretaria) {
        secretaria.exibirTotalCursos(listaCursos.size());
    }
}

