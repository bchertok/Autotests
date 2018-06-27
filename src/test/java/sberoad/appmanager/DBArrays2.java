package sberoad.appmanager;

import java.util.List;

public class DBArrays2 {

    // Айди реестров
    public static List<String> inventoryBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171175", "CODE");
        return registryPid;
    }

    public static List<String> documentBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171177", "CODE");
        return registryPid;
    }

    public static List<String> boxBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171178", "CODE");
        return registryPid;
    }

    public static List<String> transportUnitBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171179", "CODE");
        return registryPid;
    }

    public static List<String> waybillBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171180", "CODE");
        return registryPid;
    }

    public static List<String> dailybindingBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171181", "CODE");
        return registryPid;
    }

    public static List<String> dossierBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 171182", "CODE");
        return registryPid;
    }

    public static List<String> fileboxBarcode() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO WHERE ENTITY_TYPE_PID = 179538", "CODE");
        return registryPid;
    }
    public static List<String> registryBarcodein12() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (01,02)", "CODE");
        return registryPid;
    }
    public static List<String> registryBarcodein37() {
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE BETWEEN '03' and '07'", "CODE");
        return registryPid;
    }
    public static List<String> documentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
        return registryPid;
    }
    public static List<String> electronicdocumentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (1, 2)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
        return registryPid;
    }
    public static List<String> inventoryBarcodeinstate(String states) {
        // описи со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static List<String> dailybindingBarcodeinstate(String states) {
        // сшивы со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DAILYBINDING ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static List<String> dossierBarcodeinstate(String states) {
        // заверш. делопроизводство документы со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOSSIER ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static String registryStateFromDB(String regBarcode) {
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("SELECT UD.CODE FROM REGISTRYSTATE UD\n" +
                "INNER JOIN REGISTRY U ON U.STATECODE_PID=UD.PID\n" +
                "INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "WHERE UZ.CODE = '" + regBarcode + "'", "CODE");
        return registryPid;
    }
    public static String documentStateFromDB(String docBarcode) {
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("SELECT UD.CODE FROM DOCUMENTSTATE UD\n" +
                "        INNER JOIN DOCUMENT U ON U.STATECODE_PID=UD.PID\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + docBarcode + "'", "CODE");
        return registryPid;
    }
    public static String ifDocumenthaveInventory(String docBarcode) {
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("SELECT U.INVENTORY_PID FROM DOCUMENT U\n" +
                "        INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID=U.PID\n" +
                "        WHERE UZ.CODE  = '" + docBarcode + "'", "INVENTORY_PID");
        return registryPid;
    }

    public static String regestryItemDoc(String regBarcode) {
        DB db1 = new DB();
        String docPid = db1.getRandomValue("SELECT RE.DOCUMENT_PID FROM REGISTRYITEM RE\n" +
                "    INNER JOIN BARCODEINFO UZ ON UZ.ENTITY_PID = RE.REGISTRY_PID\n" +
                "    WHERE UZ.CODE  = '" + regBarcode + "'", "DOCUMENT_PID");
        String registryPid = db1.getRandomValue("SELECT CODE FROM BARCODEINFO\n" +
                "    WHERE ENTITY_PID  = '" + docPid +  "'","CODE" );
        return registryPid;
    }

    public static List<String> documentInInventoryBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        List<String> registryPid = db1.getAllValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS  NOT NULL", "CODE");
        return registryPid;
    }


}
