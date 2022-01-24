package LectureCode.Session6.src;

class MyCustomException extends Exception
{
    public MyCustomException(String s) {
        super(s);
    }
}
public class CustomExample {
    public void runExample1(String ssn) {
        try{
            if(ssn.length()!=11) {
                throw new MyCustomException("A valid " +
                        "ssn must be 11 digits!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
