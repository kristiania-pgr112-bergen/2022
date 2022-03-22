package Solutions.step17.src;

import java.util.Objects;

public class Author {
    private String name;
    private String nationality;

    public Author() {
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return String.format("author name is %s, nationality is %s", name, nationality);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author))
            return false;
        if (o.getClass() != this.getClass())
            return false;
        /**
         * our own equality
         */
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(nationality, author.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }
}

