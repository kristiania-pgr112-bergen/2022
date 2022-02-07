package LectureCode.Session9;

public class Languages {
    public static void main(String[] args) {
        English english = new English();

        printLanguageName(english);
    }

    public static void printLanguageName(AnyLanguage language) {
        language.printLanguageName();
    }

    public  static void compileLanguage(AnyLanguage language) {
        if (language instanceof ProgrammingLanguage) {
            ((ProgrammingLanguage) language).compile();
        }
        else {
            System.out.println("This is not a programming language!");
        }
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
        System.out.println("I should compile some code now!");
    }
}