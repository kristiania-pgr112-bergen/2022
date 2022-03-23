package Solutions.step17.src;
import java.util.ArrayList;

public class Book {
    private String title;
    private Author author;
    private int numberOfPages = 1;
    private Genre genre;

    public Book() {
    }

    public Book(String title, Author author, int pages) {
        this.title = title;
        this.author = author;
        if (pages > 0) {
            this.numberOfPages = pages;
        }
        this.genre = Genre.OTHER;
    }

    public Book(String title, Author author, int pages, Genre genre) {
        this(title, author, pages);
        this.genre = genre;
    }



    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
       return String.format("Book has below features: title is %s, author is %s, pages is %d, Genre is %s ", title, author, numberOfPages, genre);

    }

}
