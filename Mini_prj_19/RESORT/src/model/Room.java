package model;

import model.Facility;
import model.Rent;

public class Room extends Facility {
    protected String freeService;

    public Room(String serviceId, String serviceName, double serviceAcreage, double price, int maxPeople, Rent rent, String freeService) {
        super(serviceId, serviceName, serviceAcreage, price, maxPeople, rent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room " + super.toString()+
                "freeService='" + freeService;

    }
}
