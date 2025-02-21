import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "C:\\Users\\ADMIN\\IdeaProjects\\readfileFPTstudent\\src\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        ArrayList<FPTStudents> list = new ArrayList<>();
        Scanner sc = new Scanner(fileInputStream);
        sc.nextLine();
        while (sc.hasNextLine()){
            String[] listStudents = sc.nextLine().split(";");
            listStudents[2] = listStudents[2].substring(0, listStudents[2].length() );
            listStudents[4] = listStudents[4].substring(0, listStudents[4].length() );
            FPTStudents newStudent = new FPTStudents(listStudents[0], listStudents[1], Integer.parseInt(listStudents[2]), listStudents[3], Double.parseDouble(listStudents[4]));
            list.add(newStudent);
            Collections.sort(list);
        }
        fileInputStream.close();
        for (FPTStudents students : list){
            System.out.println(students);
        }
    }
}