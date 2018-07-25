package sberoad.appmanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class DB {
    private static Properties properties = getProperties();
    private static String url = properties.getProperty("url");
    private static String user = properties.getProperty("username");
    private static String password = properties.getProperty("password");

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
//            properties.load(DB.class.getClassLoader().getResourceAsStream("db.properties"));
            properties.load(new FileInputStream("src/test/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
//    public static void main (String[] args){}

    public String getRandomValue(String sql, String columnLabel) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            con = DriverManager.getConnection(url, user, password);

            //step3 create the statement object
            stmt = con.createStatement();

            //step4 execute query;   sql- it is parametr for DB table
            rs = stmt.executeQuery(sql);
            List<String> list = new ArrayList<>();

            //add info from DBto list;  columnLabel - it is parametr for DB column
            while (rs.next()) {
                list.add(rs.getString(columnLabel));
            }

//      list.forEach(System.out::println);
//            System.out.println(list.size());

            Random random = new Random();
            int num = random.nextInt(list.size());
//          System.out.println(list.get(num));

            return list.get(num);


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                //step5 close the connection object
                con.close();
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    public List<String> getAllValue(String sql, String columnLabel) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            con = DriverManager.getConnection(url, user, password);

            //step3 create the statement object
            stmt = con.createStatement();

            //step4 execute query;   sql- it is parametr for DB table
            rs = stmt.executeQuery(sql);
            List<String> list = new ArrayList<>();
            //add info from DBto list;  columnLabel - it is parametr for DB column
            while (rs.next()) {
                list.add(rs.getString(columnLabel));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                //step5 close the connection object
                con.close();
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<String> toAS5(String sql, String columnLabel, String columnLabe2) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            con = DriverManager.getConnection(url, user, password);

            //step3 create the statement object
            stmt = con.createStatement();

            //step4 execute query;   sql- it is parametr for DB table
            rs = stmt.executeQuery(sql);
            List<String> list = new ArrayList<>();
            //add info from DBto list;  columnLabel - it is parametr for DB column
            while (rs.next()) {
                list.add(rs.getString(columnLabel));
                list.add(rs.getString(columnLabe2));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                //step5 close the connection object
                con.close();
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
