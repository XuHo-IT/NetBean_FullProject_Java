package model;

import java.util.Date;

public class Human {
    private int humanId;
    private String humanName;
    private Date humanDob;
    private boolean humanGender;
    private HumanType humanType;

    public Human(int humanId, String humanName, Date humanDob, boolean humanGender, HumanType humanType) {
        this.humanId = humanId;
        this.humanName = humanName;
        this.humanDob = humanDob;
        this.humanGender = humanGender;
        this.humanType = humanType;
    }

    public Human() {}

    // Getter and Setter methods

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Date getHumanDob() {
        return humanDob;
    }

    public void setHumanDob(Date humanDob) {
        this.humanDob = humanDob;
    }

    public boolean getHumanGender() {
        return humanGender;
    }

    public void setHumanGender(boolean humanGender) {
        this.humanGender = humanGender;
    }

    public HumanType getHumanType() {
        return humanType;
    }

    public void setHumanType(HumanType humanType) {
        this.humanType = humanType;
    }

    @Override
    public String toString() {
        return "Human{" + "humanId=" + humanId + ", humanName=" + humanName + ", humanDob=" + humanDob + ", humanGender=" + humanGender + ", humanType=" + humanType + '}';
    }
}
