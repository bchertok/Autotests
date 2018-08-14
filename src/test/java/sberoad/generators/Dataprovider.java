package sberoad.generators;

import lombok.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dataprovider {


    @DataProvider(name = "data1")
    public Iterator<Object[]> dataProviderTest() throws Exception {
//        List<Object[]> list = new ArrayList<Object[]>();
//        list.add(new Object[]{"@@", "322"});
//        list.add(new Object[]{"@2", "321"});
//        list.add(new Object[]{"22", "321"});
//        list.add(new Object[]{"@2", "321"});


//        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\BChertok\\Documents\\GitHub\\Autotests\\src\\test\\resources\\xxx.txt"));
//        lines.forEach(line -> {
//            final String[] data = line.split(" ");
//            list.add(new Object[]{data[0], data[1], data[2]});
//        });

        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\BChertok\\Documents\\GitHub\\Autotests\\src\\test\\resources\\xxx.txt"));
        return lines.map(line -> {
            final String[] data = line.split(" ");
            String login = data[0];
            String password = data[1];
            String phone = data[2];

            Object[] o = new Object[3];
            o[0] = login;
            o[1] = password;
            o[2] = phone;
            return o;
        }).collect(Collectors.toList()).iterator();
//
//        System.out.println("---------------");

//        Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\BChertok\\Documents\\GitHub\\Autotests\\src\\test\\resources\\xxx.txt"), "utf-8");
//        BufferedReader br = new BufferedReader(reader);
////        String line = br.readLine();
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
////            String[] split = line.split(";");
////            System.out.println();
////            list.add(new Object[]{line});
////            line = br.readLine();
//        }
//        return list.iterator();
    }


    @Test(dataProvider = "data1")

    public void RandomTest(String userName, String password, String phone) throws IOException {
        System.out.println(String.format("%s %s %s", userName, password, phone));
    }
}