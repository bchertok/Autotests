package sberoad.appmanager;

public class DBArrays3random {
    public static String documentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
        return registryPid;
    }
    public static String documentFromInventorystatecode1() {
        // документ находящийся в описи и созданный вручную111
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (01)" +
                "AND ug.CODE in (0, 3)" +
                "AND ud.INVENTORY_PID IS NOT NULL", "CODE");
        return registryPid;
    }

    // ШК электронного действующего документа
    public static String electronicdocumentBarcodeinstate(String states) {
        // действующие документы со статусами (перечислить)
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOCUMENT ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "inner join DOCUMENTFORM ug on ud.FORMCODE_PID=ug.PID\n" +
                "where uz.CODE in (" + states +")" +
                "AND ug.CODE in (1, 2)" +
                "AND ud.INVENTORY_PID IS NULL", "CODE");
        return registryPid;
    }
    public static String inventoryBarcodeinstate(String states) {
        // описи со статусами (перечислить)
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join INVENTORY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join INVENTORYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static String dailybindingBarcodeinstate(String states) {
        // сшивы со статусами (перечислить)
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DAILYBINDING ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static String dossierBarcodeinstate(String states) {
        // заверш. делопроизводство документы со статусами (перечислить)
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,ud.PID from BARCODEINFO u \n" +
                "inner join DOSSIER ud on ud.PID=u.ENTITY_PID\n" +
                "inner join DOCUMENTSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (" + states +")", "CODE");
        return registryPid;
    }
    public static String registryBarcodein12() {
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE in (01,02)", "CODE");
        return registryPid;
    }
    public static String registryBarcodein37() {
        DB db1 = new DB();
        String registryPid = db1.getRandomValue("select u.CODE, uz.CODE,u.PID from BARCODEINFO u \n" +
                "inner join REGISTRY ud on ud.PID=u.ENTITY_PID\n" +
                "inner join REGISTRYSTATE uz on ud.STATECODE_PID=uz.PID\n" +
                "where uz.CODE BETWEEN '03' and '07'", "CODE");
        return registryPid;
    }
}
