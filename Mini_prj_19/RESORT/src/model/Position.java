package model;

public class Position {
    protected String Receptionist;
    protected String Server;
    protected String Specialist;
    protected String Supervisor;
    protected String Manager;
    protected String Director;

    public Position(String receptionist, String server, String specialist, String supervisor, String manager, String director) {
        Receptionist = receptionist;
        Server = server;
        Specialist = specialist;
        Supervisor = supervisor;
        Manager = manager;
        Director = director;
    }

    public Position() {
    }

    public String getReceptionist() {
        return Receptionist;
    }

    public void setReceptionist(String receptionist) {
        Receptionist = receptionist;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String server) {
        Server = server;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String specialist) {
        Specialist = specialist;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }
}
