/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Student;
import model.StudentList;

/**
 *
 * @author Ly Quynh Tran
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        StudentList studentList = new StudentList();
        //studentList.delete(1002);
        Student s = new Student(1002, "Mr B", false, new SimpleDateFormat("yyyy-MM-dd").parse("2000/05/20"));
        studentList.update(s);
        System.out.println("" + studentList.getList());
    }

}
