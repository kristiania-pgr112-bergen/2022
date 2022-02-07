package LectureCode.Session9;

public class Languages {
    public static void main(String[] args) {

    }
}

interface Language {
    void printLanguageName();
}

interface ProgrammingLanguage {
    void compile();
}

abstract class AnyLanguage implements Language {
    String name;

    AnyLanguage(String name) {
        this.name = name;
    }

    public void printLanguageName() {
        System.out.println(this.name);
    }
}

class English extends AnyLanguage {
    English() {
        super("English");
    }
}

class Java extends AnyLanguage implements ProgrammingLanguage {
    Java() {
        super("Java");
    }

    public void compile() {
        //
    }
}