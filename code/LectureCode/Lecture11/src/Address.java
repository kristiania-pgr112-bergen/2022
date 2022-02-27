package LectureCode.Lecture11.src;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private String street;
    private String postcode;

    public Address(String street, String postcode) {
        this.street = street;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return String.format("street:%s, postcode:%s", street, postcode);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address))
            return false;
        // type check and cast
        if (this.getClass() != o.getClass())
            return false;
        Address other = (Address) o;
        return Objects.equals(street, other.street)
                && Objects.equals(postcode, other.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postcode);
    }
}
