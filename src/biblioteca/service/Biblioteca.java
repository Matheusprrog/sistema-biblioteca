package biblioteca.service;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.enums.Cargo;
import biblioteca.enums.Categoria;


import java.util.ArrayList;

public class Biblioteca {

    public ArrayList<Livro> livros = new ArrayList<> ();
    public ArrayList<Usuario> usuarios = new ArrayList<> ();

    public Biblioteca (){


        cadastrarLivrosIniciais ();
        cadastrarUsuariosIniciais ();

    }

    private void cadastrarLivrosIniciais () {

        livros.add(new Livro(1, "Como Eu Era Antes de Você", "Jojo Moyes", "historia de uma garconete que se apaixona.", "05/01/2012", true,  Categoria.ROMANCE ));
        livros.add(new Livro(2, "para todos os garotos que ja amei", "Jenny Han", "garota guarda as cartas que ela escrevel para garotos", "15/04/2014", true, Categoria.ROMANCE ));
        livros.add(new Livro(3, "verity", "Colleen Hoover", "Lowen encontra livro que explica morte de uma familia de campo", "07/12/2018", true, Categoria.TERROR));
        livros.add(new Livro(4, "It a Coisa", "Stephen King", "Aparição de um palhaço assasino na cidade", "10/10/1986", true, Categoria.TERROR));
        livros.add(new Livro(5, "O Gênio do Crime", "João Carlos Marinho", "é um grupo de crianças paulistanas que investiga o esquema de falsificação de figurinhas no livro \"O Gênio do Crime", "11/02/1969", true, Categoria.COMEDIA));
        livros.add(new Livro(6, "Os Noivos do Apocalipse", "Evandro Santo", "Uma comédia apocalíptica hilária", "2015", true,  Categoria.COMEDIA));
        livros.add(new Livro(7, "Duna", "Frank Herbert", "Épico de ficção científica", "1965", true, Categoria.FICCAO_CIENTIFICA));
        livros.add(new Livro(8, "O Guia do Mochileiro", "Douglas Adams", "Ficção científica cômica", "1979", true, Categoria.FICCAO_CIENTIFICA));
        livros.add(new Livro(9, "A Culpa é das Estrelas", "John Green", "Drama jovem emocionante", "2012", true, Categoria.DRAMA));
        livros.add(new Livro(10, "Extraordinário", "R.J. Palacio", "História de superação e empatia", "2012",true, Categoria.DRAMA));

    }

    private void cadastrarUsuariosIniciais () {
    usuarios.add(new Usuario ("admin", "1234", Cargo.ADMINISTRADOR));
    usuarios.add(new Usuario("ellen", "1234", Cargo.COMUM));

    }


    public void listarLivros(){

        IO.println("===========================");
        IO.println("    LISTA DE LIVROS ");
        IO.println("==============================");

        for (Livro l: livros){

            String disponibilidade = l.disponivel ? "Disponivel" : "Indisponivel";
            IO.println("[" + l.id + "] " + l.titulo + " - " + l.autor + " | " + disponibilidade);

        }

    }

    public void listarUsuario(){
        IO.println("===========================");
        IO.println("    LISTA DE USUARIOS ");
        IO.println("==============================");

        for (Usuario l: usuarios){


            IO.println("nome: " + l.nome + " - " + l.cargo);

        }}


}


