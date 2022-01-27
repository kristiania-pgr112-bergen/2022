package Solutions.step6.Solution6_extra.src;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Artist {
    private int id;
    private String artistName;
    private LocalDate dateOfBirth;
    private String city;
    private String country;

    public Artist(int id, String artistName, LocalDate dateOfBirth, String city, String country) {
        this.id = id;
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.country = country;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printState() {
        System.out.println("Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", age=" + getAge() +
                ", next birthday in " + daysUntilBirthday() + " days" +
                '}');
    }

    private long daysUntilBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = getDateOfBirth();
        LocalDate nextBDay = birthday.withYear(today.getYear());

        if(nextBDay.isEqual(today)){
            return 0;
        }

        //If the birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
        return ChronoUnit.DAYS.between(today, nextBDay);
    }

    private int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
}
