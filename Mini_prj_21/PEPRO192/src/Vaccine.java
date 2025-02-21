public class Vaccine {
    private String name;
    private String code;
    private int expiration;
    private double price;

    public Vaccine(String name, String code, int expiration, double price) {
        this.name = name;
        this.code = code;
        this.expiration = expiration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getCode(){
        return  code;
    }
    public void setCode(String newCode){
        this.code = newCode;
    }

    public int getExpiration(){
        return expiration;
    }
    public void setExpiration(int newExpiration){
        this.expiration= newExpiration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

}
