package sberoad.appmanager;

public class DBArrays3random {
    private static DB db1 = new DB();
    public static String documentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)

        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.FROM_ABS in (1)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
    }
    public static String documentFromInventorystatecode(String docstatecode,String invstatecode) {
        // документ со статусом () находящийся в описи со статусом ()
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "                inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "                inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "                inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "                inner join INVENTORY ui on ud.INVENTORY_PID=ui.PID\n" +
                "                inner join INVENTORYSTATE us on ui.STATECODE_PID=us.PID\n" +
                "                where uz.CODE in (" +docstatecode+ ")\n" +
                "                AND ug.CODE in (0, 3)\n" +
                "                AND us.CODE in (" + invstatecode + ")\n" +
                "                AND ud.INVENTORY_PID IS NOT NULL", "CODE");
    }


    // ШК электронного действующего документа
    public static String electronicdocumentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (1, 2)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
    }
    public static String inventoryBarcodeinstate(String states) {
        // описи со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
    }
    public static String inventoryFromAbs(String states) {
        // описи со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ud.FROM_ABS in (1)", "CODE");
    }
    public static String inventoryNotFromAbs(String states) {
        // описи со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ud.FROM_ABS in (0)", "CODE");
    }
    public static String dailybindingBarcodeinstate(String states) {
        // сшивы со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DAILYBINDING ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
    }
    public static String dossierBarcodeinstate(String states) {
        // заверш. делопроизводство документы со статусами (перечислить)
        return db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOSSIER ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
    }

    public static String selectFromBarcodeinfoWhereEntityPid(String entity_pid) {
        return db1.getRandomValue("select CODE from BARCODEINFO  \n" +
                "where ENTITY_PID = '" + entity_pid +"' ", "CODE");
    }
    public static String selectFromBarcodeinfoWhereBARCODE(String barcode) {
        return db1.getRandomValue("select ENTITY_PID from BARCODEINFO \n" +
                "where CODE = '" + barcode +"' ", "ENTITY_PID");
    }
    public static String selectEntityTypefromBARCODEinfo(String barcode) {
        return db1.getRandomValue("select TABLE_NAME from ENTITYTYPE E \n" +
                "                inner join BARCODEINFO U on U.ENTITY_TYPE_PID = E.PID\n" +
                "                where U.CODE = '" + barcode +"'", "TABLE_NAME");
    }

    public static String selectFromTABLEWhereEntityPid(String table,String entity_pid) {
        return db1.getRandomValue("select * from "  + table + "  \n" +
                "where PID = '" + entity_pid +"' ", "CODE");
    }
    public static String ifInventorywasdowloadfromABS(String table, String entity_pid) {
        return db1.getRandomValue("select FROM_ABS from "  + table + "  \n" +
                "where PID = '" + entity_pid +"' ", "FROM_ABS");
    }

}
