package Controller;

import View.DisplayMenu;

public class BookingMenu extends DisplayMenu {
    public BookingMenu() {
        super(new String[]{"Add new booking","Display list Booking","Create new Contracts","Display list Contracts","Edit Contracts","Return main menu"});
    }
    public void display(){
        System.out.println("----EMPLOYEE MANAGEMENT-----");
        for (int i=0;i< options.length;i++){
            System.out.println((i+1)+"."+options[i]);
        }
    }
    public void handleChoice(int choice){
        switch (choice){
            case 1:
                System.out.println("Adding new booking");
                break;
            case 2:
                System.out.println("Displaying list Booking");
                break;
            case 3:
                System.out.println("Creating new Contracts");
                break;
            case 4:
                System.out.println("Displaying list Contracts");
                break;
            case 5:
                System.out.println("Editing Contracts");
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
