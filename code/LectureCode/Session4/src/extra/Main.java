package LectureCode.Session4.src.extra;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Chapter> chapters1 = new ArrayList<>();
        Chapter chapter1 = new Chapter("chapter1", 20);
        Chapter chapter2 = new Chapter("chapter2", 50);
        chapters1.add(chapter1);
        chapters1.add(chapter2);
        Book book1 = new Book("book1", "author1", 100, chapters1);
        Book book2 = new Book("book1", "author1", 100, Genre.CRIME);
        Book book3 = new Book("book3", "author1", 100, Genre.CRIME);

        BookRegister bookRegister = new BookRegister();
        bookRegister.addBook(book1);
        bookRegister.addBook(book2);
        bookRegister.addBook(book3);
        ArrayList<Book> books = bookRegister.GetRegisteredBooksByGenre(Genre.CRIME);
        for(Book book: books) {
            book.printState();
        }
    }

}
