import java.util.Scanner;

public class Main_staff extends Staff {
    private int otTime;

    public Main_staff(String ID, String lastName, String name, int age, int day, int otTime, int salary) {
        super(ID, lastName, name, age, day,salary);
        this.otTime = otTime;
    }

    public int getOtTime() {
        return otTime;
    }

    public void setOtTime(int otTime) {
        this.otTime = otTime;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void getInfo() {
        super.getInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thoi gian OT cua nhan vien: ");
        this.otTime=sc.nextInt();
        System.out.println("Nhap muc luong nhan vien: ");
        this.salary= sc.nextInt();
    }
    public double money(){
        double money=super.getDay()*1000000*this.otTime*100000;
        return money;
    }
    @Override
    public String toString() {
        return "Main_staff's name: " + super.toString()+ " ,otTime=" + otTime + ", salary=" + salary + ", and money:"+ money() ;

    }
    public Main_staff() {
    }
}
