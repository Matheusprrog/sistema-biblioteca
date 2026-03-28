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
            IO.println("==================================");
            IO.println("    BEM VINDO A BIBLIOTECA  ");
            IO.println("==================================");
            IO.println("");
            IO.println("[1] Login");
            IO.println("[2] Sair ");
            IO.println(" ");

            IO.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                fazerLogin();

            } else if (opcao == 2) {
                IO.println("Sistema Encerrado!");
                rodando = false;
            } else {
                IO.println("Opção Invalida! tente novamente");
            }
        }
    }

           //metodo de validação de login

            public void fazerLogin () {
                IO.print("Nome: ");
                String nome = scanner.nextLine();
                IO.print("senha: ");
                String senha = scanner.nextLine();

                for (Usuario u : biblioteca.usuarios) {
                    if (u.nome.equals(nome) && u.senha.equals(senha)) {
                        IO.println("Bem vindo " + u.nome + "!");



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

        IO.println("Nome ou senha incorretos! Tente novamente.");
            }

    }






