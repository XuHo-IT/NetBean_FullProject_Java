
package Database;


public class Student {

    private String sno;
    private String sname;
    private String course;

    public Student() {
    }

    public Student(String sno, String sname, String course) {
        this.sno = sno;
        this.sname = sname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "sno=" + sno + ", sname=" + sname + ", course=" + course + '}';
    }
    
}