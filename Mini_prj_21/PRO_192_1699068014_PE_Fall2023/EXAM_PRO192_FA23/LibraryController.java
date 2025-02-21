/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class LibraryController extends Menu {

    private UserController userController;
    private BookController bookController;
    private OrderController orderController;

    public LibraryController() {
        super("Library Management System",
                new ArrayList<>(
                        List.of("User Management",
                                "Book Management",
                                "Order Management",
                                "Exit")));

        userController = new UserController();
        bookController = new BookController();
        orderController = new OrderController();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                userController.run();
                break;
            case 2:
                bookController.run();
                break;
            case 3:
                orderController.run();
                break;
            case 4:
                System.err.println("Exited.");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

}
