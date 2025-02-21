package view;

import controller.DisplayMenu;

import java.util.Scanner;

public class MainMenu extends DisplayMenu {
    private DisplayMenu[] subMenu;

    public MainMenu(String[] options, DisplayMenu[] subMenu) {
        super(options);
        this.subMenu = subMenu;
    }
    public void display(){
        System.out.println("----MAIN MENU-----");
        for (int i=0;i< options.length;i++){
            System.out.println((i+1)+"."+options[i]);
        }
    }
    public void handleChoice(int choice){
        if (choice>=1 && choice <= options.length){
            if (choice == options.length){
                System.out.println("Exiting program...");
                return;
            }
            subMenu[choice-1].display();
            Scanner sc = new Scanner(System.in);
            int subChoice;
            do{
                System.out.println("Enter your choice: ");
                subChoice=sc.nextInt();
                subMenu[choice-1].handleChoice(subChoice);
            } while (subChoice !=subMenu[choice-1].options.length);
            sc.close();
        }else{
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
