package View;

import Control.StudentControl;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private StudentControl studentControl = new StudentControl();
    public  void  printMenu(){
        System.out.println("----------Hello-------- ");
        System.out.println("1. Display all books");
        System.out.println("2. Book Search");
        System.out.println("3. Add new Book");
        System.out.println("4. Books by the Same Author");
        System.out.println("5. Sort by Date Published");
        System.out.println("6. Exit");
        int choice = sc.nextInt();
        if(choice==1){
            studentControl.inputAddStudent();
        }

    }
}
