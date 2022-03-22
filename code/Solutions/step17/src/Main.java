package Solutions.step17.src;


public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("name1", "nationality1");
        Author author2 = new Author("name2", "nationality2");

        Book book1 = new Book("book1", author1, 100, Genre.CLASSIC);
        Book book2 = new Book("book2", author1, 100, Genre.CRIME);
        Book book3 = new Book("book3", author2, 100, Genre.CRIME);

        JDBCOps jdbcOps = new JDBCOps();
        BookRegister bookRegister = new BookRegister(jdbcOps);
        System.out.println("add book1");
        bookRegister.addBook(book1);
        System.out.println("add book2");
        bookRegister.addBook(book2);
        System.out.println("add book3");
        bookRegister.addBook(book3);

        System.out.println("Get Registered Books for author1");
        bookRegister.GetRegisteredBooksByAuthor1(author1.getName());
        System.out.println("Get Registered Books for author2");
        bookRegister.GetRegisteredBooksByAuthor2(author2.getName());

        System.out.println("delete book1");
        bookRegister.deleteBook(book1);

        System.out.println("Get Registered Books for author1");
        bookRegister.GetRegisteredBooksByAuthor1(author1.getName());
        System.out.println("Get Registered Books for author2");
        bookRegister.GetRegisteredBooksByAuthor2(author2.getName());
    }
}
