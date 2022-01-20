package Solutions.step3.BookBasic.src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating book - HP1");
        Book hp = new Book("Harry Potter 1",
                "J.K. Rowling", 400, Genre.FANTASY);

        System.out.println("Creating book - Sult");
        Book sult = new Book("Sult",
                "Knut Hamsun", 115, Genre.ACTION);

        System.out.println("Printing books after creation:");
        hp.printState();
        sult.printState();

        System.out.println("Changing HP book nrOfPages to 432");
        hp.setNumberOfPages(432);
        System.out.println("Changing Sult genre to classic");
        sult.setGenre(Genre.CLASSIC);

        System.out.println("Books status after changes");
        hp.printState();
        sult.printState();

        // I may also retrieve specific field values through getters. Example:
        System.out.println("Retrieving Sult author:");
        System.out.println(sult.getAuthor());
        System.out.println("Retrieving HP genre:");
        System.out.println(hp.getAuthor());

        // But as we follow the principle of encapsulation, I may not get or set the fields directly:
        //String hpAuthor = hp.author;
        //hp.numberOfPages = 123;
        // You may try by removing the comments in the two lines above. Won't work:)

    }
}
