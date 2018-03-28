package sberoad.appmanager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DB {
    private static String url = "";
    private static String user = "";
    private static String password = "";

    public static void main(String[] args) {
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con = DriverManager.getConnection(url, user, password);

            //step3 create the statement object
            Statement stmt = con.createStatement();

            //step4 execute query
            ResultSet rs = stmt.executeQuery("select * from BARCODEINFO");
            List<String> list = new ArrayList<>();
            while (rs.next()) {
//                System.out.println(rs.getString("CODE"));
                list.add(rs.getString("CODE"));
            }

            list.forEach(System.out::println);

            System.out.println(list.size());

            //step5 close the connection object
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
