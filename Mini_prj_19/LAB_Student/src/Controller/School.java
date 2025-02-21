package Controller;

import Model.BitzStudent;
import Model.ITStudent;
import Model.Student;
import View.Validation;

import java.util.*;

public class School {
    ArrayList<Student> list = new ArrayList<>();
    Validation valid;

    public School() {
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
    public boolean isEmptyList(){
        if (list.isEmpty()){
            System.out.println("List empty");
        }
        return false;
    }
    public void addNew(){
        ITStudent itStudent = new ITStudent();
        BitzStudent bitzStudent = new BitzStudent();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type of student ");
        System.out.println("1.IT Student ");
        System.out.println("2.Biz Student ");
        System.out.println("Choose: ");
        int a = sc.nextInt();
        sc.nextLine();
        if (a==1){
            list.add(itStudent.addNewOne());
        }
        if (a==2){
            list.add(bitzStudent.addNewOne());
        }
    }
    public void printList(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getFullName().compareTo(s2.getFullName());
            }
        });
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public void check() {
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Student student1 = list.get(i);
                Student student2 = list.get(j);

                if (student1.getAddress().getCity().equals(student2.getAddress().getCity())) {

                    System.out.println("Thanh pho co trung sinh vien la: "+student1.getAddress().getCity());
                    System.out.println("Cac sinh vien co trung thanh pho la: ");
                    System.out.println(student1);
                    System.out.println(student2);
                }
            }
        }
    }


    public void findByID(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID");
        String id = sc.nextLine();
        BitzStudent bitzStudent;
        ITStudent itStudent;
        for(Student studentList:list){
            if (studentList.getId().equals(id)){
                System.out.println("Do you want to update(U) or delete(D) student");
                String s = sc.nextLine();
                if (s.equals("U")){
                    System.out.println("Enter which one you want to edit: " +
                            "1.Id, " +
                            "2.Name, " +
                            "3.acc, " +
                            "4.mkt, " +
                            "5.java, "+
                            "6.css, "+
                            "7.country"+
                            "8.city, "+
                            "9.district, "+
                            "10.street, ");
                    int a = sc.nextInt();
                    sc.nextLine();

                    switch (a) {
                        case 1:
                            System.out.println("Enter newID");
                            String newId =sc.nextLine();
                            studentList.setId(newId);
                            System.out.println("Update success");
                            break;
                        case 2:
                            System.out.println("Enter newName");
                            String newName =sc.nextLine();
                            studentList.setFullName(newName);
                            System.out.println("Update success");
                            break;
                        case 3:
                            System.out.println("Enter newAcc");
                            Double newAcc = sc.nextDouble();

                            if (studentList instanceof BitzStudent) {
                                bitzStudent = (BitzStudent) studentList;
                                bitzStudent.setAcc(newAcc);
                                System.out.println("Update success");
                            } else {
                                System.out.println("This student is not an instance of BitzStudent");
                            }
                            break;

                        case 4:
                            System.out.println("Enter newMkt");
                            Double newMkt = sc.nextDouble();

                            if (studentList instanceof BitzStudent) {
                                bitzStudent = (BitzStudent) studentList;
                                bitzStudent.setMkt(newMkt);
                                System.out.println("Update success");
                            } else {
                                System.out.println("This student is not an instance of BitzStudent");
                            }
                            break;
                        case 5:
                            System.out.println("Enter newJava");
                            Double newJava = sc.nextDouble();
                            if (studentList instanceof ITStudent) {
                                itStudent = (ITStudent) studentList;
                                itStudent.setJava(newJava);
                                System.out.println("Update success");
                            } else {
                                System.out.println("This student is not an instance of ITStudent");
                            }
                            break;
                        case 6:
                            System.out.println("Enter newCss");
                            Double newCss = sc.nextDouble();

                            if (studentList instanceof ITStudent) {
                                itStudent = (ITStudent) studentList;
                                itStudent.setCss(newCss);
                                System.out.println("Update success");
                            } else {
                                System.out.println("This student is not an instance of ITStudent");
                            }
                            break;
                        case 7:
                            System.out.println("Enter newCountry");
                            String newCountry =sc.nextLine();
                            studentList.getAddress().setCountry(newCountry);
                            System.out.println("Update success");
                            break;
                        case 8:
                            System.out.println("Enter newCity");
                            String newCity =sc.nextLine();
                            studentList.getAddress().setCity(newCity);
                            System.out.println("Update success");
                            break;
                        case 9:
                            System.out.println("Enter newDistrict");
                            String newDistrict =sc.nextLine();
                            studentList.getAddress().setDistrict(newDistrict);
                            System.out.println("Update success");
                            break;
                        case 10:
                            System.out.println("Enter newStreet");
                            String newStreet =sc.nextLine();
                            studentList.getAddress().setStreet(newStreet);
                            System.out.println("Update success");
                            break;
                        case 11:
                            return;
                    }
                }else if (s.equals("D")){
                    list.remove(studentList);
                    System.out.println("Remove success");
                    return;
                }
            }
        }

    }
    public void report(){
        Scanner sc = new Scanner(System.in);
        for (Student student:list){
            BitzStudent bitzStudent;
            ITStudent itStudent;
            if (student instanceof BitzStudent){
                bitzStudent = (BitzStudent) student;
               if (bitzStudent.calculateAverageScore() >=5){
                   System.out.println(bitzStudent);
                   System.out.println("GPA: "+ bitzStudent.calculateAverageScore());
               }
            }
            if (student instanceof ITStudent){
                itStudent = (ITStudent) student;
                if (itStudent.calculateAverageScore() >=5){
                    System.out.println(itStudent);
                    System.out.println("GPA: "+ itStudent.calculateAverageScore());
                }
            }
        }

    }
}
