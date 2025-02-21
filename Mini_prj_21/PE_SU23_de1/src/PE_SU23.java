import java.util.InputMismatchException;
import java.util.Scanner;

public class PE_SU23 {
    public static void bt1_1() {
        Scanner sc = new Scanner(System.in);
        int numBer = 0;
        while (true) {
            try {
                System.out.println("Nhap vao so:");
                numBer = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input sai");
                sc.nextLine();
            }
        }
        int bill = 0;
        int discount = 0;
        int totalCost = 0;
        if (numBer <= 3) {
            bill = numBer * 10;
        } else if (numBer <= 7) {
            bill = 30 + (numBer - 3) * 8;
        } else if (numBer > 8) {
            bill = 30 + 32 + (numBer - 7) * 6;
        }
        if (bill > 400) {
            discount = bill * 10 / 100;
        }
        totalCost = bill - discount;
        System.out.println(bill);
        System.out.println(discount);
        System.out.println(totalCost);
    }

    public static double calculateTaxiBill() {
        Scanner sc = new Scanner(System.in);
        int distance;
        while (true) {
            try {
                System.out.println("Moi nhap vao:");
                distance = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println(("Input sai"));
                sc.nextLine();
            }
        }
        int cost5Km = 100;
        int cost10Km = 10;
        int cost20Km = 8;
        int costAbove25Km = 5;
        double fare;
        if (distance <= 5) {
            fare = cost5Km;
        } else if (distance <= 15) {
            fare = cost5Km + (distance - 5) * cost10Km;
        } else if (distance <= 25) {
            fare = cost5Km + 10 * cost10Km + (distance - 15) * cost20Km;
        } else {
            fare = cost5Km + 10 * cost10Km + 10 * cost20Km + (distance - 25) * costAbove25Km;
        }
        if (fare > 200) {
            double discount = 0.10 * fare;
            fare -= discount;
        }
        return fare;
    }

    /*public static String convertOctalToBinary() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        float res;
        String temp="";
        for (int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)>=8){
                return null;
            }
            while (str.charAt(i) > 0) {
                int midGame = str.charAt(i) % 2;
                str.charAt(i) = (char)(str.charAt(i) / 2);
                temp = midGame + temp;
            }
        }
        return temp;
    }*/
    public static String checkPasswordQuality(String arr) {
        Scanner sc = new Scanner(System.in);
        arr = sc.nextLine();
        boolean res1 = false, res2 = false, res3 = false, res4 = false, res5 = false;
        int res = 0;
        if (arr.length() >= 8) {
            res5 = true;
        } else return Integer.toString(0);
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) >= 'A' && arr.charAt(i) <= 'Z') {
                res1 = true;
            } else if (arr.charAt(i) >= '1' && arr.charAt(i) <= '9') {
                res2 = true;
            } else if (arr.charAt(i) >= 'a' && arr.charAt(i)<= 'z') {
                res3 = true;
            } else res4 = true;
        }
        if (res1) {
            res++;
        }
        if (res2) {
            res++;
        }
        if (res3) {
            res++;
        }
        if (res4) {
            res++;
        }
        if (res5) {
            res++;
        }
        return Integer.toString(res);
    }
    public static void main(String[] args) {
        // bt1_1();
        //System.out.println(calculateTaxiBill());
         // System.out.println(convertOctalToBinary());
        checkPasswordQuality();
    }
}