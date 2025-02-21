package Model;

import Data.FileManager;
import View.Validation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FruitManager extends Fruit {
    ArrayList<Fruit> listOfFruit = new ArrayList<>();
    Validation val;
    FileManager f;
    FruitManager fruitManager;
    List<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    Validation validation = new Validation();

    public FruitManager(String fruitId, String name, double price, int quantity, String origin, ArrayList<Fruit> listOfFruit, Validation val, FileManager f) {
        super(fruitId, name, price, quantity, origin);
        this.listOfFruit = listOfFruit;
        this.val = val;
        this.f = f;
    }

    public ArrayList<Fruit> getListOfFruit() {
        return listOfFruit;
    }

    public void setListOfFruit(ArrayList<Fruit> listOfFruit) {
        this.listOfFruit = listOfFruit;
    }

    public Validation getVal() {
        return val;
    }

    public void setVal(Validation val) {
        this.val = val;
    }

    public FileManager getF() {
        return f;
    }

    public void setF(FileManager f) {
        this.f = f;
    }
    public FruitManager getFruitManager() {
        return fruitManager;
    }
    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruits) {
            if (id.equals(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    public void createFruit() {
        while (true) {
            String fruitId = validation.inputString("Enter id:", ".+");

            if (getFruitById(fruitId) != null) {
                System.out.println("ID is existed");
                continue;
            }
            String fruitName = validation.inputString("Enter name:", "[A-Za-z\\s]+");
            double price = validation.inputDouble("Enter price:", 1, Double.MAX_VALUE);
            int quantity = validation.inputInt("Enter quantity:", 1, Integer.MAX_VALUE);
            String origin = validation.inputString("Enter origin:", "[A-Za-z\\s]+");
            fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            if (!validation.checkInputYN("Do you want to continue?")) {
                break;
            }
        }
    }

    public int displayListFruit() {
        int countItem = 0;
        if (fruits.isEmpty()) {
            return -1;
        }
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                countItem++;
                if (countItem == 1) {
                    System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
                }
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem,
                        fruit.getName(), fruit.getOrigin(),
                        fruit.getPrice());
            }
        }
        if (countItem == 0) {
            return -1;
        }
        int item = validation.inputInt("Enter item:", 1, countItem);
        return item;

    }
    public Fruit getFruit(int item) {
        int count = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (item == count) {
                return fruit;
            }
        }
        return null;
    }

    public FruitManager() {
    }
}