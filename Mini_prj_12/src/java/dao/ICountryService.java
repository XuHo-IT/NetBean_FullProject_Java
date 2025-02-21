package dao;

import java.util.List;
import model.Country;

 public interface ICountryService {

    List<Country> findCountries(int currentPage, int numOfRecords);

    Integer getNumberOfRows();
}
