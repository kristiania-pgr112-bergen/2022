package LectureCode.Session14.test;

import LectureCode.Lecture11.src.Address;
import LectureCode.Lecture11.src.Person;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateInputTest {

    /**
     * validate condition
     * @param person
     * @return
     */
    public boolean ageIsValid(Person person) {
        boolean isvalid = false;

        if (person != null
                && (person.getAge() >= 10
                && person.getAge() <= 15)) {
            isvalid = true;
        }
        return isvalid;
    }
    public boolean ageIsValid2(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getAge)
                .filter(a -> a >= 10)
                .filter(a -> a <= 15)
                .isPresent();
    }

    /**
     * validate null
     * @param fromDest
     * @param toDest
     * @param departDate
     * @return
     */
    public boolean inputIsNotNull(String fromDest, String toDest, String departDate) {
        /**
         *         validate some inputs: fromDest, toDest, departDate
         */
        if (fromDest == null || toDest == null || departDate == null) {
            String msg = String.format("You have provided the following arguments, none of them can be null. " +
                    "fromDest: %s, toDest: %s, date: %s", fromDest, toDest, departDate);
            throw new NullPointerException(msg);
        }
        return true;
    }
    public boolean isNotValidString(String s) {
        return s == null || s.trim().isEmpty();
    }
    public boolean inputIsNotNull2(String fromDest, String toDest, String departDate) {
        /**
         *         validate some inputs: fromDest, toDest, departDate
         */
        if (isNotValidString(fromDest) || isNotValidString(toDest) || isNotValidString(departDate)) {
            String msg = String.format("You have provided the following arguments, none of them can be null. " +
                    "fromDest: %s, toDest: %s, date: %s", fromDest, toDest, departDate);
            throw new NullPointerException(msg);
        }
        return true;
    }

    /**
     * comparison order
     * @param fromDest
     * @param toDest
     * @param departDate
     * @return
     */

    private boolean dateIsValid(String fromDest, String toDest, String departDate) {
        /**
         * we want the departDate to be later than today
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(departDate.compareTo(dateFormat.format(new Date()))<0) {
            String msg = String.format("You have provided illegal departDate." );
            throw new IllegalArgumentException(msg);
        }
        return true;
    }

    @Test
    public void validateAgeIsvalid_thenCorrect() {

        assertTrue(ageIsValid(new Person(12, "Tom", new Address("street1", "5000"))));
        assertFalse(ageIsValid2(new Person(20, "Jerry", new Address("street2", "3330"))));
        assertFalse(ageIsValid2(null));
    }
    @Test
    public void validateInputIsNotNull_thenCorrect() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        assertTrue(inputIsNotNull("Bergen", "Oslo", dateFormat.format(new Date())));
    }
    @Test
    public void validateInputIsNotNull2_thenCorrect() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        assertTrue(inputIsNotNull2("Bergen", "Oslo", dateFormat.format(new Date())));
    }

    @Test
    public void validateInputDateIsValid_theCorrect(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        assertTrue(dateIsValid("Bergen", "Oslo", dateFormat.format(new Date())));
    }
    @Test
    public void validateInputDateIsValid_thenThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            dateIsValid("Bergen", "Oslo", dateFormat.format(cal.getTime()));
        });

    }

}
