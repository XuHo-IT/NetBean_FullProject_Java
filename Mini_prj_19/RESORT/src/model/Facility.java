package model;

public abstract class Facility {
    protected  String serviceId;
    protected  String serviceName;
    protected  double serviceAcreage;
    protected double price;
    protected int maxPeople;
    Rent rent = new Rent();

    public Facility(String serviceId, String serviceName, double serviceAcreage, double price, int maxPeople, Rent rent) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceAcreage = serviceAcreage;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rent = rent;
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceAcreage() {
        return serviceAcreage;
    }

    public void setServiceAcreage(double serviceAcreage) {
        this.serviceAcreage = serviceAcreage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return  ", serviceId= " + serviceId +
                ", serviceName= " + serviceName  +
                ", serviceAcreage= " + serviceAcreage +
                ", price= " + price +
                ", maxPeople= " + maxPeople +
                ", rent= " +rent;

    }
}
