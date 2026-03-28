import biblioteca.service.Biblioteca;
import biblioteca.service.loginService;
import java.util.Scanner;
void main() {

    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();


    loginService login = new loginService(biblioteca, scanner);
    login.iniciar();

    scanner.close();

}
