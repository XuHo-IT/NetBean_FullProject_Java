package Control;

import Model.FPTStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    private ArrayList<FPTStudent> fptStudents = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void inputAddStudent(){
        System.out.println("Nhap ten sinh vien: ");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi sinh vien: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ID sinh vien: ");
        String ID = sc.nextLine();
        FPTStudent student = new FPTStudent(name,age,ID);
        fptStudents.add(student);
    }
}
