package Solutions.step6.Solution6.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private void readArtists(ArrayList<Artist> artists, File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        while(fileReader.hasNextLine()){
            String artistName = fileReader.nextLine();
            String dateString = fileReader.nextLine();
            LocalDate bDate = LocalDate.parse(dateString);
            String city = fileReader.nextLine();
            String country = fileReader.nextLine();
            Artist artist = new Artist(artistName, bDate, city, country);
            artists.add(artist);
            fileReader.nextLine(); // reading ---
        }
        fileReader.close();
    }

    public void oppgave4() throws FileNotFoundException {
        File file = new File("opg4.txt");
        Scanner fileReader = new Scanner(file);
        System.out.println("Reading content in file opg4.txt");
        while(fileReader.hasNextLine()){
            System.out.println(fileReader.nextLine());
        }
        fileReader.close();
        System.out.println("Done reading opg4.txt");
    }

    public void oppgave5() throws IOException {
        File file = new File("opg5.txt");
        file.createNewFile();
        Scanner input = new Scanner(System.in);
        FileWriter writer = new FileWriter(file);
        System.out.println("Writing user content to opg5.txt");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter some text:");
            String s = input.nextLine();
            writer.write(s);
            writer.write("\n");
        }
        writer.close();
        System.out.println("Done writing user content to opg5.txt");
    }

    public void oppgave7() throws FileNotFoundException {
        ArrayList<Artist> artists = new ArrayList<>();
        File file = new File("opg7.txt");
        System.out.println("Reading from opg7.txt");
        readArtists(artists, file);
        System.out.println("Printing artists:");
        for (Artist a :
                artists) {
            a.printState();
        }
        System.out.println("Done printing artists");
    }

    public void oppgave8() throws IOException {
        ArrayList<Artist> artists = new ArrayList<>();
        File file = new File("opg7.txt");
        System.out.println("Reading from opg7.txt");
        readArtists(artists, file);
        System.out.println("Changing some artist fields");
        Artist a0 = artists.get(0);
        a0.setArtistName("Prince (The symbol)");
        artists.get(1).setDateOfBirth(LocalDate.of(1997, 8,24));
        artists.get(2).setCity("Stavanger");
        artists.get(3).setCountry("Storbritannia");
        System.out.println("Writing artists to opg8.txt");
        writeArtistTofile(artists, "opg8.txt");
    }

    private void writeArtistTofile(ArrayList<Artist> artists, String fileName) throws IOException {
        System.out.println("Writing to file");
        File file = new File(fileName);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < artists.size(); i++) {
            fileWriter.write(artists.get(i).getArtistName()+"\n");
            fileWriter.write(artists.get(i).getDateOfBirth().toString()+"\n");
            fileWriter.write(artists.get(i).getCity()+"\n");
            fileWriter.write(artists.get(i).getCountry()+"\n");
            fileWriter.write("---");
            if(i != artists.size() - 1){ // to avoid CR in end of file
                fileWriter.write("\n");
            }
        }
        fileWriter.close();

    }



}
