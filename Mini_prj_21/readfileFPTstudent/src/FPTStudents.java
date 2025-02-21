public class FPTStudents implements Comparable<FPTStudents> {
 private String ID;
 private String Name;
 private int Age;
 private String Major;
 private double gpa;

    public FPTStudents(String ID, String name, int age, String major, double gpa) {
        this.ID = ID;
        Name = name;
        Age = age;
        Major = major;
        this.gpa = gpa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public FPTStudents() {
    }

    @Override
    public String toString() {
        return "This student:" + "ID= " + ID + ", Name= " + Name  +
                ", Age=" + Age +
                ", Major= " + Major +
                ", gpa=" + gpa
                ;
    }

    @Override
    public int compareTo(FPTStudents o) {
        return Double.toString(this.gpa).compareTo(Double.toString(o.getGpa()));
    }
}
