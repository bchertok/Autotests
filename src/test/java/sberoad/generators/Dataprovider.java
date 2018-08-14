package sberoad.generators;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dataprovider {


    @DataProvider(name = "data1")
    public Iterator<Object[]> dataProviderTest() throws Exception {

        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\BChertok\\Documents\\GitHub\\Autotests\\src\\test\\resources\\xxx.txt"));
        return lines.map(line -> {
            final String[] data = line.split(" ");
            String login = data[0];
            String password = data[1];
            String phone = data[2];
            String email = data[3];
            String code = data[4];

            Object[] o = new Object[5];
            o[0] = login;
            o[1] = password;
            o[2] = phone;
            o[3] = email;
            o[4] = code;
            return o;
        }).collect(Collectors.toList()).iterator();

    }

    @Test(dataProvider = "data1")

    public void RandomTest(String userName, String password, String phone, String email, String code) throws IOException {
        System.out.println(String.format("%s %s %s %s %s", userName, password, phone, email, code));

    }
}