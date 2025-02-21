package model;

public class House extends Facility {
    protected String standardRoom;

    protected int numberOfStair;

    public House(String serviceId, String serviceName, double serviceAcreage, double price, int maxPeople, Rent rent, String standardRoom, int numberOfStair) {
        super(serviceId, serviceName, serviceAcreage, price, maxPeople, rent);
        this.standardRoom = standardRoom;
        this.numberOfStair = numberOfStair;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberOfStair() {
        return numberOfStair;
    }

    public void setNumberOfStair(int numberOfStair) {
        this.numberOfStair = numberOfStair;
    }

    @Override
    public String toString() {
        return "House " + super.toString()+
                ", standardRoom='" + standardRoom  +
                ", numberOfStair=" + numberOfStair ;

    }
}
