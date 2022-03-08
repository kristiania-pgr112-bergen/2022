package LectureCode.Session14.src;


public class Main {
    public static void main(String[] args) {
/*        TrywithResourceExample trywithResourceExample = new TrywithResourceExample();
        trywithResourceExample.runExample2();*/
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.run();
        LambdaExample2 lambdaExample2 = new LambdaExample2();
        lambdaExample2.run();
        LambdaExample3 lambdaExample3 = new LambdaExample3();
        lambdaExample3.run();
        LambdaExample4 lambdaExample4 = new LambdaExample4();
        lambdaExample4.run();

        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        methodReferenceExample.drawSomething2();
        MethodReferenceExample.drawSomething();

        OptionalExample optionalExample = new OptionalExample();
        optionalExample.run();
    }
}
