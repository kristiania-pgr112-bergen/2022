package Solutions.step4.Step4extra.src;
public class Chapter {
    private String title;
    private int numberOfPages;

    public Chapter(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
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

    public void printChapterInformation(){
        System.out.println("Title:" + title + ", Pages:" + numberOfPages);
    }
}
