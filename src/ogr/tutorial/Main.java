package ogr.tutorial;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        adresDao dao = new adresDao();
        Scanner scanner = new Scanner(System.in);
        for (Adres adr : dao.getAll()) {
            System.out.println(adr);
            System.out.println("===========================");
            if (adr.getId() == 4) {
                System.out.print("id: ");
                String id = scanner.next();
                System.out.print("il: ");
                String il = scanner.next();
                System.out.print("mahalle: ");
                String mahalle = scanner.next();
                System.out.print("sokak: ");
                String sokak= scanner.next();

                adr.setIl(il);
                adr.setMahalle(mahalle);
                adr.setSokak(sokak);


            }
        }

        /*System.out.print("Delete which?: ");

        int id = scanner.nextInt();*/
        
//        dao.delete(id);
        Constants.getConnection().close();
    }
}
