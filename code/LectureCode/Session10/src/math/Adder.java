package LectureCode.Session10.src.math;

public class Adder {
/*    public void sum(int a, int b) {
        System.out.println("int arg method invoked");
        System.out.println(a+b);
    }*/
    public void sum(int a, int b, int c) {
        System.out.println("int arg method invoked");
        System.out.println(a+b+c);
    }
    public void sum(String a, String b) {
        System.out.println("string arg method invoked");
        System.out.println(a.concat(b));
    }
    public void sum (int a, long b) {
        System.out.println("int long arg method invoked");
        System.out.println(a+b);
    }
/*    public void sum (long a, int b) {
        System.out.println("long int arg method invoked");
        System.out.println(a+b);
    }*/
}
