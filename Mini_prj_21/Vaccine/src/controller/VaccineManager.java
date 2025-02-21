package controller;
import model.Vaccine;
import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Collections;


public class VaccineManager extends Vaccine implements Comparable<Vaccine> {
    static List<Vaccine> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public VaccineManager(String name, String code, int quantity, java.util.Date expirationDate, double price, java.util.Date lastInjectedDate) {
        super(name, code, quantity, expirationDate, price, lastInjectedDate);
    }
    public VaccineManager() {
    }

    public  void readFile() throws IOException, ParseException  {
        File file = new File("src/controller/vaccine_input.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner sc = new Scanner(fileInputStream);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] listVaccine = sc.nextLine().split(",");
            if (listVaccine.length < 6) {
                System.out.println("Invalid data: " + String.join(",", listVaccine));
                continue; // Skip invalid data
            }
            try {
                String name = listVaccine[0];
                String code = listVaccine[1];
                int quantity = Integer.parseInt(listVaccine[2]);
                Date expirationDate = new Date(dateFormat.parse(listVaccine[3]).getTime());
                double price = Double.parseDouble(listVaccine[4]);
                Date lastInjectedDate = new Date(dateFormat.parse(listVaccine[5]).getTime());
                Vaccine newVaccine = new Vaccine(name, code, quantity, expirationDate, price, lastInjectedDate);
                list.add(newVaccine);
            } catch (NumberFormatException | ParseException e){
                System.out.println(String.join(",", listVaccine));
            }
        }

        fileInputStream.close();
        for (Vaccine vaccine : list) {
            System.out.println(vaccine);
        }
    }

    public void addVaccine() throws IOException,ParseException {
        File file = new File("src/controller/vaccine_input.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner sc = new Scanner(fileInputStream);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] listVaccine = sc.nextLine().split(",");
            if (listVaccine.length < 6) {
                System.out.println("Invalid data: " + String.join(",", listVaccine));
                continue; // Skip invalid data
            }
            try {
                String name = listVaccine[0];
                String code = listVaccine[1];
                int quantity = Integer.parseInt(listVaccine[2]);
                Date expirationDate = new Date(dateFormat.parse(listVaccine[3]).getTime());
                double price = Double.parseDouble(listVaccine[4]);
                Date lastInjectedDate = new Date(dateFormat.parse(listVaccine[5]).getTime());
                Vaccine newVaccine = new Vaccine(name, code, quantity, expirationDate, price, lastInjectedDate);
                list.add(newVaccine);
            } catch (NumberFormatException | ParseException e){
                System.out.println(String.join(",", listVaccine));
            }
        }

            for (Vaccine vaccine : list) {
                System.out.println(vaccine);
            }
        }
    public void delVaccine() throws IOException, ParseException {
        readFile();
        System.out.print("Nhập mã vaccine để xóa: ");
        String enter = sc.nextLine();
        Iterator<Vaccine> iterator = list.iterator();
       for (Vaccine vaccine:list){
            if (enter.equals(vaccine.getCode())) {
                list.remove(vaccine); // Xóa phần tử
                System.out.println("Đã xóa vaccine với mã " + vaccine.getCode());
            }
        }
        saveFile();
        displayVaccines(); // Hiển thị danh sách sau khi xóa
    }

    public void saveFile() throws IOException {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("vaccine_data.txt"); // Tên tệp tin để lưu dữ liệu
            printWriter = new PrintWriter(fileWriter);

            // Ghi từng phần tử của danh sách vào tệp tin
            for (Vaccine vaccine : list) {
                printWriter.println(
                        vaccine.getCode() + ","
                                + vaccine.getName() + ","
                                + vaccine.getQuantity() + ","
                                + vaccine.getExpirationDate() + ","
                                + vaccine.getPrice() + ","
                                + vaccine.getLastInjectedDate());
            }
        } finally {
            // Đảm bảo đóng tệp và tài nguyên sau khi sử dụng
            if (printWriter != null) {
                printWriter.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public void displayVaccines() {
        for (Vaccine vaccine : list) {
            System.out.println(vaccine);
        }
    }
    @Override
    public int compareTo(Vaccine o) {
        return super.getName().compareTo(o.getName());
    }
    public void sort(Comparator<Vaccine> c) {
        Collections.sort(list, c);
    }

}
