import java.util.ArrayList;
import java.util.Scanner;

public class Person {
        private int id;
        private String name;
        private boolean gender;
        public static ArrayList<String> perArr=new ArrayList<String>(3);

    public Person(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    public int getId(){
        return this.id;
    }
    public void setId(String value){
        this.name=value;
    }
    public boolean isMale(){
        return this.gender;
    }
    public void setMale(boolean value){
        this.gender=value;
    }
    public void scanInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id= input.nextInt();
        input.nextLine();
        System.out.print("Enter Name: ");
        this.name = input.nextLine();
        System.out.print("Enter Gender");
        this.gender = input.nextBoolean();
    }
    public void printInfo(){
        System.out.println("-----------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", this.id, this.name, this.gender);
    }
            public Person(){

            }
}
/* public String toString(){
    return ....+this.name+....+this.id;
    }
     */
//dung de in ra output ko bi loi