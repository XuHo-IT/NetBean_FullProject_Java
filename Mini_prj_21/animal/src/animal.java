import java.util.NoSuchElementException;
import java.util.Scanner;

public class animal {
    private String name;
    private int age;
    private String color;

    public animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public animal() {
    }

    public String getName() {
        return name;
    }
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                this.name=sc.nextLine();
                this.age=sc.nextInt();
                sc.nextLine();
                this.color=sc.nextLine();
                sc.nextLine();
                break;
            }catch (NoSuchElementException a){
                System.out.println("Wrong type of input");
                sc.nextLine();
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String barking(){
        return "this animal bark";
    }
    public String walking(){
        return "this animal walk";
    }
    public String eat(){
        return "this animal eat";
    }

    public String toString() {
        return "animal" + " "+
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

}
