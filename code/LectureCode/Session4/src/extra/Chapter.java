package LectureCode.Session4.src.extra;

public class Chapter {
    private String title;
    private int pages;
    private int minutes;

    public Chapter(String title, int pages) {
        this.title = title;
        this.pages = pages;
        this.minutes = pages * 2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public  void printState(){
        System.out.println("title:"+title + ",pages:" + pages + ",minutes:"+minutes);
    }

}
