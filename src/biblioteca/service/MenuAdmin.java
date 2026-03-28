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

        IO.println("=====MENU ADIMINISTRADOR======");
        IO.println("");
        IO.println("");


        boolean rodando = true;
        while (rodando) {


            IO.println("[1] Adcionar Livro");
            IO.println("[2] Adcionar Usuario");
            IO.println("[3] Remover Livro");
            IO.println("[4] Remover Usuario");
            IO.println("[5] Voltar ao Login");

            IO.println("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                adcionarLivro();

            } else if (opcao == 2) {
                adcionarUsuario();

            } else if (opcao == 3) {
                deletarLivro();

            } else if (opcao == 4) {
                deletarUsuario();

            } else if (opcao == 5) {
                rodando = false;

            } else {

                IO.println("Opção Invalida! tente novamente");
            }

        }


    }

    public void adcionarLivro() {

        IO.print("Titulo: ");
        String titulo = scanner.nextLine();

        IO.print("Autor: ");
        String autor = scanner.nextLine();

        IO.print("Descrição: ");
        String descricao = scanner.nextLine();

        IO.print("Data de Lançamento: ");
        String dataLancamento = scanner.nextLine();

        IO.println("Escolha a categoria:");
        IO.println("[1] Comédia");
        IO.println("[2] Drama");
        IO.println("[3] Ficção Científica");
        IO.println("[4] Romance");
        IO.println("[5] Terror");
        IO.print("Categoria: ");
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
                IO.println("Categoria invalida!");
                return;



        }
        int novoID =biblioteca.livros.size() +1;

        Livro novolivro = new Livro(novoID, titulo, autor, descricao, dataLancamento,true, categoria);
        biblioteca.livros.add(novolivro);

        IO.println("Livro adicionado com sucesso!");




    }

    public void adcionarUsuario() {

        IO.println("Nome: ");
        String nome = scanner.nextLine();

        IO.println("senha: ");
        String senha = scanner.nextLine();

        IO.println("Escolha o cargo:");
        IO.println("[1] Administrador");
        IO.println("[2] Usuario comum");

        int opnCargo = scanner.nextInt();
        scanner.nextLine();

        Cargo cargo;

        switch (opnCargo) {


            case 1: cargo = Cargo.ADMINISTRADOR; break;

            case 2: cargo = Cargo.COMUM; break;

            default:
                IO.println("Cargo invalido");
                return;

        }
        Usuario novoUsuario = new Usuario(nome, senha, cargo);
        biblioteca.usuarios.add(novoUsuario);

        IO.println("Novo Usuario cadastrado com sucesso!");



    }

    public void deletarLivro() {
        biblioteca.listarLivros();

        IO.println("Digite o ID do livro que deseja remover");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Livro l : biblioteca.livros) {

            if (l.id == id) {
                biblioteca.livros.remove(l);
                IO.println("Livro removido com sucesso!");
                IO.println("");
                IO.println("");

                return;
            }
        }
        IO.println("Livro não encontrado !");

    }


    public void deletarUsuario() {
        biblioteca.listarUsuario();

        IO.println("Digite o nome do usuario que deseja remover");
        String nome = scanner.nextLine();


        for(Usuario u : biblioteca.usuarios){
            if(u.nome.equals(nome)){
                biblioteca.usuarios.remove(u);
                IO.println("Usuario removido com sucesso!");
                return;

            }

        }

    }


}