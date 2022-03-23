package Solutions.step17.src;

public class AuthorRecord {
    private int tableId;
    Author author;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AuthorRecord(int tableId, Author author) {
        this.tableId = tableId;
        this.author = author;
    }



}
