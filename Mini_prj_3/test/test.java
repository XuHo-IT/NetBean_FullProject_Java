import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seosonal_staff c = new Seosonal_staff();
        Main_staff d = new Main_staff();
        Seosonal_staff a = new Seosonal_staff("1","Nguyen","Le",34,12,3.5,30000);
        Main_staff b = new Main_staff("2","Ho","Tuan",44,12,3,50000);
        ArrayList<Staff> stdList = new ArrayList<>();
        int choice;
//        do{
//            System.out.println("Moi lua chon nhan vien: ");
//            System.out.println("1.Seasonal staff (nhan vien thoi vu) ");
//            System.out.println("2.Main staff (nhan vien chinh thuc) ");
//            choice=sc.nextInt();
//            switch (choice){
//                case 1:
//                Seosonal_staff a = new Seosonal_staff();
//                a.getInfo();
//                    System.out.println(a.toString());
//                break;
//                case 2:
//                    Main_staff b = new Main_staff();
//                    b.getInfo();
//                    System.out.println(b.toString());
//                    break;
//                default:
//                    System.out.println("Moi nhap lai lua chon ");
//                    break;
//            }
//        }while(choice !=0);
//        System.out.println(0);
        do {
            System.out.println("1. Nhập danh sách nhân viên từ bàn phím");
            System.out.println("2. Xuất Danh sách theo loại nhân viên ra màn hình");
            System.out.println("3. Sắp xếp giảm dần theo lương và xuất ra màn hình");
            System.out.println("4. Tìm và xóa nhân viên theo tên nhập từ bàn phím");
            System.out.println("5. Xuất mức lương trung bình của từng loại nhân viên");
                        System.out.println("Nhap lua chon: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Vi day chi la nhap thong tin nen se khong co ket qua");
                        System.out.println("Da co thong tin 2 nhan vien xin moi lua chon 2 nhan vien con lai: ");
                        System.out.println("1.Seasonal staff ");
                        System.out.println("2.Main staff ");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                c.getInfo();
                                break;
                            case 2:
                                d.getInfo();
                                break;
                            default:
                                System.out.println("Moi nhap lai lua chon ");
                                break;
                        }
                    } while (choice != 2);
                    System.out.println(0);
                    break;

                case 2:
                    int k;
                    int select;
                    int get;
                    System.out.println("Neu lua chon xuat ra nhan vien ma khong co du lieu thi se xuat ra khong co thong tin, Lua chon quyet dinh");
                    System.out.println("1.In ra rong");
                    System.out.println("2.Nhap vao thong tin va in ra");
                    System.out.println("Lua chon: ");
                    get = sc.nextInt();
                    if (get == 1) {
                        System.out.println("       NULL         ");
                    } else if (get == 2) {
                        System.out.println("So luong nhan vien con lai : 2 ");
                        sc.nextLine();
                        do {
                            System.out.println("Moi lua chon nhan vien: ");
                            System.out.println("1.Seasonal staff (nhan vien thoi vu) ");
                            System.out.println("2.Main staff (nhan vien chinh thuc) ");
                            select = sc.nextInt();
                            switch (select) {
                                case 1:
                                    c.getInfo();
                                    break;
                                case 2:
                                    d.getInfo();
                                    break;
                                default:
                                    System.out.println("Moi nhap lai lua chon ");
                                    break;
                            }
                        } while (select != 2);
                        System.out.println(a.toString());
                        System.out.println(b.toString());
                        System.out.println(c.toString());
                        System.out.println(d.toString());
                    }
                    break;
                case 3:
                     System.out.println("Truoc khi sap xep luong nhan vien hay nhap day du cac nhan vien!! ");
                    System.out.println("So luong nhan vien: 4 ");
                    System.out.println("So luong Seasonal_staff: 1 ");
                    System.out.println("so luong Main_staff: 1");
                    System.out.println("Nhap thong tin Seasonal_staff con lai: ");
                        c.getInfo();
                    System.out.println("Nhap thong tin Main_staff con lai: ");
                        d.getInfo();

                    stdList.add(a);
                    stdList.add(b);
                    stdList.add(c);
                    stdList.add(d);
                    stdList.sort(new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            return Double.compare(o1.money(),o2.money());
                        }
                    });
                    System.out.println("Sau khi sap xep theo luong (tang dan)");
                        stdList.forEach(System.out::println);
                        System.out.println();
                    System.out.println("Sau khi sap xep theo luong (giam dan)");
                    Collections.sort(stdList, Collections.reverseOrder(new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            return Double.compare(o1.money(), o2.money());
                        }
                    }));
                    // In danh sách theo thứ tự giảm dần
                    stdList.forEach(System.out::println);
                    break;
                case 4:
                     System.out.println("Truoc khi xoa nhan vien hay nhap day du cac nhan vien!! ");
                    System.out.println("So luong nhan vien: 4 ");
                    System.out.println("So luong Seasonal_staff: 1 ");
                    System.out.println("so luong Main_staff: 1");
                    System.out.println("Nhap thong tin Seasonal_staff con lai: ");
                    c.getInfo();
                    System.out.println("Nhap thong tin Main_staff con lai: ");
                    d.getInfo();
                    stdList.add(a);
                    stdList.add(b);
                    stdList.add(c);
                    stdList.add(d);
                    sc.nextLine();
                    System.out.println();
                    System.out.println("Moi nhap ten nhan vien muon xoa ");
                    String selectName = sc.nextLine();
                    for (int i=0;i<stdList.size();i++){
                        if (stdList.get(i).getName().equals(selectName )){
                           stdList.remove(i);
                           break;
                        }
                    }
                    stdList.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("So luong nhan vien: 4 ");
                    System.out.println("So luong Seasonal_staff: 1 ");
                    System.out.println("so luong Main_staff: 1");
                    System.out.println("Nhap thong tin Seasonal_staff con lai: ");
                    c.getInfo();
                    System.out.println("Nhap thong tin Main_staff con lai: ");
                    d.getInfo();
                 System.out.println("Luong nhan vien dau tien: "+ a.getSalary());
                 System.out.println("Luong nhan vien thu 2: "+ b.getSalary());
                 System.out.println("Luong nhan vien thu 3: "+ c.getSalary());
                 System.out.println("Luong nhan vien cuoi cung: "+ d.getSalary());
                   break;
                 default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        }while (choice != 0) ;
        System.out.println(0);
    }
}
