import java.util.NoSuchElementException;
import java.util.Scanner;

public class cat extends animal {
    private String eyeColor;

    public cat() {
    }

    public cat(String name, int age, String color, String eyeColor) {
        super(name, age, color);
        this.eyeColor = eyeColor;
    }
    public void getInfo(){
        super.getInfo();
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                this.eyeColor=sc.nextLine();
                sc.nextLine();
                break;
            }catch (NoSuchElementException a){
                System.out.println("Wrong type of input");
                sc.nextLine();
            }
        }
    }
    public String dance() {
        return "Meo nhay";
    }
    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public String barking() {
        return "meo sua meow";
    }

    public String walking() {
        return "meo bi liet";
    }

    public String eat() {
        return "meo an 5 qua ten lua";
    }

    public String toString() {
        return "cat" +" "+
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", color='" + this.getColor() + '\'' +
                ", dance ='" + dance() +'\''+
                " ,barking ='" + barking() +'\''+
                ", walking ='" + walking() +'\''+
                ", eat ='" + eat()+ '\''+
                ", eyeColoe='" +getEyeColor()+ '\'';
    }
}
