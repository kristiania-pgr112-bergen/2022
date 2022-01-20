package Solutions.step3.Book.src;
public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private Chapter[] chapters;

    public Book(String title, String author, int numberOfPages, Genre genre, Chapter[] chapters) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
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

    public void printState(){
        System.out.println("Title:" + title + ", Author:" + author
                + ", NrOfPages:"+numberOfPages + ", Genre:"+genre);
        System.out.println("Chapters:");
        for (Chapter c :
                chapters) {
            c.printChapterInformation();
        }
    }
}
