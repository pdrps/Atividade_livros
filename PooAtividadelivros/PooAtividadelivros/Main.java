import DAO.AutorDAO;
import DAO.LivroDAO;
import Entity.Autor;
import Entity.Livro;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            AutorDAO autorDAO = new AutorDAO();
            LivroDAO livroDAO = new LivroDAO();


            Autor autor1 = new Autor();
            autor1.setNomeAutor("J.K. Rowling");
            autor1.setNacionalidade("Britânica");
            autorDAO.inserirAutor(autor1);

            Autor autor2 = new Autor();
            autor2.setNomeAutor("George R.R. Martin");
            autor2.setNacionalidade("Americana");
            autorDAO.inserirAutor(autor2);

            Livro livro1 = new Livro();
            livro1.setTitulo("Harry Potter e a Pedra Filosofal");
            livro1.setAnoPublicado(1997);
            livro1.setAutor(autor1);
            livroDAO.inserirLivro(livro1);

            Livro livro2 = new Livro();
            livro2.setTitulo("Harry Potter e a Câmara Secreta");
            livro2.setAnoPublicado(1998);
            livro2.setAutor(autor1);
            livroDAO.inserirLivro(livro2);

            Livro livro3 = new Livro();
            livro3.setTitulo("Harry Potter e o Prisioneiro de Azkaban");
            livro3.setAnoPublicado(1999);
            livro3.setAutor(autor1);
            livroDAO.inserirLivro(livro3);

            // Inserir 3 livros para o segundo autor
            Livro livro4 = new Livro();
            livro4.setTitulo("A Guerra dos Tronos");
            livro4.setAnoPublicado(1996);
            livro4.setAutor(autor2);
            livroDAO.inserirLivro(livro4);

            Livro livro5 = new Livro();
            livro5.setTitulo("A Fúria dos Reis");
            livro5.setAnoPublicado(1998);
            livro5.setAutor(autor2);
            livroDAO.inserirLivro(livro5);

            Livro livro6 = new Livro();
            livro6.setTitulo("A Tormenta de Espadas");
            livro6.setAnoPublicado(2000);
            livro6.setAutor(autor2);
            livroDAO.inserirLivro(livro6);

            List<Autor> autores = autorDAO.listarAutores();
            System.out.println("\nAutores:");
            for (Autor a : autores) {
                System.out.println(a.getIdAutor() + ": " + a.getNomeAutor() + " (" + a.getNacionalidade() + ")");
            }

            List<Livro> livros = livroDAO.listarLivros();
            System.out.println("\nTodos os livros:");
            for (Livro l : livros) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ") - Autor ID: " + l.getAutor().getIdAutor());
            }

            List<Livro> livrosDeAutor1 = livroDAO.listarLivrosDeAutor(autor1.getIdAutor());
            System.out.println("\nLivros do autor " + autor1.getNomeAutor() + ":");
            for (Livro l : livrosDeAutor1) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ")");
            }

            List<Livro> livrosDeAutor2 = livroDAO.listarLivrosDeAutor(autor2.getIdAutor());
            System.out.println("\nLivros do autor " + autor2.getNomeAutor() + ":");
            for (Livro l : livrosDeAutor2) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ")");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}