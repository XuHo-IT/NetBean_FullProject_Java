import java.util.Scanner;

public class Map {
    private int map_length;
    private int map_width;
    private int score;
    private snake a = new snake(5,10) ;
    private prey prey;

    public Map(int map_length, int map_width, int socre, snake a) {
        this.map_length = map_length;
        this.map_width = map_width;
        this.score = score;
        this.a= a;
    }

    public int getMap_length() {
        return map_length;
    }

    public void setMap_length(int map_length) {
        this.map_length = map_length;
    }

    public int getMap_width() {
        return map_width;
    }

    public void setMap_width(int map_width) {
        this.map_width = map_width;
    }

    public Map() {
    }

    public int getSocre() {
        return score;
    }

    public void setSocre(int socre) {
        this.score = score;
    }
    public snake getA() {
        return a;
    }

    public void setA(snake a) {
        this.a = a;
    }
    public void drawMap() {
        Scanner sc = new Scanner(System.in);
        double prey_x = Math.floor(Math.random()+ (this.map_width -2) +1);
        double prey_y = Math.floor(Math.random()+(this.map_length -2));
        while (prey_x == this.a.getX() && prey_y == this.a.getY()){
             prey_x = Math.floor(Math.random()+ (this.map_width -2) +1);
             prey_y = Math.floor(Math.random()+(this.map_length -2));
        }
        this.map_width = sc.nextInt();
        this.map_length = sc.nextInt();
        for(int i = 0; i < this.map_width; i++) {
            if(i % 2 == 0)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
        for(int i = 0; i < this.map_length - 2; i++) {
            for(int j = 0; j < this.map_width ; j++) {
                if (j == 0 || j == this.map_width - 1 || i==this.a.getX() && j==this.a.getY()) {
                    System.out.print("*");

                }else
                    System.out.print(" ");
                if (i==prey_x && j==prey_y){
                    System.out.print(7);
                }
            }
            System.out.println();
        }
        for(int i = 0; i < this.map_width; i++) {
            if(i % 2 == 0)
                System.out.print("*");
            else
                System.out.print(" ");
        }
    }
}


