package view;


import controller.Library_Tools;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryManegement_menu {
     private Library_Tools library;

    public LibraryManegement_menu(Library_Tools library) {
        this.library = library;
    }
    Scanner sc = new Scanner(System.in);
    
    public void printMenu() {
            System.out.println("Library Management");
            System.out.println("----------------------------");
            System.out.println("1. List all books");
            System.out.println("2. Book Search");
            System.out.println("3. Add new Book");
            System.out.println("4. Exit");
            System.out.println("----------------------------");
            System.out.println("Enter selection: ");
            int choice = sc.nextInt();
          
            switch (choice) {
                case 1:
                {
                    try {
                        library.readDataFromFile();
                    } catch (IOException ex) {
                        Logger.getLogger(LibraryManegement_menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case 2:
                    searchMenu();
                    break;
                case 3:
                    library.addBook();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
            
        }
            
    }
    public void searchMenu() {
        System.out.println("Book Searching");
        System.out.println("----------------------------");
        System.out.println("1. Find BookID");
        System.out.println("2. Find Book Title");
        System.out.println("3. Find by Author");
        System.out.println("4. Find by Year of publishing");
        System.out.println("----------------------------");
        System.out.println("Enter selection: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                 System.out.println("Enter BookID: ");
               String title = sc.nextLine();
               library.searchBookByID(title);
                break;
            case 2:
                 System.out.println("Enter BookTitle: ");
                 title = sc.nextLine();
               library.searchBookByTitle(title);
                break;
            case 3:
                 System.out.println("Enter Author's name: ");
               title = sc.nextLine();
               library.searchBookByauthor(title);
                break;
            case 4:
                 System.out.println("Enter year: ");
                 title = sc.nextLine();
               library.searchBookByYear(title);
                break;
        }
    }

}
