package dao;

import java.util.List;
import model.Dummy;

 public interface IDummyService{

    List<Dummy> findDummies(int currentPage, int numOfRecords);

    Integer getNumberOfRows();
}
