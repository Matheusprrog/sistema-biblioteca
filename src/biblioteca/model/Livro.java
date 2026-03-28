package biblioteca.model;
import biblioteca.enums.Categoria;


    public class Livro {

        public     String autor;
        public     String descricao_livro;
        public    String data_lancamento;
        public   String titulo;
        public   boolean disponivel;
        public   Categoria categoria;
        public   int id;

      public Livro(int id,String titulo, String autor, String descricao_livro, String data_lancamento, boolean disponivel, Categoria categoria){

          this.id =id;
          this.titulo = titulo;
          this.autor = autor;
          this.descricao_livro = descricao_livro;
          this.data_lancamento = data_lancamento;
          this.disponivel = true;
          this.categoria = categoria;

      }
    }




