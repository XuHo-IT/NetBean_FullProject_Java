/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Ly Quynh Tran
 */
public class StudentList implements Serializable {

    private ArrayList<Student> list = new ArrayList<>();

    public StudentList() throws ParseException {
        list.add(new Student(1001, "Nguyễn Trường Xuân", true, new SimpleDateFormat("yyyy-MM-dd").parse("1999-05-19")));
        list.add(new Student(1002, "Nguyễn Thị Thanh Xuân", false, new SimpleDateFormat("yyyy-MM-dd").parse("2000-05-20")));
        list.add(new Student(1003, "Nguyễn Minh Xuân", true, new SimpleDateFormat("yyyy-MM-dd").parse("2001-05-20")));
        list.add(new Student(1004, "Nguyễn Thanh Xuân", true, new SimpleDateFormat("yyyy-MM-dd").parse("2007-05-22")));
        list.add(new Student(1005, "Nguyễn Trường Sinh", false, new SimpleDateFormat("yyyy-MM-dd").parse("2001-05-19")));
    }

    public ArrayList<Student> add(Student s) {
        list.add(s);
        return list;
    }

    public ArrayList<Student> delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }

        }
        return list;
    }

    public ArrayList<Student> update(Student student) {
       for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == student.getId()) {
                list.set(i, student);
            }
        }
        return list;
    }

    public Student getStudent(int id) {
        for (Student student : list) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> search(Predicate p) {
        ArrayList<Student> rs = new ArrayList<>();
        for (Student s : list) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
    }

    public ArrayList<Student> searchByID(int id) {
        String idd = String.valueOf(id);
        ArrayList<Student> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getId()).contains(idd)) {
                l.add(list.get(i));
            }
        }
        return l;
    }

    public ArrayList<Student> searchByName(String name) {

        ArrayList<Student> l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(name)) {
                l.add(list.get(i));
            }
        }
        return l;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

}
