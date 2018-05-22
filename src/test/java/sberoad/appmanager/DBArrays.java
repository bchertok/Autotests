package sberoad.appmanager;

import java.util.List;

public class DBArrays {


    public static List<String> allBarcodeFromBarcodeinfo() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO", "CODE");
        return barcodeInfo;
    }

    // 1.  Договоры, по которым есть 1 документ, не включенный в реестр и/или опись, с атрибутом formCode = 0
    public static List<String> zapros1() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT\n" +
                "  C.DOCNUMBER DOCNUMBER,\n" +
                "  count(C.DOCNUMBER) CNT\n" +
                "FROM CONTRACT C\n" +
                "  join DOCUMENT_CONTRACT DC on C.ID = DC.CONTRACT_ID\n" +
                "  join DOCUMENT D on DC.DOCUMENT_ID = D.ID\n" +
                "where D.FORMCODE in (0)\n" +
                "AND D.STATECODE = 2\n" +
                "and D.INVENTORY_ID IS NULL\n" +
                "group by C.DOCNUMBER\n" +
                "having count(C.DOCNUMBER) = 1", "DOCNUMBER");
        return barcodeInfo;
    }

    // 2.  Договоры, по которым есть 1 документ, не включенный в реестр и/или опись, с атрибутом formCode = 3
    public static List<String> zapros2() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT\n" +
                "  C.DOCNUMBER DOCNUMBER,\n" +
                "  count(C.DOCNUMBER) CNT\n" +
                "FROM CONTRACT C\n" +
                "  join DOCUMENT_CONTRACT DC on C.ID = DC.CONTRACT_ID\n" +
                "  join DOCUMENT D on DC.DOCUMENT_ID = D.ID\n" +
                "where D.FORMCODE in (3)\n" +
                "AND D.STATECODE = 2\n" +
                "and D.INVENTORY_ID IS NULL\n" +
                "group by C.DOCNUMBER\n" +
                "having count(C.DOCNUMBER) = 1", "DOCNUMBER");
        return barcodeInfo;
    }

    //3. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП,
    // к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору еще нет описей
    public static List<String> zapros3() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select C.ID, C.DOCNUMBER\n" +
                "from (select\n" +
                "        C.ID,\n" +
                "        C.DOCNUMBER\n" +
                "      from CONTRACT C\n" +
                "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                            FROM CONTRACT C\n" +
                "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                            WHERE D.FORMCODE IN (0)\n" +
                "                                  AND D.STATECODE = 2\n" +
                "                                  AND D.INVENTORY_ID IS NULL\n" +
                "                            GROUP BY C.DOCNUMBER\n" +
                "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
                "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
                "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
                "where I.CONTRACT_ID IS NULL", "DOCNUMBER");
        return barcodeInfo;
    }
    public static List<String> documentWithoutBarcodeinfo() {
        // ШК ДЕЙСТВУЮЩИХ ДОКУМЕНТОВ которых нет в баркодинфо
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT", "BARCODE");
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT " +
                "CODE FROM BARCODEINFO", "CODE");
        barcode.removeAll(barcodeInfo);
        return barcode;
    }

    public static List<String> normalDocuments() {
        // ВСЕ ШК ДЕЙСТВУЮЩИХ ДОСТУПНЫХ ДЛЯ ДОБАВЛЕНИЯ В РЕЕСТР
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                        "* FROM DOCUMENT WHERE FORMCODE != 01 AND FORMCODE != 02 AND STATECODE=02 AND INVENTORY_ID IS NULL "
                ,  "BARCODE");
        return barcode;
    }

    //4. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП,
    // к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору еще нет описей
    public static List<String> zapros4() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select C.ID, C.DOCNUMBER\n" +
                "from (select\n" +
                "        C.ID,\n" +
                "        C.DOCNUMBER\n" +
                "      from CONTRACT C\n" +
                "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                            FROM CONTRACT C\n" +
                "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                            WHERE D.FORMCODE IN (3)\n" +
                "                                  AND D.STATECODE = 2\n" +
                "                                  AND D.INVENTORY_ID IS NULL\n" +
                "                            GROUP BY C.DOCNUMBER\n" +
                "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
                "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
                "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
                "where I.CONTRACT_ID IS NULL", "DOCNUMBER");
        return barcodeInfo;
    }

//5. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0,
// у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору есть описи в статусах Не подтвержден/Подтвержден
    public static List<String> zapros5() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select\n" +
                "  C.ID,\n" +
                "  C.DOCNUMBER\n" +
                "from (select\n" +
                "        C.ID,\n" +
                "        C.DOCNUMBER\n" +
                "      from CONTRACT C\n" +
                "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                            FROM CONTRACT C\n" +
                "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                            WHERE D.FORMCODE IN (0)\n" +
                "                                  AND D.STATECODE = 2\n" +
                "                                  AND D.INVENTORY_ID IS NULL\n" +
                "                            GROUP BY C.DOCNUMBER\n" +
                "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
                "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
                "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
                "where\n" +
                "  I.CONTRACT_ID IS NOT NULL\n" +
                "  and I.STATECODE in (3, 4)\t", "DOCNUMBER");
        return barcodeInfo;
    }

    //6. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3,
// у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору есть описи в статусах Не подтвержден/Подтвержден
    public static List<String> zapros6() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select\n" +
                "  C.ID,\n" +
                "  C.DOCNUMBER\n" +
                "from (select\n" +
                "        C.ID,\n" +
                "        C.DOCNUMBER\n" +
                "      from CONTRACT C\n" +
                "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                            FROM CONTRACT C\n" +
                "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                            WHERE D.FORMCODE IN (3)\n" +
                "                                  AND D.STATECODE = 2\n" +
                "                                  AND D.INVENTORY_ID IS NULL\n" +
                "                            GROUP BY C.DOCNUMBER\n" +
                "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
                "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
                "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
                "where\n" +
                "  I.CONTRACT_ID IS NOT NULL\n" +
                "  and I.STATECODE in (3, 4)\t", "DOCNUMBER");
        return barcodeInfo;
    }

//7. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи
// (inventory_obligatory = Y),по договору есть описи в  cтатусах отличных от Не подтвержден/Подтвержден (Включен в реестр, Отправлен, Получен, Не получен, Зарегистрирован)
public static List<String> zapros7() {
    DB db1 = new DB();
    List<String> barcodeInfo = db1.getAllValue("select\n" +
            "  C.ID,\n" +
            "  C.DOCNUMBER\n" +
            "from (select\n" +
            "        C.ID,\n" +
            "        C.DOCNUMBER\n" +
            "      from CONTRACT C\n" +
            "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
            "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
            "                            FROM CONTRACT C\n" +
            "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
            "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
            "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
            "                            WHERE D.FORMCODE IN (0)\n" +
            "                                  AND D.STATECODE = 2\n" +
            "                                  AND D.INVENTORY_ID IS NULL\n" +
            "                            GROUP BY C.DOCNUMBER\n" +
            "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
            "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
            "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
            "where\n" +
            "  I.CONTRACT_ID IS NOT NULL\n" +
            "  and I.STATECODE in (5,6,7,8,9,10)\t", "DOCNUMBER");
    return barcodeInfo;
}

    //8. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи
// (inventory_obligatory = Y),по договору есть описи в  cтатусах отличных от Не подтвержден/Подтвержден (Включен в реестр, Отправлен, Получен, Не получен, Зарегистрирован)
    public static List<String> zapros8() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select\n" +
                "  C.ID,\n" +
                "  C.DOCNUMBER\n" +
                "from (select\n" +
                "        C.ID,\n" +
                "        C.DOCNUMBER\n" +
                "      from CONTRACT C\n" +
                "        join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "      where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                            FROM CONTRACT C\n" +
                "                              JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                              JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                              JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                            WHERE D.FORMCODE IN (3)\n" +
                "                                  AND D.STATECODE = 2\n" +
                "                                  AND D.INVENTORY_ID IS NULL\n" +
                "                            GROUP BY C.DOCNUMBER\n" +
                "                            HAVING count(C.DOCNUMBER) >= 2)\n" +
                "            and p.INVENTORY_OBLIGATORY = 'Y')\n" +
                "     C LEFT join INVENTORY I on I.CONTRACT_ID = C.ID\n" +
                "where\n" +
                "  I.CONTRACT_ID IS NOT NULL\n" +
                "  and I.STATECODE in (5,6,7,8,9,10)\t", "DOCNUMBER");
        return barcodeInfo;
    }

//9.  Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, НЕ проставлен признак Требуется формирование описи (inventory_obligatory = N)
    public static List<String> zapros9() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("select\n" +
                "  C.ID,\n" +
                "  C.DOCNUMBER\n" +
                "from CONTRACT C\n" +
                "  join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                      FROM CONTRACT C\n" +
                "                        JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                        JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                        JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                      WHERE D.FORMCODE IN (0)\n" +
                "                            AND D.STATECODE = 2\n" +
                "                            AND D.INVENTORY_ID IS NULL\n" +
                "                      GROUP BY C.DOCNUMBER\n" +
                "                      HAVING count(C.DOCNUMBER) >= 2)\n" +
                "      and p.INVENTORY_OBLIGATORY = 'N'", "DOCNUMBER");
        return barcodeInfo;
    }

    //10.  Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, НЕ проставлен признак Требуется формирование описи (inventory_obligatory = N)
    public static List<String> zapros10() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("\t  select\n" +
                "  C.ID,\n" +
                "  C.DOCNUMBER\n" +
                "from CONTRACT C\n" +
                "  join PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "where C.DOCNUMBER in (SELECT DOCNUMBER\n" +
                "                      FROM CONTRACT C\n" +
                "                        JOIN DOCUMENT_CONTRACT DC ON C.ID = DC.CONTRACT_ID\n" +
                "                        JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "                        JOIN PRODUCT P on C.PRODUCT_ID = P.ID\n" +
                "                      WHERE D.FORMCODE IN (3)\n" +
                "                            AND D.STATECODE = 2\n" +
                "                            AND D.INVENTORY_ID IS NULL\n" +
                "                      GROUP BY C.DOCNUMBER\n" +
                "                      HAVING count(C.DOCNUMBER) >= 2)\n" +
                "      and p.INVENTORY_OBLIGATORY = 'N'", "DOCNUMBER");
        return barcodeInfo;
    }


    //  11. Договоры, по которым нет документов, не включенных в реестр и/или опись
    public static List<String> zapros11() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT  DISTINCT docnumber FROM contract\n" +
                "                 WHERE DOCNUMBER not in (\n" +
                "                        SELECT \n" +
                "                        uz.DOCNUMBER from DOCUMENT_CONTRACT u \n" +
                "                        inner join DOCUMENT ud on u.DOCUMENT_ID=ud.ID\n" +
                "                        inner join CONTRACT uz on uz.ID=u.CONTRACT_ID\n" +
                "                        where (ud.STATECODE in (2) and ud.INVENTORY_ID is null)\n" +
                "                        )", "DOCNUMBER");
        return barcodeInfo;
    }

    // 12. Обязательные документы в статусе Загружен, не добавленные в реестры и описи, имеющиу связки с договорами.
    public static List<String> zapros12() {
        DB db1 = new DB();
        List<String> barcodeInfo = db1.getAllValue("SELECT DISTINCT DC.DOCUMENT_ID\n" +
                "FROM DOCUMENT_CONTRACT DC\n" +
                "  JOIN CONTRACT C ON DC.CONTRACT_ID = C.ID\n" +
                "  JOIN DOCUMENT D ON DC.DOCUMENT_ID = D.ID\n" +
                "  JOIN PRODUCT P ON C.PRODUCT_ID = P.ID\n" +
                "  JOIN PRODUCT_DOCUMENTKIND PD ON P.ID = PD.PRODUCT_ID AND D.DOCUMENTKIND_ID = PD.DOCUMENTKIND_ID\n" +
                "WHERE D.FORMCODE IN (0, 3)\n" +
                "      AND D.STATECODE = 2\n" +
                "      AND D.INVENTORY_ID IS NULL\n" +
                "      AND PD.CONTROL_OBLIGATORY = 'Y'", "DOCUMENT_ID");
        return barcodeInfo;
    }

    // ШК всех описей
    public static List<String> allInventoryBarcode() {
    DB db = new DB();
    List<String> barcode = db.getAllValue("SELECT " +
            "BARCODE FROM INVENTORY", "BARCODE");
        return barcode;
    }

    // ШК всех МЛ
    public static List<String> allWaybillsBarcode() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM WAYBILL", "BARCODE");
        return barcode;
    }

    // ШК всех ТЕ
    public static List<String> allTransportUnitBarcode() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM TRANSPORTUNIT", "BARCODE");
        return barcode;
    }


    // ШК всех доков Завершенного делопроизводства
    public static List<String> allDossiertBarcode() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOSSIER", "BARCODE");
        return barcode;
    }

    // ШК всех Сшивов ДД
    public static List<String> allDailybindingBarcode() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING", "BARCODE");
        return barcode;
    }

    // ШК  Сшивов ДД в статусе 1,2
    public static List<String> DailybindingBarcodeIn12() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING WHERE STATECODE IN (1,2)", "BARCODE");
        return barcode;
    }
    // ШК  Сшивов ДД в статусе 5
    public static List<String> allDailybindingBarcodeIn5() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING WHERE STATECODE IN (5)", "BARCODE");
        return barcode;
    }
    // ШК  Сшивов ДД в статусе 6
    public static List<String> allDailybindingBarcodeIn6() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING WHERE STATECODE IN (6)", "BARCODE");
        return barcode;
    }
    // ШК  Сшивов ДД в статусе 7 и 9
    public static List<String> allDailybindingBarcodeIn79() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING WHERE STATECODE IN (7,9)", "BARCODE");
        return barcode;
    }
    // ШК  Сшивов ДД в статусе 8
    public static List<String> allDailybindingBarcodeIn8() {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING WHERE STATECODE IN (8)", "BARCODE");
        return barcode;
    }







}