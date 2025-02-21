package view;

import controller.VaccineManager;
import model.Vaccine;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException, ParseException {
         VaccineManager a = new VaccineManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Vaccine Management System" );
        System.out.println("1.Display All Vaccines From File" );
        System.out.println("2.Add a vaccine" );
        System.out.println("3.Delete a Vaccine by code" );
        System.out.println("4.Sort Vaccine by Name" );
        System.out.println("5.Save to File" );
        System.out.println("6.Exit" );
        System.out.println("Enter selection: " );
        int choice = sc.nextInt();
        while(choice>0){
            switch (choice){
                case 1:
                    a.readFile();
                    break;
                case 2:
                    a.addVaccine();
                    break;
                case 3:
                    a.delVaccine();
                case 4:


            }
        }


    }
}
