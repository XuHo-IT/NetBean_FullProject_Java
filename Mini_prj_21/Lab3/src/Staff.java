import java.util.Scanner;
public class Staff {
    protected String ID;
    protected String lastName;
    protected String name;
    protected int age;
    protected int day;
    protected int salary;

    public Staff(String ID, String lastName, String name, int age, int day, int salary) {
        this.ID = ID;
        this.lastName = lastName;
        this.name = name;
        this.age = age;
        this.day = day;
        this.salary= salary;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDay() {
        return day;
    }

    public double money(){
        double money = this.day;
        return money;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID nhan vien: ");
        this.ID=sc.nextLine();
        System.out.println("Nhap ho nhan vien: ");
        this.lastName= sc.nextLine();
        System.out.println("Nhap ten nhan vien: ");
        this.name = sc.nextLine();
        System.out.println("Nhap tuoi nhan vien: ");
        this.age = sc.nextInt();
        System.out.println("Nhap ngay sinh nhan vien: ");
        this.day = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return  name +" ,ID= " + ID +", lastName= " + lastName +
                ", age= " + age +  ", birthDay= " + day;

    }

    public Staff() {
    }
}