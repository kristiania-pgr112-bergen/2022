package LectureCode.Session10.src.InnerExample;

/*class Java_Outer_class{
    private int data=30;
    class Java_Inner_class{
        void msg(){System.out.println("data is "+data);}
    }
}
public class Main {
    public static void main(String[] args) {
        Java_Outer_class outer = new Java_Outer_class();
        //syntax to instantiate inner class
        Java_Outer_class.Java_Inner_class inner = outer.new Java_Inner_class();
        inner.msg();
    }
}*/

/**
 * definiton of abstract anonymous inner class
 */
/*interface Person{
    void eat();
}
class Java_Anonymous_Outer_class {
    public static void main() {
        //implementation of abstract anonymous inner class
        Person p=new Person(){
            public void eat(){System.out.println("nice fruits");}
        };
        p.eat();
    }
}
public class Main {
    public static void main(String[] args) {
        Java_Anonymous_Outer_class.main();
    }
}*/

/*
abstract class Person{
    abstract void eat();
}
class Java_Anonymous_Outer_class {
    public static void main() {
        //implementation of abstract anonymous inner class
        Person p=new Person(){
            void eat(){System.out.println("nice fruits");}
        };
        p.eat();
    }
}
public class Main {
    public static void main(String[] args) {
        Java_Anonymous_Outer_class.main();
    }
}*/

class Java_Local_Inner_Class {
    private int data = 30;//instance variable
    void display() {
        class Local {
            void msg() {
                System.out.println(data);
            }
        }
        Local l = new Local();
        l.msg();
    }
}
public class Main {
    public static void main(String[] args) {
        Java_Local_Inner_Class java_local_inner_class = new Java_Local_Inner_Class();
        java_local_inner_class.display();
    }
}