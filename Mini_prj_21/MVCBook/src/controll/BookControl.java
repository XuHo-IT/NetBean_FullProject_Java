package controll;
import model.Book;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookControl {
    private ArrayList<Book> newBook = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void listOfBook(){
        String url = "C:\\Users\\ADMIN\\IdeaProjects\\readfileFPTstudent\\src\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(url);

        Scanner sc = new Scanner(fileInputStream);
        sc.nextLine();
        while (sc.hasNextLine()){
            String[] listBooks= sc.nextLine().split(";");
            listBooks[2] = listStudents[2].substring(0, listStudents[2].length() );
            listBooks[4] = listStudents[4].substring(0, listStudents[4].length() );
            Book newBook = new Book(listStudents[0], listStudents[1], Integer.parseInt(listStudents[2]), listStudents[3], Double.parseDouble(listStudents[4]));
            Collections.sort(list);
        }
        for (Book newBooks: newBook){
            System.out.println(newBooks);
        }
    }

}
