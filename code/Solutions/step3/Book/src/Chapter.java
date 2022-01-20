package Solutions.step3.Book.src;
public class Chapter {
    private String title;
    private int numberOfPages;
    private int minutesPerPage;

    public Chapter(String title, int numberOfPages, int minutesPerPage) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.minutesPerPage = minutesPerPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
    }

    public void printChapterInformation(){
        System.out.println("Title:" + title + ", Pages:" + numberOfPages + ", minutes:"+minutesPerPage);
    }
}
