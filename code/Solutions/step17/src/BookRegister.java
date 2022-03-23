package Solutions.step17.src;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRegister {
    private JDBCOps jdbcOps;

    public BookRegister(JDBCOps jdbcOps) {
        this.jdbcOps = jdbcOps;
    }
    public void addBook(Book book) {
        try {
            jdbcOps.addBook(book);
            ArrayList<Book> books = jdbcOps.getBooks();
            books.forEach(book1 -> System.out.println(book1));

            ArrayList<AuthorRecord> authorRecords = jdbcOps.getAuthors();
            List<Author> authors = authorRecords.stream().map(authorRecord -> authorRecord.getAuthor()).collect(Collectors.toList());
            authors.forEach(author -> System.out.println(author));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(Book book) {
        if(jdbcOps.getBooks().size()==0) return;
        try {
            jdbcOps.deleteBook(book);
            ArrayList<Book> books = jdbcOps.getBooks();
            books.forEach(book1 -> System.out.println(book1));

            ArrayList<AuthorRecord> authorRecords = jdbcOps.getAuthors();
            List<Author> authors = authorRecords.stream().map(authorRecord -> authorRecord.getAuthor()).collect(Collectors.toList());
            authors.forEach(author -> System.out.println(author));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GetRegisteredBooksByAuthor1(String author) {
        ArrayList<Book> books = new ArrayList<>();
        List<Book> filteredBooks = jdbcOps.getBooks().stream()
                .filter(book -> book.getAuthor().getName().equals(author))
                .collect(Collectors.toList());
        books.addAll(filteredBooks);
        books.forEach(book1 -> System.out.println(book1));
    }

    public void GetRegisteredBooksByAuthor2(String author) {
        ArrayList<Book> books =  jdbcOps.getBooksByAuthor(author);
        books.forEach(book1 -> System.out.println(book1));
    }
}
