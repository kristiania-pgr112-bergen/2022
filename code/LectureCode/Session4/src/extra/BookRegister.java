package LectureCode.Session4.src.extra;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookRegister {
    private ArrayList<Book> books;
    private int numberOfBooks;

    public BookRegister() {
        this.books = new ArrayList<>();
        this.numberOfBooks = 0;
    }
    public void addBook(Book book) {
        books.add(book);
        numberOfBooks++;
    }
    public void deleteBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
            numberOfBooks--;
        }
    }

    /**
     *     Is there any simpler way of doing this?
      */

    public ArrayList<Book> getAllRegisteredBooks() {
        ArrayList<Book> result = new ArrayList<>();
        for(Book book: books) {
            result.add(book);
        }
        return result;
    }
    public ArrayList<Book> GetRegisteredBooksByGenre(Genre genre) {
        ArrayList<Book> result = new ArrayList<>();

        for(Book book: books) {
            if(book.getGenre() == genre) {
                result.add(book);
            }
        }
        return result;
        /**
         Is there another way of doing this?
         */
        /*
        return (ArrayList<Book>) books.stream()
                .filter(book -> book.getGenre()==genre)
                .collect(Collectors.toList());
                */

    }
}
