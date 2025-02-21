import java.util.Scanner;

public class main extends Map {
    public static void main (String[] args) {
        Map a = new Map();
        a.drawMap();
        boolean conti =true;
        while (conti = true){
            Scanner sc= new Scanner(System.in);
            a.drawMap();
            System.out.print("Moi nhap vao input: ");
            String nextMover = sc.nextLine();
            if (nextMover.equals("w")){
                a.getA().setX(a.getA().getX()-1);
            }
            if (nextMover.equals("s")){
                a.getA().setX(a.getA().getX()+1);
            }
            if (nextMover.equals("a")){
                a.getA().setY(a.getA().getY()-1);
            }
            if (nextMover.equals("d")){
                a.getA().setY(a.getA().getY()+1);
            }
        }
    }
}
