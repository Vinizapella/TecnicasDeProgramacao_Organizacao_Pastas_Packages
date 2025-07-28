package CadastroFilme.Service;

import CadastroFilme.Model.Filme;
import CadastroFilme.View.Operador;
import java.util.ArrayList;
import java.util.List;

public class CatalogoFilmes {
    private List<Filme> listaFilmes;

    public CatalogoFilmes() {
        listaFilmes = new ArrayList<>();
    }

    public void gerenciarSistema(int opcao, Operador operador) {
        switch (opcao) {
            case 1 -> cadastrarFilme(operador);
            case 2 -> listarTodosFilmes(operador);
            case 3 -> removerFilme(operador);
            case 4 -> buscarFilme(operador);
            case 5 -> editarFilme(operador);
            case 6 -> mostrarTotalFilmes(operador);
        }
    }

    private void cadastrarFilme(Operador operador) {
        String titulo = operador.lerTitulo();
        String genero = operador.lerGenero();
        int duracao = operador.lerDuracao();
        int anoLancamento = operador.lerAnoLancamento();

        Filme filme = new Filme(titulo, genero, duracao, anoLancamento);
        listaFilmes.add(filme);
        operador.exibirMensagemSucesso("Cadastro do filme");
    }

    private void listarTodosFilmes(Operador operador) {
        if (listaFilmes.isEmpty()) {
            operador.exibirMensagemErro("Nenhum filme cadastrado.");
            return;
        }

        System.out.println("\n Lista de Filmes Cadastrados:");
        for (Filme filme : listaFilmes) {
            operador.exibirFilme(filme);
        }
    }

    private void removerFilme(Operador operador) {
        if (listaFilmes.isEmpty()) {
            operador.exibirMensagemErro("Nenhum filme cadastrado para remover.");
            return;
        }

        String titulo = operador.lerTituloRemover();
        boolean removido = false;

        for (int i = 0; i < listaFilmes.size(); i++) {
            if (listaFilmes.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaFilmes.remove(i);
                removido = true;
                break;
            }
        }

        if (removido) {
            operador.exibirMensagemSucesso("Remoção do filme '" + titulo + "'");
        } else {
            operador.exibirMensagemErro("Filme '" + titulo + "' não encontrado.");
        }
    }

    private void buscarFilme(Operador operador) {
        if (listaFilmes.isEmpty()) {
            operador.exibirMensagemErro("Nenhum filme cadastrado para buscar.");
            return;
        }

        String titulo = operador.lerTituloBusca();
        boolean encontrado = false;

        for (Filme filme : listaFilmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\n Filme encontrado:");
                operador.exibirFilme(filme);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            operador.exibirMensagemErro("Filme '" + titulo + "' não encontrado.");
        }
    }

    private void editarFilme(Operador operador) {
        if (listaFilmes.isEmpty()) {
            operador.exibirMensagemErro("Nenhum filme cadastrado para editar.");
            return;
        }

        String titulo = operador.lerTituloEditar();
        Filme filmeParaEditar = null;

        for (Filme filme : listaFilmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmeParaEditar = filme;
                break;
            }
        }

        if (filmeParaEditar == null) {
            operador.exibirMensagemErro("Filme '" + titulo + "' não encontrado.");
            return;
        }

        System.out.println("\n Filme atual:");
        operador.exibirFilme(filmeParaEditar);

        int opcaoEdicao = operador.menuEdicao();

        switch (opcaoEdicao) {
            case 1 -> {
                String novoTitulo = operador.lerTitulo();
                filmeParaEditar.setTitulo(novoTitulo);
                operador.exibirMensagemSucesso("Edição do título");
            }
            case 2 -> {
                String novoGenero = operador.lerGenero();
                filmeParaEditar.setGenero(novoGenero);
                operador.exibirMensagemSucesso("Edição do gênero");
            }
            case 3 -> {
                int novaDuracao = operador.lerDuracao();
                filmeParaEditar.setDuracao(novaDuracao);
                operador.exibirMensagemSucesso("Edição da duração");
            }
            case 4 -> {
                int novoAno = operador.lerAnoLancamento();
                filmeParaEditar.setAnoLancamento(novoAno);
                operador.exibirMensagemSucesso("Edição do ano de lançamento");
            }
            case 0 -> operador.exibirMensagemErro("Edição cancelada.");
            default -> operador.exibirMensagemErro("Opção inválida.");
        }
    }

    private void mostrarTotalFilmes(Operador operador) {
        operador.exibirTotalFilmes(listaFilmes.size());
    }
}
