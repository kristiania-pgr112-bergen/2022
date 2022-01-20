package Solutions.step4.Step4extra.src;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private ArrayList<Chapter> chapters;
    private int minutesPerPage;

    public Book(String isbn, String title, String author, int numberOfPages,
                Genre genre, ArrayList<Chapter> chapters, int minutesPerPage) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.chapters = chapters;
        this.minutesPerPage = minutesPerPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
    }

    public void printState(){
        System.out.println("ISBN:" + isbn +  ", title:" + title + ", Author:" + author
                + ", NrOfPages:"+numberOfPages + ", Genre:"+genre + ", minsPerPage:" + minutesPerPage);
        System.out.println("Chapters:");
        for (Chapter c :
                chapters) {
            c.printChapterInformation();
        }
        System.out.println("---------------------------");
    }

    public int getReadingTime() {
        return getNumberOfPages()*getMinutesPerPage();
    }
}
