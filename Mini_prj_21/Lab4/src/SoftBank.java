import java.util.Scanner;

public abstract class SoftBank {
    protected String ID;
    protected String name;
    protected int day;
    protected String address;
    protected int numberOfSenior;
    protected int numberOfJunior;
    protected double guessMoney;
    protected double realMoney;

    public SoftBank(String ID, String name, int day, String address, int numberOfSenior, int numberOfJunior) {
        this.ID = ID;
        this.name = name;
        this.day = day;
        this.address = address;
        this.numberOfSenior = numberOfSenior;
        this.numberOfJunior = numberOfJunior;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfSenior() {
        return numberOfSenior;
    }

    public void setNumberOfSenior(int numberOfSenior) {
        this.numberOfSenior = numberOfSenior;
    }

    public int getNumberOfJunior() {
        return numberOfJunior;
    }

    public void setNumberOfJunior(int numberOfJunior) {
        this.numberOfJunior = numberOfJunior;
    }
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID chi nhanh");
        this.ID=sc.nextLine();
        System.out.println("Nhap ten chi nhanh");
        this.name=sc.nextLine();
        System.out.println("Nhap ngay thanh lap");
        this.day=sc.nextInt();
        System.out.println("Nhap dia chi");
        this.address=sc.nextLine();
        sc.nextLine();
        System.out.println("Nhap so luong nhan vien Senior");
        this.numberOfSenior=sc.nextInt();
        System.out.println("Nhap so luong nhan vien Junior");
        this.numberOfSenior=sc.nextInt();
        sc.nextLine();
    }

    public abstract String toString();
    public SoftBank() {
    }
    public abstract String  money1();
    public abstract String  money2();

}
