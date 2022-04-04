package Solutions.step20.src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("name1", "nationality1");
        Author author2 = new Author("name2", "nationality2");

        Book book1 = new Book("book1", author1, 100, Genre.CLASSIC);
        Book book2 = new Book("book2", author1, 100, Genre.CRIME);
        Book book3 = new Book("book3", author2, 100, Genre.CRIME);

        JDBCOps jdbcOps = new JDBCOps();
        jdbcOps.createTable();

        System.out.println("register author1");
        jdbcOps.registerAuthor(author1);

        System.out.println("add book1");
        jdbcOps.addBook(book1);
        System.out.println("add book2");
        jdbcOps.addBook(book2);
        System.out.println("add book3");
        jdbcOps.addBook(book3);

        ArrayList<Author> authors = jdbcOps.getAuthors();
        authors.forEach(author -> System.out.println(author));
        ArrayList<Book> books = jdbcOps.getBooks();
        books.forEach(book -> System.out.println(book));
    }
}
