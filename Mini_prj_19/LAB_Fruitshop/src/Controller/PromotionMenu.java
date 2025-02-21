package Controller;

import View.DisplayMenu;

public class PromotionMenu extends DisplayMenu {
    public PromotionMenu() {
        super(new String[]{"Display list customer use service","Display list customer get voucher","Return main menu"});
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
                System.out.println("Displaying list customer use service");
                break;
            case 2:
                System.out.println("Displaying list customer get voucher");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
