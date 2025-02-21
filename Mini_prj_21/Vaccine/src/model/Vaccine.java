package model;
import java.util.Date;
import java.util.Objects;

public class Vaccine {
    protected String name;
    protected String code;
    protected int quantity;
    protected Date expirationDate;
    protected double price;
    protected Date lastInjectedDate;

    public Vaccine(String name, String code, int quantity, Date expirationDate, double price, Date lastInjectedDate) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.price = price;
        this.lastInjectedDate = lastInjectedDate;
    }

    public Vaccine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getLastInjectedDate() {
        return lastInjectedDate;
    }

    public void setLastInjectedDate(Date lastInjectedDate) {
        this.lastInjectedDate = lastInjectedDate;
    }

    @Override
    public String toString() {
        return "VaccineManager: " +
                "name='" + name  +
                ", code='" + code  +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                ", lastInjectedDate=" + lastInjectedDate ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine vaccine)) return false;
        return getQuantity() == vaccine.getQuantity() && Double.compare(getPrice(), vaccine.getPrice()) == 0 && Objects.equals(getName(), vaccine.getName()) && Objects.equals(getCode(), vaccine.getCode()) && Objects.equals(getExpirationDate(), vaccine.getExpirationDate()) && Objects.equals(getLastInjectedDate(), vaccine.getLastInjectedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCode(), getQuantity(), getExpirationDate(), getPrice(), getLastInjectedDate());
    }
}

