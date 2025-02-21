import java.util.Comparator;
import java.util.Scanner;
public class Seosonal_staff extends Staff implements Comparable<Staff> {
    private double percent;


    public Seosonal_staff(String ID, String lastName, String name, int age, int day, double percent, int salary) {
        super(ID, lastName, name, age, day,salary);
        this.percent = percent;

    }
    public void getInfo() {
        super.getInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chiet khau thoi vu nhan vien: ");
        this.percent=sc.nextDouble();
        System.out.println("Nhap muc luong nhan vien: ");
        this.salary= sc.nextInt();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }


    public double money(){
        double money = super.getDay()*1000000*0.5;
        return  money;
    }

    @Override
    public String toString() {
        return "Seosonal_staff's name: " + super.toString()+ " ,percent=" + percent + " ,salary=" + salary + ", and money:"+ money() ;

    }

    public Seosonal_staff() {
    }

    @Override
    public int compareTo(Staff o) {
        return this.name.compareTo(o.getName());
    }
}
