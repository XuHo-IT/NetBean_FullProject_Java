package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Serializable {

    private int id;
    private String name;
    private boolean gender; // Updated to boolean
    private Date dob;

    public Student() {
    }

    public Student(int id, String name, boolean gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender ? "Male" : "Female"; // Updated to return string representation
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public boolean isGender() {
        return gender;
    }

    public String getDob() {
        if (dob == null) {
            return "N/A"; // Return a default value if dob is null
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dob);
    }

    public void setDob(String dob) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dob = sd.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + getGender() + ", dob=" + dob + '}';
    }
}
