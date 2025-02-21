package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String gender;
    private Date dob;

    public Student() {
    }

    public Student(int id, String name, String gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public Student(int id, String name, String gender, String dob) throws ParseException {
        this.id = id;
        this.name = name;
        this.gender = gender;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dob = dateFormat.parse(dob);
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
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(dob);
    }

    public void setDob(String dob) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        this.dob = sd.parse(dob);
    }
}
