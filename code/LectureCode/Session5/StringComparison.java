package LectureCode.Session5;

public class StringComparison {
    public static void main(String[] args) {
        String A = "String";
        String B = "String";
        String C = new String("String");

        if (A == B) {
            System.out.println("A == B");
        }

        if (A == C) {
            System.out.println("A == C");
        }
    }
}
