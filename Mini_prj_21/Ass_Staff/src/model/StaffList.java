package model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StaffList {
    List<Staff> list = new ArrayList<>();

    public StaffList(List<Staff> list) {
        this.list = list;
    }

    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }
    public void loadFile(File fileName)throws IOException, ParseException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int lineCount = 1;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String staffId = getValue(parts[0].trim());
            String fullName = getValue(parts[1].trim());
            String dep = getValue(parts[2].trim());
            String pass = getValue(parts[3].trim());
            String DoB = getValue(parts[4].trim());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            Date getDoB;
            try {
                getDoB = dateFormat.parse(DoB);
            } catch (ParseException e) {
                System.out.println("Invalid expiration date at line " + lineCount + ": " + line);
                lineCount++;
                continue;
            }

            Staff newstaff = new Staff(staffId, fullName,  dep, pass, getDoB);
            list.add(newstaff);
            lineCount++;
        }

        reader.close();
    }
    public void displayVaccines() {
        if (list.isEmpty()) {
            System.out.println("No vaccines available.");
            return;
        }

        for (Staff newStaff : list) {
            System.out.println(newStaff);
        }
    }
    public void addNewVaccine(String staffID, String fullName, String dep, String pass, String DoB) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (staffID.isEmpty() || fullName.isEmpty() || dep.isEmpty() || pass.isEmpty()|| DoB.isEmpty()) {
            System.out.println("Invalid input. Please provide all the required information.");
            return;
        }
        try {
            // Check for duplicate code
            if (isDuplicateCode(staffID)) {
                System.out.println("Vaccine with the same ID already exists. Please provide a different code.");
                return;
            }
            Date getDoB = dateFormat.parse(DoB);
            Staff newStaff = new Staff(staffID, fullName,  dep, pass, getDoB);
            list.add(newStaff);
            System.out.println("Staff added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Staff not added.");
        }
    }

    public void deleteVaccine(String code) {
        for (Staff newStaff : list) {
            if (newStaff.getStaffID().contains(code)) {
                list.remove(newStaff);
                System.out.println("Staff deleted successfully.");
                return;
            }
        }
        System.out.println("Staff not found.");
    }


    public void sortVaccinesByName() {
        Collections.sort(list, Comparator.comparing(Staff::getStaffID));
        System.out.println("Vaccines sorted by name.");
    }

    public void saveVaccinesToFile(File fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Staff vaccine : list) {
            String line = vaccine.toString();
            writer.write(line);
            writer.newLine();
        }

        writer.close();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    private String getValue(String part) {
        int index = part.indexOf("=");
        return part.substring(index + 1);
    }
    private boolean isDuplicateCode(String staffID) {
        for (Staff vaccine : list) {
            if (vaccine.getStaffID().contains(staffID)) {
                return true;
            }
        }
        return false;
    }

}
