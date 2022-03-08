package LectureCode.Session14.src;

public class MethodReferenceExample {
    static int width = 10;
    public static void drawSomething(){
        System.out.println("Drawing "+width);
    }
    public void drawSomething2(){
        System.out.println("Drawing "+width);
    }
    public static void run() {

        /**
         * with lambda. We don’t need to define the method for providing the implementation.
         * We just write implementation code. Why? because the functional interface has only one method
         */
        Drawable drawable = MethodReferenceExample::drawSomething;
        drawable.draw();

        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        Drawable drawable2 = methodReferenceExample::drawSomething2;
        drawable2.draw();
    }
}
