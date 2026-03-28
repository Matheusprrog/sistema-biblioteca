package biblioteca.service;
import java.util.Scanner;
import biblioteca.enums.Cargo;
import biblioteca.service.Biblioteca;
import biblioteca.model.Usuario;


public class loginService {

    Biblioteca biblioteca;
    Scanner scanner;

    public loginService(Biblioteca biblioteca, Scanner scanner) {

        this.scanner = scanner;
        this.biblioteca = biblioteca;
    }



    //metodo de inicialização do sistema
    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("==================================");
            System.out.println("    BEM VINDO A BIBLIOTECA  ");
            System.out.println("==================================");
            System.out.println("");
            System.out.println("[1] Login");
            System.out.println("[2] Sair ");
            System.out.println(" ");

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                fazerLogin();

            } else if (opcao == 2) {
                System.out.println("Sistema Encerrado!");
                rodando = false;
            } else {
                System.out.println("Opção Invalida! tente novamente");
            }
        }
    }

           //metodo de validação de login

            public void fazerLogin () {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("senha: ");
                String senha = scanner.nextLine();

                for (Usuario u : biblioteca.usuarios) {
                    if (u.nome.equals(nome) && u.senha.equals(senha)) {
                        System.out.println("Bem vindo " + u.nome + "!");



                        if(u.cargo == Cargo.ADMINISTRADOR){
                            MenuAdmin menuAdmin = new MenuAdmin(biblioteca, scanner);
                            menuAdmin.iniciar();
                        }

                        else if (u.cargo == Cargo.COMUM){
                            MenuCliente menuCliente = new MenuCliente(biblioteca, scanner, u);
                            menuCliente.iniciar();
                        }
                        return;
                    }
                }

        System.out.println("Nome ou senha incorretos! Tente novamente.");
            }

    }