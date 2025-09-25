import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int itemCount = 0;
        List<String> itemList = new ArrayList<>();

        try {
            System.out.print("How many items do you wanna enter? ");
            itemCount = Integer.parseInt(scanner.nextLine());

            if (itemCount <= 0) {
                System.out.println("You gotta enter a positive number.");
                return;
            }

            for (int i = 0; i < itemCount; i++) {
                System.out.print("Enter item " + (i + 1) + ": ");
                String input = scanner.nextLine();
                itemList.add(input);
            }

            saveListToFile(itemList, "lab1_output.txt");

            System.out.println("Here are the items you typed in:");
            for (String item : itemList) {
                System.out.println("- " + item);
            }

            int totalChars = getTotalLength(itemList);
            System.out.println("All your items combined have this many characters: " + totalChars);

        } catch (NumberFormatException e) {
            System.out.println("Oops! Please enter a valid number.");
        } catch (IOException e) {
            System.out.println("Problem saving the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    public static void saveListToFile(List<String> list, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String item : list) {
                writer.write(item + System.lineSeparator());
            }
        }
    }
    public static int getTotalLength(List<String> list) {
        int length = 0;
        for (String str : list) {
            length += str.length();
        }
        return length;
    }
}
