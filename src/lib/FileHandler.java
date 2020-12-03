package src.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private FileHandler() {
    }

    public static List<String> readByLine(int year, String[] pathSegments) {
        File file = new File("src" + File.separator + "adventofcode" + year + File.separator + String.join(File.separator, pathSegments));
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
