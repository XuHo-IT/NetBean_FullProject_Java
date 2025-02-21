import java.util.Scanner;

public class SoftBank_North extends  SoftBank {
    public SoftBank_North(String ID, String name, int day, String address, int numberOfSenior, int numberOfJunior) {
        super(ID, name, day, address, numberOfSenior, numberOfJunior);
    }
    public void getInfo(){
        super.getInfo();
    }

    public SoftBank_North() {
    }

    public String money1(){
         this.guessMoney= super.numberOfSenior*5000*2*super.numberOfJunior*2000*2;
         return "Chi phi du tru: "+this.guessMoney;
    }
    public String money2(){
        this.realMoney=this.guessMoney;
       return "Chi phi thuc te: "+this.realMoney;
    }

    @Override
    public String toString() {
        return "SoftBank_North has: "+ "ID='" + ID +
                ", name='" + name +
                ", day=" + day +
                ", address='" + address +
                ", numberOfSenior=" + numberOfSenior +
                ", numberOfJunior=" + numberOfJunior + money1() +money2();
    }
}
