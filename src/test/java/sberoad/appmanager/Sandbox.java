package sberoad.appmanager;

import java.util.List;

public class Sandbox {

    public void documentWithoutBarcodeinfo ()
    {
            // ШК ДЕЙСТВУЮЩИХ ДОКУМЕНТОВ которых нет в баркодинфо
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
        public void normalDocuments() {
            // ВСЕ ШК ДЕЙСТВУЮЩИХ ДОСТУПНЫХ ДЛЯ ДОБАВЛЕНИЯ В РЕЕСТР

            DB db = new DB();
            List<String> barcode = db.toAS5("SELECT " +
                            "* FROM DOCUMENT WHERE FORMCODE != 01 AND FORMCODE != 02 AND STATECODE=02 AND INVENTORY_ID IS NULL "
                    , "ID", "BARCODE");

            for (String s : barcode) {
                System.out.println(s);
            }
        }
    }