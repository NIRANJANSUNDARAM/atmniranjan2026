package library;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.viewBooks();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
           
        }
    }
}
