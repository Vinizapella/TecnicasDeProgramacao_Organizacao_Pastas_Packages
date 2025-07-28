package CadastroProdutosNaturais.Service;

import CadastroProdutosNaturais.Model.Suplemento;
import CadastroProdutosNaturais.View.Atendente;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Suplemento> listaSuplementos;

    public Estoque() {
        listaSuplementos = new ArrayList<>();
    }

    public void gerenciarSistema(int opcao, Atendente atendente) {
        switch (opcao) {
            case 1 -> cadastrarSuplemento(atendente);
            case 2 -> listarTodosSuplementos(atendente);
            case 3 -> removerSuplemento(atendente);
            case 4 -> pesquisarSuplemento(atendente);
            case 5 -> editarSuplemento(atendente);
            case 6 -> mostrarTotalSuplementos(atendente);
        }
    }

    private void cadastrarSuplemento(Atendente atendente) {
        String nome = atendente.lerNome();
        double preco = atendente.lerPreco();
        int quantidade = atendente.lerQuantidade();
        String marca = atendente.lerMarca();

        Suplemento suplemento = new Suplemento(nome, preco, quantidade, marca);
        listaSuplementos.add(suplemento);
        atendente.exibirMensagemSucesso("Cadastro do suplemento");
    }

    private void listarTodosSuplementos(Atendente atendente) {
        if (listaSuplementos.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum suplemento cadastrado.");
            return;
        }

        System.out.println("\n Lista de Suplementos Cadastrados:");
        for (Suplemento suplemento : listaSuplementos) {
            atendente.exibirSuplemento(suplemento);
        }
    }

    private void removerSuplemento(Atendente atendente) {
        if (listaSuplementos.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum suplemento cadastrado para remover.");
            return;
        }

        String nome = atendente.lerNomeRemover();
        boolean removido = false;

        for (int i = 0; i < listaSuplementos.size(); i++) {
            if (listaSuplementos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaSuplementos.remove(i);
                removido = true;
                break;
            }
        }

        if (removido) {
            atendente.exibirMensagemSucesso("Remoção do suplemento '" + nome + "'");
        } else {
            atendente.exibirMensagemErro("Suplemento '" + nome + "' não encontrado.");
        }
    }

    private void pesquisarSuplemento(Atendente atendente) {
        if (listaSuplementos.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum suplemento cadastrado para pesquisar.");
            return;
        }

        String nome = atendente.lerNomeBusca();
        boolean encontrado = false;

        for (Suplemento suplemento : listaSuplementos) {
            if (suplemento.getNome().equalsIgnoreCase(nome)) {
                System.out.println("\n Suplemento encontrado:");
                atendente.exibirSuplemento(suplemento);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            atendente.exibirMensagemErro("Suplemento '" + nome + "' não encontrado.");
        }
    }

    private void editarSuplemento(Atendente atendente) {
        if (listaSuplementos.isEmpty()) {
            atendente.exibirMensagemErro("Nenhum suplemento cadastrado para editar.");
            return;
        }

        String nome = atendente.lerNomeEditar();
        Suplemento suplementoParaEditar = null;

        for (Suplemento suplemento : listaSuplementos) {
            if (suplemento.getNome().equalsIgnoreCase(nome)) {
                suplementoParaEditar = suplemento;
                break;
            }
        }

        if (suplementoParaEditar == null) {
            atendente.exibirMensagemErro("Suplemento '" + nome + "' não encontrado.");
            return;
        }

        System.out.println("\n Suplemento atual:");
        atendente.exibirSuplemento(suplementoParaEditar);

        int opcaoEdicao = atendente.menuEdicao();

        switch (opcaoEdicao) {
            case 1 -> {
                String novoNome = atendente.lerNome();
                suplementoParaEditar.setNome(novoNome);
                atendente.exibirMensagemSucesso("Edição do nome");
            }
            case 2 -> {
                double novoPreco = atendente.lerPreco();
                suplementoParaEditar.setPreco(novoPreco);
                atendente.exibirMensagemSucesso("Edição do preço");
            }
            case 3 -> {
                int novaQuantidade = atendente.lerQuantidade();
                suplementoParaEditar.setQuantidade(novaQuantidade);
                atendente.exibirMensagemSucesso("Edição da quantidade");
            }
            case 4 -> {
                String novaMarca = atendente.lerMarca();
                suplementoParaEditar.setMarca(novaMarca);
                atendente.exibirMensagemSucesso("Edição da marca");
            }
            case 0 -> atendente.exibirMensagemErro("Edição cancelada.");
            default -> atendente.exibirMensagemErro("Opção inválida.");
        }
    }

    private void mostrarTotalSuplementos(Atendente atendente) {
        atendente.exibirTotalSuplementos(listaSuplementos.size());
    }
}
