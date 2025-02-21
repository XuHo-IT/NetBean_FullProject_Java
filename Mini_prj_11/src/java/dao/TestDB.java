package dao;


public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DummyService dummyService = new DummyService();
        System.out.println("" + dummyService.findDummies(3, 5));
        System.out.println("" + dummyService.getNumberOfRows());
    }

}
