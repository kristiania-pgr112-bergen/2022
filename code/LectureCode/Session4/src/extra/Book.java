package LectureCode.Session4.src.extra;

import java.util.ArrayList;
import java.util.Optional;

public class Book {
    private String title;
    private String author;
    /**
     * default value
     */
    private int numberOfPages = 1;
    private Genre genre;
    private ArrayList<Chapter> chapters;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        if (pages > 0) {
            this.numberOfPages = pages;
        }
        this.genre = Genre.OTHER;
    }

    public Book(String title, String author, int pages, Genre genre) {
        this(title, author, pages);
        this.genre = genre;
    }

    public Book(String title, String author, int pages,ArrayList<Chapter> chapters) {
        /**
         *  can we call this()? no. because if we have defined constructor, the default constructor is ignored.
          */
        this(title, author, pages);
        this.chapters = chapters;
    }



    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void printState(){
        System.out.println("title:"+title + ", Author:" + author
        + ", NumberOfPages:" + numberOfPages + ", Genre:" + genre + ", Category:" + genre.getModifiedName() + ", Category Index:" + Genre.valueOf(genre.toString()).ordinal());
        // to avoid NullPointerException method 1
        if(chapters!=null && !chapters.isEmpty()) {
            System.out.println("Chapters:");
            for(Chapter c:
                    chapters) {
                c.printState();
            }
        }

        /**
         *  to avoid NullPointerException method 2
          */
        for(Chapter c:
                Optional.ofNullable(chapters).orElse(new ArrayList<>())) {
            c.printState();
        }
    }
}
