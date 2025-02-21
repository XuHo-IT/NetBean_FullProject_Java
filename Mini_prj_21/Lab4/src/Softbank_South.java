import java.util.Scanner;

public class Softbank_South extends SoftBank {
    private int connectStaff;
    public Softbank_South(String ID, String name, int day, String address, int numberOfSenior, int numberOfJunior, int connectStaff) {
        super(ID, name, day, address, numberOfSenior, numberOfJunior);
        this.connectStaff = connectStaff;
    }

    public int getConnectStaff() {
        return connectStaff;
    }

    public Softbank_South() {

    }
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
        super.getInfo();
        this.connectStaff=sc.nextInt();
    }

    public void setConnectStaff(int connectStaff) {
        this.connectStaff = connectStaff;
    }
    public String money1(){
        super.guessMoney= super.numberOfSenior*5000*1.5*super.numberOfJunior*2000*1.5;
        return "Chi phi du tru: "+super.guessMoney;
    }
    public String money2(){
        super.realMoney= super.guessMoney+this.connectStaff*1000;
        return "Chi phi thuc te: "+super.realMoney;
    }
    @Override
    public String toString() {
        return "SoftBank_South has: "+ "ID='" + ID +
                ", name='" + name +
                ", day=" + day +
                ", address='" + address +
                ", numberOfSenior=" + numberOfSenior +
                ", numberOfJunior=" + numberOfJunior + money1() +money2();
    }
}




