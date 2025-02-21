import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       String url="C:\\+" +
               "Users\\ADMIN\\IdeaProjects\\readfile\\src\\abcd.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        ArrayList<Book> library = new ArrayList<>();
        Scanner sc = new Scanner(fileInputStream);
        sc.nextLine();
        while (sc.hasNextLine()){
            String[] listProp= sc.nextLine().split(";");
            listProp[3] = listProp[3].substring(1,listProp[3].length()-1);
            Book newBook = new Book(listProp[0],listProp[1],listProp[2],Integer.parseInt(listProp[3]),listProp[4]);
            library.add(newBook);
        }
        fileInputStream.close();
        for (Book book:library){
            System.out.println(book);
        }
        }
    }