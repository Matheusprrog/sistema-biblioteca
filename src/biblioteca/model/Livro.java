package biblioteca.model;
import biblioteca.enums.Categoria;


    public class Livro {

        public     String autor;
        public     String descricaoLivro;
        public    String dataLancamento;
        public   String titulo;
        public   boolean disponivel;
        public   Categoria categoria;
        public   int id;

      public Livro(int id,String titulo, String autor, String descricaoLivro, String dataLancamento, boolean disponivel, Categoria categoria){

          this.id =id;
          this.titulo = titulo;
          this.autor = autor;
          this.descricaoLivro = descricaoLivro;
          this.dataLancamento = dataLancamento;
          this.disponivel = true;
          this.categoria = categoria;

      }
    }