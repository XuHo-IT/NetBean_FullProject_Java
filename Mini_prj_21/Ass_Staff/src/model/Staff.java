package model;

import java.util.Date;

public class Staff {
    protected String staffID;
    protected  String fullName;
    protected  String department;
    protected  String password;
    protected Date DoB;

    public Staff(String staffID, String fullName, String department, String password, Date doB) {
        this.staffID = staffID;
        this.fullName = fullName;
        this.department = department;
        this.password = password;
        DoB = doB;

    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID  +
                ", fullName='" + fullName +
                ", department='" + department  +
                ", password='" + password  +
                ", DoB=" + DoB ;

    }
}
