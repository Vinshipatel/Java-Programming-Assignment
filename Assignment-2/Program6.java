import java.io.*;
import java.util.*;

public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Display All Files of a Directory");
        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File directory = new File(path);

        // Check whether path exists
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Check whether it is a directory
        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        // Get all files and folders
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Directory is empty.");
            return;
        }

        System.out.println("\nFiles and Folders inside directory:");

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Folder: " + file.getName());
            }
        }
    }
}