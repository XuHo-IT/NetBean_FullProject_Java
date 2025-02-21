package model;

import java.util.Date;

public class Employee {
    protected String employeeId;
    protected String employeeName;
    protected Date dateOfBirth;

    protected String gender;
    protected String CID;
    protected String number;
    protected String email;
    Level level = new Level();
    Position position = new Position();

    public Employee(String customerId, String customerName, Date dateOfBirth, String gender, String CID, String number, String email, Level level, Position position) {
        this.employeeId = customerId;
        this.employeeName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CID = CID;
        this.number = number;
        this.email = email;
        this.level = level;
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerName() {
        return employeeName;
    }

    public void setCustomerName(String customerName) {
        this.employeeName = customerName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return
                ", customerId='" + employeeId +
                ", customerName='" + employeeName +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender +
                ", CID='" + CID  +
                ", number='" + number  +
                ", email='" + email  +
                ", level=" + level +
                ", position=" + position ;
    }
}
