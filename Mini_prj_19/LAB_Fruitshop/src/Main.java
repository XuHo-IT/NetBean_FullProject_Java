import Model.FruitManager;
import Model.OrderManager;
import View.Validation;

public class Main {
    public static void main(String[] args) {
        FruitManager manager = new FruitManager();
        OrderManager order = new OrderManager(manager);
        Validation validation = new Validation();
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int choice = validation.inputInt("Enter choice:", 1, 4);
            switch (choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    order.viewOrder();
                    break;
                case 3:
                   order.shopping(manager);
                    break;
                case 4:
                    return;
            }
        }
    }
}