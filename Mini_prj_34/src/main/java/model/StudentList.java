package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Predicate;

public class StudentList {
    private ArrayList<Student> list = new ArrayList<>();

    public StudentList() throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list.add(new Student(1001, "Nguyễn Trường Xuân", "Male", "1990-05-20"));
        list.add(new Student(1002, "Nguyễn Thị Thanh Xuân", "Female", "2000-05-20"));
        list.add(new Student(1003, "Nguyễn Minh Xuân", "Male", "2001-05-20"));
        list.add(new Student(1004, "Nguyễn Thanh Xuân", "Male", "2002-05-22"));
        list.add(new Student(1005, "Nguyễn Trường Sinh", "Female", "2001-05-19"));
    }

    public ArrayList<Student> add(Student s) {
        list.add(s);
        return list;
    }

    public ArrayList<Student> delete(int id) {
        list.removeIf(student -> student.getId() == id);
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

    public ArrayList<Student> search(Predicate<Student> p) {
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
