package biblioteca.service;

import java.util.Scanner;

import biblioteca.enums.Cargo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.enums.Categoria;


public class MenuAdmin {

    Biblioteca biblioteca;
    Scanner scanner;


    public MenuAdmin(Biblioteca biblioteca, Scanner scanner) {
        this.scanner = scanner;
        this.biblioteca = biblioteca;
    }

    public void iniciar() {

        System.out.println("=====MENU ADIMINISTRADOR======");
        System.out.println("");
        System.out.println("");


        boolean rodando = true;
        while (rodando) {


            System.out.println("[1] Adicionar Livro");
            System.out.println("[2] adicionar Usuario");
            System.out.println("[3] Remover Livro");
            System.out.println("[4] Remover Usuario");
            System.out.println("[5] Voltar ao Login");

            System.out.println("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                adicionarLivro();

            } else if (opcao == 2) {
                adicionarUsuario();

            } else if (opcao == 3) {
                deletarLivro();

            } else if (opcao == 4) {
                deletarUsuario();

            } else if (opcao == 5) {
                rodando = false;

            } else {

                System.out.println("Opção Invalida! tente novamente");
            }

        }


    }

    public void adicionarLivro() {

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data de Lançamento: ");
        String dataLancamento = scanner.nextLine();

        System.out.println("Escolha a categoria:");
        System.out.println("[1] Comédia");
        System.out.println("[2] Drama");
        System.out.println("[3] Ficção Científica");
        System.out.println("[4] Romance");
        System.out.println("[5] Terror");
        System.out.print("Categoria: ");
        int opcaocategoria = scanner.nextInt();
        scanner.nextLine();

        Categoria categoria;

        switch (opcaocategoria){

            case 1: categoria = Categoria.COMEDIA; break;
            case 2: categoria = Categoria.DRAMA; break;
            case 3: categoria = Categoria.FICCAO_CIENTIFICA; break;
            case 4: categoria = Categoria.ROMANCE; break;
            case 5: categoria = Categoria.TERROR; break;
            default:
                System.out.println("Categoria invalida!");
                return;



        }
        int novoID =biblioteca.livros.size() +1;

        Livro novolivro = new Livro(novoID, titulo, autor, descricao, dataLancamento,true, categoria);
        biblioteca.livros.add(novolivro);

        System.out.println("Livro adicionado com sucesso!");




    }

    public void adicionarUsuario() {

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("senha: ");
        String senha = scanner.nextLine();

        System.out.println("Escolha o cargo:");
        System.out.println("[1] Administrador");
        System.out.println("[2] Usuario comum");

        int opnCargo = scanner.nextInt();
        scanner.nextLine();

        Cargo cargo;

        switch (opnCargo) {


            case 1: cargo = Cargo.ADMINISTRADOR; break;

            case 2: cargo = Cargo.COMUM; break;

            default:
                System.out.println("Cargo invalido");
                return;

        }
        Usuario novoUsuario = new Usuario(nome, senha, cargo);
        biblioteca.usuarios.add(novoUsuario);

        System.out.println("Novo Usuario cadastrado com sucesso!");



    }

    public void deletarLivro() {
        biblioteca.listarLivros();

        System.out.println("Digite o ID do livro que deseja remover");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Livro l : biblioteca.livros) {

            if (l.id == id) {
                biblioteca.livros.remove(l);
                System.out.println("Livro removido com sucesso!");
                System.out.println("");
                System.out.println("");

                return;
            }
        }
        System.out.println("Livro não encontrado !");

    }


    public void deletarUsuario() {
        biblioteca.listarUsuario();

        System.out.println("Digite o nome do usuario que deseja remover");
        String nome = scanner.nextLine();


        for(Usuario u : biblioteca.usuarios){
            if(u.nome.equals(nome)){
                biblioteca.usuarios.remove(u);
                System.out.println("Usuario removido com sucesso!");
                return;

            }

        }

    }


}