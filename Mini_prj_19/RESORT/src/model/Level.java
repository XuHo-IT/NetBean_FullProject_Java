package model;

public class Level {
    protected String Intermediate;
    protected String College;
    protected String University;
    protected String Postgraduate;

    public Level(String intermediate, String college, String university, String postgraduate) {
        Intermediate = intermediate;
        College = college;
        University = university;
        Postgraduate = postgraduate;
    }

    public Level() {
    }

    public String getIntermediate() {
        return Intermediate;
    }

    public void setIntermediate(String intermediate) {
        Intermediate = intermediate;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getPostgraduate() {
        return Postgraduate;
    }

    public void setPostgraduate(String postgraduate) {
        Postgraduate = postgraduate;
    }
}
