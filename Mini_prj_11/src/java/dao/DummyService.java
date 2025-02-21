package dao;


import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dummy;

/**
 *
 * @author Ly Quynh Tran
 */
public class DummyService implements IDummyService {

 @Override
public List<Dummy> findDummies(int currentPage, int recordsPerPage) {
    ConnectDB db = ConnectDB.getInstance();
    List<Dummy> dummies = new ArrayList<>();
    try {
        Connection con = db.openConnection();

        int start = currentPage * recordsPerPage - recordsPerPage + 1;
        int end = currentPage * recordsPerPage;
        
        String sql = "SELECT id, name "
                   + "FROM ("
                   + "    SELECT id, name, ROW_NUMBER() OVER (ORDER BY id) AS RowNumber "
                   + "    FROM DummyTBL"
                   + ") AS paginated "
                   + "WHERE RowNumber BETWEEN ? AND ?";
                   
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, start);
        ps.setInt(2, end);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Dummy dummy = new Dummy();
            int id = rs.getInt("id");
            dummy.setId(id);
            String name = rs.getString("name");
            dummy.setName(name);
            dummies.add(dummy);
        }
    } catch (Exception ex) {
        Logger.getLogger(DummyService.class.getName()).log(Level.SEVERE, null, ex);
    }

    return dummies;
}


    public Integer getNumberOfRows() {
        ConnectDB db = ConnectDB.getInstance();
        Integer numOfRows = 0;

        try {
            Connection con = db.openConnection();
            String sql = "SELECT COUNT(*) AS numOfRows FROM DummyTBL";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numOfRows = rs.getInt("numOfRows");
            }
        } catch (Exception ex) {
            Logger.getLogger(DummyService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numOfRows;
    }

}
