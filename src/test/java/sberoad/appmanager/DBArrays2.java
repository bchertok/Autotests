package sberoad.appmanager;

import java.util.List;

public class DBArrays2 {

    // Айди реестров
    public static List<String> inventoryBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171175", "CODE");
    }

    public static List<String> documentBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171177", "CODE");
    }

    public static List<String> boxBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171178", "CODE");
    }

    public static List<String> transportUnitBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171179", "CODE");
    }

    public static List<String> waybillBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171180", "CODE");
    }

    public static List<String> dailybindingBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171181", "CODE");
    }

    public static List<String> dossierBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171182", "CODE");
    }

    public static List<String> fileboxBarcode() {
        DB db1 = new DB();
        return db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 179538", "CODE");
    }

    public static List<String> registryBarcodein12() {
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (01,02)", "CODE");
    }

    public static List<String> registryBarcodein37() {
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE BETWEEN '03' and '07'", "CODE");
    }

    public static List<String> documentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states + ")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
    }

    public static List<String> electronicdocumentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states + ")" +
                "AND ug.CODE in (1, 2)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
    }

    public static List<String> inventoryBarcodeinstate(String states) {
        // описи со статусами (перечислить)
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states + ")", "CODE");
    }

    public static List<String> dailybindingBarcodeinstate(String states) {
        // сшивы со статусами (перечислить)
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DAILYBINDING ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states + ")", "CODE");
    }

    public static String registryStateFromDB(String regBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT UD.CODE FROM REGISTRYSTATE UD\n" +
                "INNER JOIN REGISTRY U ON U.STATECODE_PID=UD.PID\n" +
                "INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "WHERE UZ.CODE = '" + regBarcode + "'", "CODE");
    }

    public static String documentStateFromDB(String docBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT UD.CODE FROM DOCUMENTSTATE UD\n" +
                "        INNER JOIN DOCUMENT U ON U.STATECODE_PID=UD.PID\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + docBarcode + "'", "CODE");
    }

    public static String dailybindingStateFromDB(String dailybindingBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT UD.CODE FROM DOCUMENTSTATE UD\n" +
                "        INNER JOIN DAILYBINDING U ON U.STATECODE_PID=UD.PID\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + dailybindingBarcode + "'", "CODE");
    }

    public static String inventoryStateFromDB(String docBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT UD.CODE FROM INVENTORYSTATE UD\n" +
                "        INNER JOIN INVENTORY U ON U.STATECODE_PID=UD.PID\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + docBarcode + "'", "CODE");
    }

    public static String ifDocumenthaveInventory(String docBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT U.INVENTORY_PID FROM DOCUMENT U\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + docBarcode + "'", "INVENTORY_PID");
    }

    public static String documentPid(String docBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT ENTITY_PID FROM BARCODEINFO\n" +
                "        WHERE CODE  = '" + docBarcode + "'", "ENTITY_PID");
    }


    // не уверен, что будет нужно
    public static String registryWhereDocWas(String regBarcode) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT RE.REGISTRY_PID FROM REGISTRYITEM RE\n" +
                "    INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID = RE.DOCUMENT_PID\n" +
                "    WHERE UZ.CODE  = '" + regBarcode + "'", "REGISTRY_PID");
    }
    //

    public static List<String> registryItemEntityID(String regBarcode, String ENTITY) {
        // вводим id реестра и сущность, получаем id сущности
        DB db1 = new DB();
        return db1.getAllValue("SELECT RE." + ENTITY + " FROM REGISTRYITEM RE\n" +
                "    INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID = RE.REGISTRY_PID\n" +
                "    WHERE UZ.CODE  = '" + regBarcode + "'", ENTITY);
    }

    public static String registryPIDFromRegItem(String barcode, String ENTITY) {
// ВВОдим ШК сущности и сущность, получаем id реестра

        DB db1 = new DB();
        return db1.getRandomValue("SELECT RE.REGISTRY_PID FROM REGISTRYITEM RE\n" +
                "    INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID = RE." + ENTITY + "\n" +
                "    WHERE UZ.CODE  = '" + barcode + "'", "REGISTRY_PID");
    }


    public static String documentFromRegestryWhereDocWas(String regpid) {
        DB db1 = new DB();
        return db1.getRandomValue("SELECT DOCUMENT_PID FROM REGISTRYITEM\n" +
                "    WHERE REGISTRY_PID  = '" + regpid + "'", "DOCUMENT_PID");
    }


    public static List<String> documentInInventoryBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        return db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states + ")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS  NOT NULL", "CODE");
    }

    public static List<String> documentStatewithINVENTORY(String inventryPid) {
        // берем статус действующих документов, где айди описи =
        DB db1 = new DB();

        return db1.getAllValue("SELECT UD.CODE FROM DOCUMENTSTATE UD\n" +
                "        INNER JOIN DOCUMENT U ON U.STATECODE_PID=UD.PID\n" +
                "        WHERE U.INVENTORY_PID  = '" + inventryPid + "'", "CODE");
    }


}
