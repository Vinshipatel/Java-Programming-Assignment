import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            BufferedReader br =
                    new BufferedReader(new FileReader(fileName));

            HashMap<String, Integer> count = new HashMap<>();

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();

                    count.put(word,
                            count.getOrDefault(word, 0) + 1);
                }
            }

            br.close();

            System.out.println("\nWord Occurrences:");
            for (String word : count.keySet()) {
                System.out.println(word + " = " + count.get(word));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}