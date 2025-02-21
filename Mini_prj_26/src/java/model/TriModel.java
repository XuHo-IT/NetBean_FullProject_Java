
public class TriModel {
    double a,b,c,cv,dt;

    public TriModel(double a, double b, double c, double cv, double dt) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.cv = cv;
        this.dt = dt;
    }

    public TriModel() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getCv() {
        return cv;
    }

    public void setCv(double cv) {
        this.cv = cv;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "model{" + "a=" + a + ", b=" + b + ", c=" + c + ", cv=" + cv + ", dt=" + dt + '}';
    }
  
   
    public boolean isAbove(double a){
        if (a>0){
            return true;
        }
        else return false;
    }

 
     public  boolean isTamGiac(double a, double b, double c) {
         if ( (a + b > c) && (a + c > b) && (b + c > a)){
             return true;
         }
        else return false;
    }

    public  double tinhChuVi(double a, double b, double c) {
        return a + b + c;
    }

  
    public  double tinhDienTich(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

   
    public  double tinhChuViTamGiacDeu(double side) {
        return 3 * side;
    }

 
    public  double tinhDienTichTamGiacDeu(double side) {
        return (Math.sqrt(3) / 4) * side * side;
    }
   
}
     

