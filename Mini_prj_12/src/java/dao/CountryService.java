package dao;

import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Country;

/**
 *
 * @author Ly Quynh Tran
 */
public class CountryService implements ICountryService {

    @Override
    public List<Country> findCountries(int currentPage, int recordsPerPage) {
        ConnectDB db = ConnectDB.getInstance();
        List<Country> countries = new ArrayList<>();
        try {
            Connection con = db.openConnection();

            int start = currentPage * recordsPerPage - recordsPerPage;
            System.out.println("start" + start);
            int end = recordsPerPage * currentPage;
            System.out.println("end " + end);
            System.out.println("record" + recordsPerPage);
            String sql = "With coun AS\n"
                    + "( SELECT id, name,population,\n"
                    + "ROW_NUMBER() OVER (order by id) as RowNumber \n"
                    + "FROM countries )\n"
                    + "select *\n"
                    + "from coun\n"
                    + "Where RowNumber Between ? and ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                String name = rs.getString(2);
                country.setName(name);
                long population = rs.getLong(3);
                country.setPopulation(population);
                countries.add(country);
            }
        } catch (Exception ex) {
            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return countries;
    }

    public Integer getNumberOfRows() {
        ConnectDB db = ConnectDB.getInstance();
        Integer numOfRows = 0;

        try {
            Connection con = db.openConnection();
            String sql = "SELECT * FROM countries";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                numOfRows++;
            }

        } catch (Exception ex) {
            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numOfRows;
    }

}
