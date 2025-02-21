package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

public class DBContext {

    private Connection connect;
    
    public DBContext() {
        try {
            String user = "sa";
            String pass = "sa";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Human;encrypt=true;trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<>();
        try {
            String sql = "select h.humanId, h.humanName, h.humanDob, h.humangender, ht.typeid, ht.typename "
                    + "from Human h INNER JOIN Humantype ht on h.typeId=ht.typeId";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Human h = new Human();
                h.setHumanId(rs.getInt("humanId"));
                h.setHumanName(rs.getString("humanName"));
                h.setHumanDob(rs.getDate("humanDob"));
                h.setHumanGender(rs.getBoolean("humangender"));
                HumanType ht = new HumanType();
                ht.setTypeId(rs.getInt("typeid"));
                ht.setTypeName(rs.getString("typename"));
                h.setHumanType(ht); // Set the HumanType
                humans.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return humans;
    }
     public void deleteHuman(int humanId) {
        try {
            String sql = "DELETE FROM Human WHERE humanId = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, humanId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addHuman(Human human) {
        try {
            String sql = "INSERT INTO Human (humanId, humanName, humanDob, humanGender, typeId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, human.getHumanId());
            statement.setString(2, human.getHumanName());
            statement.setDate(3, new java.sql.Date(human.getHumanDob().getTime()));
            statement.setBoolean(4, human.getHumanGender());
            statement.setInt(5, human.getHumanType().getTypeId()); // Use typeId from HumanType
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<HumanType> getTypes() {
        ArrayList<HumanType> types = new ArrayList<>();
        try {
            String sql = "select * from HumanType";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HumanType ht = new HumanType();
                ht.setTypeId(rs.getInt("typeid"));
                ht.setTypeName(rs.getString("typename"));
                types.add(ht);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return types;
    }
}
