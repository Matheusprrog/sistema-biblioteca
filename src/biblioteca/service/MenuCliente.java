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
    public void iniciar(){


        boolean rodando = true;

        while (rodando) {

            IO.println("==================================");
            IO.println("        ESCOLHA UMA CATEGORIA     ");
            IO.println("==================================");
            IO.println("[1] Comedia");
            IO.println("[2] Drama");
            IO.println("[3] Ficção Cientifica");
            IO.println("[4] Romance");
            IO.println("[5] Terror");
            IO.println("[6] Voltar ao login");
            IO.println("");
            IO.println("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();



            switch (opcao){
                case 1: listarLivrosCategoria(Categoria.COMEDIA); break;
                case 2: listarLivrosCategoria(Categoria.DRAMA); break;
                case 3: listarLivrosCategoria(Categoria.FICCAO_CIENTIFICA); break;
                case 4: listarLivrosCategoria(Categoria.ROMANCE); break;
                case 5: listarLivrosCategoria(Categoria.TERROR); break;
                case 6: rodando = false; break;
                default: IO.println("Opção invalida");
            }
        }
    }



    //função para exibir os livros por categoria selecionada
    private void listarLivrosCategoria(Categoria categoria){

        IO.println("==================================");
        IO.println("           LIVROS                 ");
        IO.println("==================================");



        //for para exibir os livros
        for(Livro l : biblioteca.livros){

            if(l.categoria == categoria && l.disponivel){
                IO.println("["+ l.id +"]" + l.titulo + "-" + l.autor);
            }
        }
        IO.println("=========================");
        IO.println("Digite o ID do livro (0 para retornar) ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(id== 0) {
            return;
        }

        selecionarLivro(id);

    }

    private void selecionarLivro(int id){

    for(Livro l : biblioteca.livros) {
        if (l.id == id) {

            if (!l.disponivel) {

                IO.println("Livro não Disponivel");
                return;
            }

            IO.println("==================================");
            IO.println("Título: " + l.titulo);
            IO.println("Autor: " + l.autor);
            IO.println("Descrição: " + l.descricao_livro);
            IO.println("Lançamento: " + l.data_lancamento);
            IO.println("==================================");
            IO.println("[1] Confirmar empréstimo");
            IO.println("[2] Voltar");
            IO.print("Escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                confirmaEmprestimo(l);
            }
            return;
        }
      }
        IO.println("Livro não encontrado ");
    }

        private void confirmaEmprestimo(Livro livro){

            IO.println("Digite a data de devolução (dd/mm/aa)");
            String dataDevolucao = scanner.nextLine();

            livro.disponivel = false;

            IO.println("==================================");
            IO.println("       EMPRÉSTIMO CONFIRMADO!     ");
            IO.println("==================================");
            IO.println("Usuário: " + usuarioLogado.nome);
            IO.println("Livro: " + livro.titulo);
            IO.println("Data de devolução: " + dataDevolucao);
            IO.println("==================================");
        }




}
