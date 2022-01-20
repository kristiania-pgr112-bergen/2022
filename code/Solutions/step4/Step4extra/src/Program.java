package Solutions.step4.Step4extra.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private BookRegister register;

    public Program() {
        register = new BookRegister();
        handleUserInteraction();
    }

    private void handleUserInteraction() {
        System.out.println("Welcome to the book register. Here are your options:");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while(choice!=7){
            printMenu();
            choice = input.nextInt();
            input.nextLine(); //Swallowing line break
            switch (choice) {
                case 1 -> addBook(input);
                case 2 -> printAllBooks();
                case 3 -> printBooksByGenre(input);
                case 4 -> printBooksByMaxReadingTime(input);
                case 5 -> removeBook(input);
                case 6 -> printBooksByAuthor(input);
                case 7 -> quit();
                default -> System.out.println("Your options are 1-6");
            }
        }
    }

    private void printBooksByAuthor(Scanner input) {
        System.out.println("Enter author name:");
        String author = input.nextLine();
        register.printBooksByAuthor(author);
    }

    private void addBook(Scanner input) {
        System.out.println("Enter ISBN:");
        String isbn = input.nextLine();
        System.out.println("Enter title:");
        String title = input.nextLine();
        System.out.println("Enter author:");
        String author = input.nextLine();
        System.out.println("Enter number of pages:");
        int pages = input.nextInt();
        input.nextLine(); //Swallowing line break
        System.out.println("Enter genre (CRIME, ACTION, FANTASY, CLASSIC or OTHER):");
        String genreText = input.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreText);
        System.out.println("Enter reading time per page:");
        int readingTime = input.nextInt();
        input.nextLine(); //Swallowing line break
        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean moreChapters = true;
        while(moreChapters){
            System.out.println("Enter chapter title:");
            String cTitle = input.nextLine();
            System.out.println("Enter number of pages:");
            int cPages = input.nextInt();
            input.nextLine(); //Swallowing line break
            chapters.add(new Chapter(cTitle, cPages));
            System.out.println("Are there more chapters? (y/n)");
            moreChapters = input.nextLine().equalsIgnoreCase("y");
        }
        register.addBook(new Book(isbn, title, author, pages, genre, chapters, readingTime));
    }

    private void printAllBooks() {
        register.printAllBooks();
    }

    private void printBooksByGenre(Scanner input) {
        System.out.println("Enter genre (CRIME, ACTION, FANTASY, CLASSIC or OTHER):");
        String genre = input.next().toUpperCase();
        register.printBooksByGenre(Genre.valueOf(genre));
    }

    private void printBooksByMaxReadingTime(Scanner input) {
        System.out.println("Enter max reading time:");
        int max = input.nextInt();
        register.printBooksByMaxReadingTime(max);
    }

    private void removeBook(Scanner input) {
        System.out.println("Enter ISBN of book to remove:");
        String isbn = input.next();
        register.removeBook(isbn);
    }

    private void quit() {
        System.out.println("Thank you for using the book register. Bye!");
    }

    private void printMenu() {
        System.out.println("1: Add book");
        System.out.println("2: All books");
        System.out.println("3: Books by Genre");
        System.out.println("4: Books by maximum reading time");
        System.out.println("5: Remove book");
        System.out.println("6: Books by author");
        System.out.println("7: Quit");
    }


}
