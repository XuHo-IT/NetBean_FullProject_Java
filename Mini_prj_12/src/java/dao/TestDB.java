package dao;


public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CountryService countryService = new CountryService();
        System.out.println("" + countryService.findCountries(3, 5));
        System.out.println("" + countryService.getNumberOfRows());
    }

}
