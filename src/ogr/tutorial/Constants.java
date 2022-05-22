package ogr.tutorial;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ME99735 on 27.07.2018 - 12:24
 * part of project: tutorialProject
 */
public class Constants {
    public static final String jdbcUrl = "jdbc:h2:file:./tutorialDb";
    public static final String jdbcDriver = "org.h2.jdbc.Driver";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, "root", "sifre");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Veritabanına bağlanılamıyor!", "HATA", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return null;
    }
}
