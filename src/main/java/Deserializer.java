import java.io.*;
import java.nio.file.*;

public class Deserializer {
    public static String deserializeFromCSV(String filename) throws IOException {

        Path path = Paths.get(filename);

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        return line;
    }
}
