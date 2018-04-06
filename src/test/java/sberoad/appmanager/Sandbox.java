package sberoad.appmanager;

import java.util.List;

public class Sandbox {
    public static void main (String [] args){
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT", "BARCODE");
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO", "CODE");


        System.out.println(barcode.size());
       barcode.removeAll(barcodeInfo);
        System.out.println(barcode.size());
       barcode.forEach(System.out::println);
    }
}
