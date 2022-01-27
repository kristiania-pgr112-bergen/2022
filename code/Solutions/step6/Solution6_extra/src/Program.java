package Solutions.step6.Solution6_extra.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private ArrayList<Artist> artists;
    private String artistFileName;

    public Program() throws IOException {
        artists = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String dir= currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + dir);


        artistFileName = "ekstra.txt";
        readArtists(artists, new File(artistFileName));
        handleUserInteraction();
    }

    private void handleUserInteraction() throws IOException {
        System.out.println("Welcome!");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            printMenu();
            choice = input.nextInt();
            input.nextLine(); // swallowing CR
            switch (choice) {
                case 1 -> printAllArtists();
                case 2 -> printArtistById(input);
                case 3 -> addArtist(input);
                case 4 -> editArtist(input);
                case 5 -> sayGoodbye();
                default -> System.out.println("Your options are 1-5");
            }
        }
    }

    private void sayGoodbye() throws IOException {
        writeArtistTofile(artists, artistFileName);
        System.out.println("Bye!");
    }

    private void editArtist(Scanner input) {
        System.out.println("Enter artist id:");
        int id = input.nextInt();
        input.nextLine(); // swallowing CR
        Artist artistToEdit = getArtist(id);
        System.out.println("Enter new name: (Old=" + artistToEdit.getArtistName()+")");
        artistToEdit.setArtistName(input.nextLine());
        System.out.println("Enter new date of birth (yyyy-mm-dd): " +
                "(Old="+ artistToEdit.getDateOfBirth().toString() + ")");
        String dateString = input.nextLine();
        artistToEdit.setDateOfBirth(LocalDate.parse(dateString));
        System.out.println("Enter new city: (Old="+artistToEdit.getCity()+")");
        artistToEdit.setCity(input.nextLine());
        System.out.println("Enter new country: (Old="+artistToEdit.getCountry()+")");
        artistToEdit.setCountry(input.nextLine());
        System.out.println("Artist was updated");
    }

    private Artist getArtist(int id) {
        for (Artist a :
                artists) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    private void addArtist(Scanner input) {
        System.out.println("Enter artist id:");
        int id = input.nextInt();
        input.nextLine(); // swallowing CR
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter date of birth (yyyy-mm-dd):");
        String dateString = input.nextLine();
        LocalDate date = LocalDate.parse(dateString);
        System.out.println("Enter city:");
        String city = input.nextLine();
        System.out.println("Enter country:");
        String country = input.nextLine();
        artists.add(new Artist(id, name, date, city, country));
        System.out.println("Artist added");
    }

    private void printArtistById(Scanner input) {
        System.out.println("Enter id:");
        int id = input.nextInt();
        input.nextLine(); // swallowing CR
        getArtist(id).printState();
    }

    private void printAllArtists() {
        for (Artist a :
                artists) {
            a.printState();
        }
    }

    private void printMenu() {
        System.out.println("Your choices:");
        System.out.println("1: All artists");
        System.out.println("2: Artist by id");
        System.out.println("3: Add artist");
        System.out.println("4: Edit artist");
        System.out.println("5: Quit");
    }

    private void writeArtistTofile(ArrayList<Artist> artists, String fileName) throws IOException {
        System.out.println("Writing to file");
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i=0; i < artists.size(); i++) {
            fileWriter.write(artists.get(i).getId() + "\n");
            fileWriter.write(artists.get(i).getArtistName() + "\n");
            fileWriter.write(artists.get(i).getDateOfBirth().toString() + "\n");
            fileWriter.write(artists.get(i).getCity() + "\n");
            fileWriter.write(artists.get(i).getCountry() + "\n");
            fileWriter.write("---");
            if(i != artists.size() - 1){ //to avoid trailing CR in end of file
                fileWriter.write("\n");
            }
        }
        fileWriter.close();

    }

    private void readArtists(ArrayList<Artist> artists, File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()) {
            int id = fileReader.nextInt();
            fileReader.nextLine(); // swallowing CR
            String artistName = fileReader.nextLine();
            String dateString = fileReader.nextLine();
            LocalDate bDate = LocalDate.parse(dateString);
            String city = fileReader.nextLine();
            String country = fileReader.nextLine();
            artists.add(new Artist(id, artistName, bDate, city, country));
            fileReader.nextLine(); // reading ---
        }
    }
}
