public class snake {
    private int cur_x;
    private int cur_y;


    public snake() {
    }

    public snake(int x, int y) {
        this.cur_x = x;
        this.cur_y = y;
    }

    public int getX() {
        return cur_x;
    }

    public void setX(int x) {
        this.cur_x = x;
    }

    public int getY() {
        return cur_y;
    }

    public void setY(int y) {
        this.cur_y = y;
    }
}
