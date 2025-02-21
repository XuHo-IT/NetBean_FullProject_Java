import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Test ts = new Test();
        Person ps = new Person();
        ts.scanInfo(ps);
        ts.printInfo(ps);
    }
    public static void scanInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id= input.nextInt();
        input.nextLine();
        System.out.print("Enter Name: ");
        name = input.nextLine();
        System.out.print("Enter Gender: ");
        gender = input.nextBoolean();
        return new Person(id,name, gender);
    }
    public static void printInfo(Person ps){
        System.out.println("-----------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", id, name, gender);
    }
}