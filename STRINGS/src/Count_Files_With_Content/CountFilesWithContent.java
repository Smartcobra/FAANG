package Count_Files_With_Content;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class CountFilesWithContent {
    public static void main(String[] args) {
        File directory = new File("path/to/directory"); // Replace with your directory path
        String searchText = "abc"; // Replace with your search text

        int count = 0;
        if (directory.exists() && directory.isDirectory()) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isFile()) {
                    try {
                        String fileContent = new String(Files.readAllBytes(file.toPath()));
                        if (fileContent.contains(searchText)) {
                            count++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        System.out.println("Number of files containing \"" + searchText + "\": " + count);
    }
}
