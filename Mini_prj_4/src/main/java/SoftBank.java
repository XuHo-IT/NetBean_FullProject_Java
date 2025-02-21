
public class SoftBank
{
     protected String BranchName;
     protected int Date;
     protected String Address;
     protected int SeniorEmployees;
     protected int JuniorEmployees;

    public SoftBank(String BankName, int Date, String Address, int SeniorEmployees, int JuniorEmployees) {
        this.BranchName = BankName;
        this.Date = Date;
        this.Address = Address;
        this.SeniorEmployees = SeniorEmployees;
        this.JuniorEmployees = JuniorEmployees;
    }

    public String getBankName() {
        return BranchName;
    }

    public void setBankName(String BankName) {
        this.BranchName = BankName;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getSeniorEmployees() {
        return SeniorEmployees;
    }

    public void setSeniorEmployees(int SeniorEmployees) {
        this.SeniorEmployees = SeniorEmployees;
    }

    public int getJuniorEmployees() {
        return JuniorEmployees;
    }

    public void setJuniorEmployees(int JuniorEmployees) {
        this.JuniorEmployees = JuniorEmployees;
    }
    
   
}
