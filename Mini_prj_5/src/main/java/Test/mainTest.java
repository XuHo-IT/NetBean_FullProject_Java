
package Test;


import controller.Library_Tools;
import view.LibraryManegement_menu;

public class mainTest {
      public static void main(String[] args) {
       Library_Tools libraryTools = new Library_Tools();
       LibraryManegement_menu menu = new LibraryManegement_menu(libraryTools);
        menu.printMenu();
    }
    
}
