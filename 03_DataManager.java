import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Name");
            System.out.println("2. Remove Name");
            System.out.println("3. Display Names");
            System.out.println("4. Search Name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name to add: ");
                    String nameToAdd = scanner.nextLine();
                    names.add(nameToAdd);
                    System.out.println("Name added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    if (names.remove(nameToRemove)) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 3:
                    if (names.isEmpty()) {
                        System.out.println("No names in the list.");
                    } else {
                        System.out.println("Names in the list:");
                        for (String name : names) {
                            System.out.println(name);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    if (names.contains(nameToSearch)) {
                        System.out.println("Name found in the list.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
