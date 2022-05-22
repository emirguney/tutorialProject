package ogr.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class adresDao {
    Connection c = Constants.getConnection();

    public void save(Adres adr) {
        try {
            Statement stm = c.createStatement();

            String query = "insert into T_ADRES(id, il, mahalle, sokak) values('" + adr.getId() + "' ,'" + adr.getIl() + "' ,'" + adr.getMahalle() + "' ,'" + adr.getSokak() + "')";
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Adres> getAll() {
        try {
            Statement stm = c.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from T_ADRES");
            List<Adres> adress = new ArrayList<Adres>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String il = resultSet.getString("il");
                String mahalle = resultSet.getString("mahalle");
                String sokak = resultSet.getString("sokak");
                Adres adr = new Adres();
                adr.setId(id);
                adr.setIl(il);
                adr.setMahalle(mahalle);
                adr.setSokak(sokak);

            }

            resultSet.close();
            stm.close();
            return adress;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;



    }
}
