package Solutions.step3.Book.src;

public class Main {
    public static void main(String[] args) {
        BookRegister register = new BookRegister(20);

        Chapter[] hpChapters = new Chapter[3];
        hpChapters[0] = new Chapter("Chapter 1", 20, 2);
        hpChapters[1] = new Chapter("Chapter 2", 18, 2);
        hpChapters[2] = new Chapter("Chapter 3", 19, 2);

        Book book1 = new Book("Harry Potter 1",
                "J.K. Rowling", 400, Genre.FANTASY, hpChapters);
        register.addBook(book1);

        Chapter[] sultChapters = new Chapter[2];
        sultChapters[0] = new Chapter("Kapittel 1", 5, 3);
        sultChapters[1] = new Chapter("Kapittel 2", 7, 3);

        Book book2 = new Book("Sult",
                "Knut Hamsun", 115, Genre.CLASSIC, sultChapters);
        register.addBook(book2);

        System.out.println("Printing all books:");
        register.printAllBooks();
        System.out.println("Printing books by genre:");
        register.printBooksByGenre(Genre.FANTASY);
        System.out.println("Printing books by author:");
        register.printBooksByAuthor("J.K. Rowling");
    }
}
