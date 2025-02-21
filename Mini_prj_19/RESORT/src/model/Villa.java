package model;

import model.Facility;
import model.Rent;

public class Villa extends Facility {
  protected String standardRoom;
  protected double poolAcreage;
  protected int numberOfStair;

    public Villa(String serviceId, String serviceName, double serviceAcreage, double price, int maxPeople, Rent rent, String standardRoom, double poolAcreage, int numberOfStair) {
        super(serviceId, serviceName, serviceAcreage, price, maxPeople, rent);
        this.standardRoom = standardRoom;
        this.poolAcreage = poolAcreage;
        this.numberOfStair = numberOfStair;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolAcreage() {
        return poolAcreage;
    }

    public void setPoolAcreage(double poolAcreage) {
        this.poolAcreage = poolAcreage;
    }

    public int getNumberOfStair() {
        return numberOfStair;
    }

    public void setNumberOfStair(int numberOfStair) {
        this.numberOfStair = numberOfStair;
    }

    @Override
    public String toString() {
        return "Villa " + super.toString()+
                ", standardRoom='" + standardRoom +
                ", poolAcreage=" + poolAcreage +
                ", numberOfStair=" + numberOfStair;

    }
}
