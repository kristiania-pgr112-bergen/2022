package LectureCode.Session6.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public void runExample()
    {
        String localDateStr1 = "2022-01-22";
        LocalDate localDate1 = LocalDate.parse(localDateStr1);
        System.out.println("String to LocalDate1 : " + localDate1);

        LocalDate localDate2 = LocalDate.now();
        String localDateStr2 = localDate2.format(DateTimeFormatter.ISO_DATE);
        System.out.println("LocalDate2 in string :  " + localDateStr2);

        LocalDate localDate3 = LocalDate.of(2020, 01, 22);
        String localDateStr3 = localDate3.format(DateTimeFormatter.ISO_DATE);
        System.out.println("LocalDate2 in string :  " + localDateStr3);
    }
}
