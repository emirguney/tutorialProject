package ogr.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Adressdao {
    Connection c= Constants.getConnection();

    public void save(Adress adress){
        try {

            Statement stm = c.createStatement();

            String query = "insert into T_ADRESS(id,city,country,Street) values ('" + adress.getId() + "','" + adress.getCity() + "','" + adress.getCountry() + "','" + adress.getStreet() + "')";

            stm.executeQuery(query);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Adress> getAll() {
        try {
            Statement stm = c.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from T_ADRESS");
            List<Adress> adress = new ArrayList<Adress>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                String county = resultSet.getString("county");
                String Street = resultSet.getString("Street");
                Adress adres = new Adress();
                adres.setId(id);
                adres.setCity(city);
                adres.setCountry(county);
                adres.setStreet(Street);
                adress.add(adres);
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
