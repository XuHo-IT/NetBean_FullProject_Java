package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;


public class Library_Tools {
   private final ArrayList<Book> library = new ArrayList<>();
   private final  Scanner sc = new Scanner(System.in);
  
      public void readDataFromFile() throws IOException {
    String url = "C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\LAB6\\src\\main\\java\\model\\lib.txt";
    try (FileInputStream fileInputStream = new FileInputStream(url);
         Scanner fileScanner = new Scanner(fileInputStream)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] bookInfo = line.split(":");
            if (bookInfo.length == 4) {
                String id = bookInfo[0];
                String title = bookInfo[1];
                String author = bookInfo[2];
                int year = Integer.parseInt(bookInfo[3]);
                Book newBook = new Book(id, title, author, year);
                library.add(newBook);
            } else {
                System.out.println("Invalid data format: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    for (Book book : library) {
        System.out.println(book);
    }
}
  public void searchBookByTitle(String title) {
      
    boolean bookFound = false;
    for (Book book : library) {
        if (book.getBook_tittle().contains(title)) {
            System.out.println(book);
            bookFound = true; 
        }
    }
    if (!bookFound) {
        System.out.println("No information for book with Title: " + title);
    }
    
}
     public void searchBookByauthor(String title) {
    boolean bookFound = false; 
    for (Book book : library) {
     if (book.getBook_author().equalsIgnoreCase(title)) {
            System.out.println(book);
            bookFound = true;
        }
    }
    
    if (!bookFound) {
        System.out.println("No information for book with Author's name: " + title);
    }
}
   public void searchBookByID(String title) {
    boolean bookFound = false; 
    for (Book book : library) {
        if (book.getIsbn().equalsIgnoreCase(title)) {
            System.out.println(book);
            bookFound = true;
        }
    }
    
    if (!bookFound) {
        System.out.println("No information for book with ID: " + title);
    }
}
    public void searchBookByYear(String title) {
    boolean bookFound = false; 
    for (Book book : library) {
       if (Integer.toString(book.getYear_of_publication()).equalsIgnoreCase(title)) {
            System.out.println(book);
            bookFound = true;
        }
    }
    if (!bookFound) {
        System.out.println("No information for book with year: " + title);
    }
}

   public void addBook() {
    System.out.println("Enter number of books: ");
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 1; i <= n; i++) {
        System.out.println("Enter BookID: ");
        String isbn = sc.nextLine();
        System.out.println("Enter Title: ");
        String bookTitle = sc.nextLine();
        System.out.println("Enter Author: ");
        String name = sc.nextLine();
        System.out.println("Enter Year of public: ");
        int year = sc.nextInt();
        sc.nextLine();
        Book newbook = new Book(isbn, bookTitle, name, year);
        library.add(newbook);
    }
    try {
        readDataFromFile();
    } catch (IOException ex) {
        Logger.getLogger(Library_Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}
