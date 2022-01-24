package LectureCode.Session6.src;

public class CallStackExample {
    private void helperMethod2() {
        System.out.println("In helperMethod2");
        int i = 10/0;
        System.out.println("i:"+i);
        System.out.println("helperMethod2 done");
    }
    private void helperMethod1() {
        System.out.println("In helperMethod1");
        helperMethod2();
        System.out.println("helperMethod1 done");
    }
    public void runExample(){
        try{
            //statement that might cause exception
            helperMethod1();
        }
        catch (NullPointerException e){
            //statement that handles exception
            System.out.println("It is NullPointerException");
        } catch (ArithmeticException e) {
            // we can have multiple catch blocks
            System.out.println("It is ArithmeticException");
        }
    }
}


/*        String s = null;
        System.out.println(s.length());*/