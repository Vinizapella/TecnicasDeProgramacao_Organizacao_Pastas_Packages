package CadastroLivros.Service;

import CadastroLivros.Model.Livro;
import CadastroLivros.View.Atendente;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> listaLivros;

    public Biblioteca() {
        listaLivros = new ArrayList<>();
    }

    public void gerenciarSistema(int opcao, Atendente atendente) {
        switch (opcao) {
            case 1 -> cadastrarLivro(atendente);
            case 2 -> listarTodosLivros(atendente);
            case 3 -> removerLivro(atendente);
            case 4 -> buscarLivro(atendente);
            case 5 -> editarLivro(atendente);
            case 6 -> mostrarTotalLivros(atendente);
        }
    }

    private void cadastrarLivro(Atendente atendente) {
        String titulo = atendente.lerTitulo();
        String autor = atendente.lerAutor();
        double preco = atendente.lerPreco();
        int quantidade = atendente.lerQuantidade();
        String editora = atendente.lerEditora();

        Livro livro = new Livro(titulo, autor, preco, quantidade, editora);
        listaLivros.add(livro);
        atendente.exibirMensagemSucesso("Cadastro do livro");
    }

    private void listarTodosLivros(Atendente atendente) {
        if (listaLivros.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n Lista de Livros Cadastrados:");
        for (Livro livro : listaLivros) {
            atendente.exibirLivro(livro);
        }
    }

    private void removerLivro(Atendente atendente) {
        if (listaLivros.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum livro cadastrado para remover.");
            return;
        }

        String titulo = atendente.lerTituloRemover();
        boolean removido = false;

        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaLivros.remove(i);
                removido = true;
                break;
            }
        }

        if (removido) {
            atendente.exibirMensagemSucesso("Remoção do livro '" + titulo + "'");
        } else {
            atendente.exibirMensagemErro("Livro '" + titulo + "' não encontrado.");
        }
    }

    private void buscarLivro(Atendente atendente) {
        if (listaLivros.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum livro cadastrado para buscar.");
            return;
        }

        String titulo = atendente.lerTituloBusca();
        boolean encontrado = false;

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\n Livro encontrado:");
                atendente.exibirLivro(livro);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            atendente.exibirMensagemErro("Livro '" + titulo + "' não encontrado.");
        }
    }

    private void editarLivro(Atendente atendente) {
        if (listaLivros.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum livro cadastrado para editar.");
            return;
        }

        String titulo = atendente.lerTituloEditar();
        Livro livroParaEditar = null;

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroParaEditar = livro;
                break;
            }
        }

        if (livroParaEditar == null) {
            atendente.exibirMensagemErro("Livro '" + titulo + "' não encontrado.");
            return;
        }

        System.out.println("\n Livro atual:");
        atendente.exibirLivro(livroParaEditar);

        int opcaoEdicao = atendente.menuEdicao();

        switch (opcaoEdicao) {
            case 1 -> {
                String novoTitulo = atendente.lerTitulo();
                livroParaEditar.setTitulo(novoTitulo);
                atendente.exibirMensagemSucesso("Edição do título");
            }
            case 2 -> {
                String novoAutor = atendente.lerAutor();
                livroParaEditar.setAutor(novoAutor);
                atendente.exibirMensagemSucesso("Edição do autor");
            }
            case 3 -> {
                double novoPreco = atendente.lerPreco();
                livroParaEditar.setPreco(novoPreco);
                atendente.exibirMensagemSucesso("Edição do preço");
            }
            case 4 -> {
                int novaQuantidade = atendente.lerQuantidade();
                livroParaEditar.setQuantidade(novaQuantidade);
                atendente.exibirMensagemSucesso("Edição da quantidade");
            }
            case 5 -> {
                String novaEditora = atendente.lerEditora();
                livroParaEditar.setEditora(novaEditora);
                atendente.exibirMensagemSucesso("Edição da editora");
            }
            case 0 -> atendente.exibirMensagemErro("Edição cancelada.");
            default -> atendente.exibirMensagemErro("Opção inválida.");
        }
    }

    private void mostrarTotalLivros(Atendente atendente) {
        atendente.exibirTotalLivros(listaLivros.size());
    }
}
