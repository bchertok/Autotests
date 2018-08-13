package sberoad.tests.Catalog;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestSandbox{
    public static void main(String[] args) {
        File file = new File("src/test/resources/zzz.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.canRead());
//        Files.lines(Paths.get()).forEach(s -> System.out.println());
    }

}