package Count_Number_Of_File_WithName;

import java.io.File;
import java.util.Objects;

public class CountNumberOfFileWithName {
    public static void main(String[] args) {
        File directory = new File("path/to/directory"); // Replace with your directory path
        String searchText = "abc"; // Replace with your search text

        int count = 0;
        if (directory.exists() && directory.isDirectory()) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isFile() && file.getName().contains(searchText)) {
                    count++;
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }

        System.out.println("Number of files containing \"" + searchText + "\": " + count);
    }
}
