package LectureCode.Session6.src;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {
    public void WriteToFile() throws IOException {
        FileWriter writer = new FileWriter(
                "C:\\Users\\abc.txt");
        writer.write("This is a test");
        writer.close();
    }
}
