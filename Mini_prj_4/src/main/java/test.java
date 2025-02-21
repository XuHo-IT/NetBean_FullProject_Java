
import java.util.ArrayList;
import java.util.Scanner;

public class test {
   static ArrayList<SoftBank> banks = new ArrayList<SoftBank>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập danh sách chi nhánh từ bàn phím");
            System.out.println("2. Tính tổng số lượng nhân viên của các chi nhánh");
            System.out.println("3. Tính tổng chi phí thực tế của các chi nhánh");
            System.out.println("4. In ra số lượng nhân viên của các chi nhánh theo loại");
            System.out.println("5. Xuất mức lương trung bình của từng loại nhân viên");
            System.out.println("0. Thoát");
            System.out.println("Mời nhập lựa chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    enterBranchData();
                    break;
                case 2:
                    calculateTotalEmployees();
                    break;
                case 3:
                    calculateTotalActualCost();
                    break;
                case 4:
                    printEmployeeCountByType();
                    break;
                case 5:
                    calculateAverageSalary();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    static void enterBranchData() {
        System.out.println("Nhập thông tin chi nhánh:");
        System.out.print("Miền bắc hoặc miền trung (N/S): ");
        String region = scanner.next().toUpperCase();

        System.out.print("Tên chi nhánh: ");
        String name = scanner.next();

        System.out.print("Ngày thành lập: ");
        int date =scanner.nextInt();

        System.out.print("Địa chỉ: ");
        String address = scanner.next();

        System.out.print("Số lượng nhân viên senior: ");
        int senior = scanner.nextInt();

        System.out.print("Số lượng nhân viên junior: ");
        int junior = scanner.nextInt();

        if (region.equals("N")) {
            SoftBank_North branch = new SoftBank_North(name, date, address, senior, junior);
            banks.add(branch);
        } else if (region.equals("C")) {
            Softbank_South branch = new Softbank_South(name, date, address, senior, junior);
            banks.add(branch);
        } else {
            System.out.println("Miền không hợp lệ. Không thêm chi nhánh.");
        }
    }

    static void calculateTotalEmployees() {
        int totalSenior = 0;
        int totalJunior = 0;

        for (SoftBank bank : banks) {
            totalSenior += bank.getSeniorEmployees();
            totalJunior += bank.getJuniorEmployees();
        }

        System.out.println("Tổng số lượng nhân viên senior: " + totalSenior);
        System.out.println("Tổng số lượng nhân viên junior: " + totalJunior);
    }

    static void calculateTotalActualCost() {

    }

    static void printEmployeeCountByType() {
        int totalSenior = 0;
        int totalJunior = 0;

        for (SoftBank branch : banks) {
            totalSenior += branch.getSeniorEmployees();
            totalJunior += branch.getJuniorEmployees();
        }

        System.out.println("Số lượng nhân viên senior: " + totalSenior);
        System.out.println("Số lượng nhân viên junior: " + totalJunior);
    }

    static void calculateAverageSalary() {
        int totalSenior = 0;
        int totalJunior = 0;

        for (SoftBank bank : banks) {
            totalSenior += bank.getSeniorEmployees();
            totalJunior += bank.getJuniorEmployees();
        }

        double averageSeniorSalary = totalSenior * 5000.0 / totalSenior;
        double averageJuniorSalary = totalJunior * 2000.0 / totalJunior;

        System.out.println("Mức lương trung bình của nhân viên senior: " + averageSeniorSalary);
        System.out.println("Mức lương trung bình của nhân viên junior: " + averageJuniorSalary);
    }
}

