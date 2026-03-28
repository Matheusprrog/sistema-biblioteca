package biblioteca.model;
import biblioteca.enums.Cargo;

public class Usuario {

    public String nome;
    public String senha;
    public Cargo cargo;


    public Usuario(String nome, String senha, Cargo cargo) {

    this.nome = nome;
    this.senha = senha;
    this.cargo = cargo;
    }

}