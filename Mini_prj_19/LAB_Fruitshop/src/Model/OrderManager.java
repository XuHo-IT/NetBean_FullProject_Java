package Model;

import View.Validation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
public class  OrderManager extends FruitManager {

    List<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    Validation validation = new Validation();

    public OrderManager(List<Fruit> fruits, Hashtable<String, ArrayList<Fruit>> orders, Validation validation) {
        this.fruits = fruits;
        this.orders = orders;
        this.validation = validation;
    }

    public OrderManager( FruitManager fruit) {
        super();
        setListOfFruit(fruit.getListOfFruit());
    }

    public Fruit checkFruitInOrder(ArrayList<Fruit> listOrder, String id) {
        for (Fruit fruit : listOrder) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void shopping(FruitManager fruits) {
        ArrayList<Fruit> listOrder = new ArrayList<>();
        while (true) {
            int item = fruits.displayListFruit();
            if (item == -1) {
                System.out.println("Out of stock.");
                return;
            }
            Fruit fruit = fruits.getFruit(item);
            System.out.println("You selected:" + fruit.getName());
            int quantity = validation.inputInt("Enter quantity:", 0, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            Fruit fruitInOrder = checkFruitInOrder(listOrder, fruit.getFruitId());
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantity);
            } else {
                if (quantity != 0) {
                    listOrder.add(new Fruit(fruit.getFruitId(), fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin()));
                }

            }
            if (!validation.checkInputYN("Do you want to continue?(Y/N)")) {
                break;
            }
        }
        if (listOrder.isEmpty()) {
            System.out.println("No orders");
        } else {
            displayListOrder(listOrder);
            String name = setName();
            orders.put(name, listOrder);
        }

    }
    public String setName() {
        String name = validation.inputString("Enter name:", "[A-Za-z\\s]+");
        int count = 0;
        for (String name_key : orders.keySet()) {
            String real_name = name_key.split("#")[0];
            if (name.equals(real_name)) {
                count++;
            }
        }
        return name + "#" + count;
    }

    public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", fruit.getName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void viewOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        for (String name : orders.keySet()) {
            System.out.println("Customer: " + name.split("#")[0]);
            ArrayList<Fruit> listOrder = orders.get(name);
            displayListOrder(listOrder);
        }

    }


}