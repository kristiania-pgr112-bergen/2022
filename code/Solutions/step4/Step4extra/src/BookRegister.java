package Solutions.step4.Step4extra.src;
import java.util.ArrayList;

public class BookRegister {
    private ArrayList<Book> books;

    public BookRegister() {
        books = new ArrayList<>();
        initializeRegister();
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void printBooksByGenre(Genre genre){
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getGenre() == genre) {
                b.printState();
            }
        }
    }

    public void printAllBooks() {
        for (Book b :
                books) {
            b.printState();
        }
    }

    public void printBooksByAuthor(String author){
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().equalsIgnoreCase(author)) {
                b.printState();
            }
        }
    }

    public void removeBook(String isbn) {
        for (Book b :
                books) {
            if(b.getIsbn().equalsIgnoreCase(isbn)){
                books.remove(b);
                break;
            }
        }
    }

    public void printBooksByMaxReadingTime(int max) {
        for (Book b :
                books) {
            if(b.getReadingTime()<=max){
                b.printState();
            }
        }
    }

    private void initializeRegister() {
        ArrayList<Chapter> hpChapters = new ArrayList<>();
        hpChapters.add(new Chapter("Chapter 1", 20));
        hpChapters.add(new Chapter("Chapter 2", 18));
        hpChapters.add(new Chapter("Chapter 3", 19));

        Book book1 = new Book("1234567", "Harry Potter 1",
                "J.K. Rowling", 400, Genre.FANTASY, hpChapters, 3);
        addBook(book1);

        ArrayList<Chapter> sultChapters = new ArrayList<>();
        sultChapters.add(new Chapter("Kapittel 1", 5));
        sultChapters.add(new Chapter("Kapittel 2", 7));

        Book book2 = new Book("2345678", "Sult",
                "Knut Hamsun", 115, Genre.CLASSIC, sultChapters, 2);
        addBook(book2);
    }
}
