package Solutions.step3.Book.src;
public class BookRegister {
    private Book[] books;
    int numberOfRegisteredBooks;

    public BookRegister(int maxNumberOfBooks) {
        books = new Book[maxNumberOfBooks];
        numberOfRegisteredBooks = 0;
    }

    public void addBook(Book b){
        books[numberOfRegisteredBooks] = b;
        numberOfRegisteredBooks++;
    }

    public void printBooksByGenre(Genre genre){
        for (int i = 0; i < numberOfRegisteredBooks; i++) {
            Book b = books[i];
            if (b.getGenre() == genre) {
                b.printState();
            }
        }
    }

    public void printAllBooks() {
        for (int i = 0; i < numberOfRegisteredBooks; i++) {
            books[i].printState();
        }
    }

    public void printBooksByAuthor(String author){
        for (int i = 0; i < numberOfRegisteredBooks; i++) {
            Book b = books[i];
            if (b.getAuthor().equalsIgnoreCase(author)) {
                b.printState();
            }
        }
    }
}
