package biblioteca.service;
import biblioteca.enums.Categoria;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

import java.util.Scanner;

public class MenuCliente {
    Biblioteca biblioteca;
    Scanner scanner;
    Usuario usuarioLogado;

    public MenuCliente(Biblioteca biblioteca, Scanner scanner, Usuario usuarioLogado) {
        this.scanner = scanner;
        this.biblioteca = biblioteca;
        this.usuarioLogado = usuarioLogado;
    }

    public void iniciar() {


        boolean rodando = true;

        while (rodando) {

            System.out.println("==================================");
            System.out.println("        ESCOLHA UMA CATEGORIA     ");
            System.out.println("==================================");
            System.out.println("[1] Comedia");
            System.out.println("[2] Drama");
            System.out.println("[3] Ficção Cientifica");
            System.out.println("[4] Romance");
            System.out.println("[5] Terror");
            System.out.println("[6] Voltar ao login");
            System.out.println("");
            System.out.println("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    listarLivrosCategoria(Categoria.COMEDIA);
                    break;
                case 2:
                    listarLivrosCategoria(Categoria.DRAMA);
                    break;
                case 3:
                    listarLivrosCategoria(Categoria.FICCAO_CIENTIFICA);
                    break;
                case 4:
                    listarLivrosCategoria(Categoria.ROMANCE);
                    break;
                case 5:
                    listarLivrosCategoria(Categoria.TERROR);
                    break;
                case 6:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }


    //função para exibir os livros por categoria selecionada
    private void listarLivrosCategoria(Categoria categoria) {

        System.out.println("==================================");
        System.out.println("           LIVROS                 ");
        System.out.println("==================================");


        //for para exibir os livros
        for (Livro l : biblioteca.livros) {

            if (l.categoria == categoria && l.disponivel) {
                System.out.println("[" + l.id + "]" + l.titulo + "-" + l.autor);
            }
        }
        System.out.println("=========================");
        System.out.println("Digite o ID do livro (0 para retornar) ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id == 0) {
            return;
        }

        selecionarLivro(id);

    }

    private void selecionarLivro(int id) {

        for (Livro l : biblioteca.livros) {
            if (l.id == id) {

                if (!l.disponivel) {

                    System.out.println("Livro não Disponivel");
                    return;
                }

                System.out.println("==================================");
                System.out.println("Título: " + l.titulo);
                System.out.println("Autor: " + l.autor);
                System.out.println("Descrição: " + l.descricaoLivro);
                System.out.println("Lançamento: " + l.dataLancamento);
                System.out.println("==================================");
                System.out.println("[1] Confirmar empréstimo");
                System.out.println("[2] Voltar");
                System.out.print("Escolha: ");

                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha == 1) {
                    confirmaEmprestimo(l);
                }
                return;
            }
        }
        System.out.println("Livro não encontrado ");
    }

    private void confirmaEmprestimo(Livro livro) {

        System.out.println("Digite a data de devolução (dd/mm/aa)");
        String dataDevolucao = scanner.nextLine();

        livro.disponivel = false;

        System.out.println("==================================");
        System.out.println("       EMPRÉSTIMO CONFIRMADO!     ");
        System.out.println("==================================");
        System.out.println("Usuário: " + usuarioLogado.nome);
        System.out.println("Livro: " + livro.titulo);
        System.out.println("Data de devolução: " + dataDevolucao);
        System.out.println("==================================");
    }


}