import java.util.NoSuchElementException;
import java.util.Scanner;

public class dog extends animal {

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    private double height;
    private double kg;

    public dog() {
    }

    public dog(String name, int age, String color, double height, double kg) {
        super(name, age, color);
        this.height = height;
        this.kg = kg;
    }
    public void getInfo(){
        super.getInfo();
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                this.height=sc.nextDouble();
                this.kg=sc.nextDouble();
                break;
            }catch (NoSuchElementException a){
                System.out.println("Wrong type of input");
                sc.nextLine();
            }
        }
    }
    public String hunt() {
        return "Cho di san";
    }
    @Override
    public String barking(){
        return "cho sua gau gau";
    }
    public String walking(){
        return "cho chay chu deo di";
    }
    public String eat(){
        return "cho an 3tocom";
    }
    public String toString() {
        return "dog" +" "+
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", color='" + this.getColor() + '\'' +
                ", hunt ='" +hunt() +'\''+
                " ,barking ='" +barking() +'\''+
                ", walking ='" + walking() +'\''+
                ", eat ='"+eat()+ '\''+
                ", height ='"+getHeight()+ '\''+
                ", kg='"+getKg()+'\'';
    }

}
