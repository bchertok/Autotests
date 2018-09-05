package sberoad.generators;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Auth {

    private static Properties properties = getProperties();
    @Getter
    private static String dboAdminlog = properties.getProperty("dboAdminlog");
    @Getter
    private static String dboAdminpas = properties.getProperty("dboAdminpas");
    @Getter
    private static String securityAdminlog = properties.getProperty("securityAdminlog");
    @Getter
    private static String securityAdminpas = properties.getProperty("securityAdminpas");


    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/auth.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}


