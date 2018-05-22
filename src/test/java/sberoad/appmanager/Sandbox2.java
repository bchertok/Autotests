package sberoad.appmanager;


public class Sandbox2 {
    public static void main(String[] args) {
        System.out.println("Вообще Все контракты");
        System.out.println(DocumentContractHelper.allDocID().size());
        System.out.println(DocumentContractHelper.allDocID());
        System.out.println("==========================");
        System.out.println("Все контракты с несколькими документами");
        System.out.println(DocumentContractHelper.contractWithManyDoc());
        System.out.println("==========================");
        System.out.println("Все контракты с 1 документом");
        System.out.println(DocumentContractHelper.contractWithOneDoc());
        System.out.println("==========================");
        System.out.println("Документы которых нет в баркодинфо");
        System.out.println(DBArrays.documentWithoutBarcodeinfo());
        System.out.println("==========================");
        System.out.println("Документы доступные для добавления в реестр");
        System.out.println(DBArrays.normalDocuments());
        System.out.println("==========================");
        System.out.println("1.  Договоры, по которым есть 1 документ, не включенный в реестр и/или опись, с атрибутом formCode = 0 ");
        System.out.println(DBArrays.zapros1());
        System.out.println("==========================");
        System.out.println("2.  Договоры, по которым есть 1 документ, не включенный в реестр и/или опись, с атрибутом formCode = 3 ");
        System.out.println(DBArrays.zapros2());
        System.out.println("==========================");
        System.out.println("3. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору еще нет описей ");
        System.out.println(DBArrays.zapros3());
        System.out.println("==========================");
        System.out.println("4. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y), по договору еще нет описей ");
        System.out.println(DBArrays.zapros4());
        System.out.println("==========================");
        System.out.println("5. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y)," +
                " по договору есть описи в статусах Не подтвержден/Подтвержден");
        System.out.println(DBArrays.zapros5());
        System.out.println("==========================");
        System.out.println("6. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y)," +
                " по договору есть описи в статусах Не подтвержден/Подтвержден");
        System.out.println(DBArrays.zapros6());
        System.out.println("==========================");
        System.out.println("7. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y)," +
                " по договору есть описи в  cтатусах отличных от Не подтвержден/Подтвержден (Включен в реестр, Отправлен, Получен, Не получен, Зарегистрирован)");
        System.out.println(DBArrays.zapros7());
        System.out.println("==========================");
        System.out.println("8. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, проставлен признак Требуется формирование описи (inventory_obligatory = Y)," +
                " по договору есть описи в  cтатусах отличных от Не подтвержден/Подтвержден (Включен в реестр, Отправлен, Получен, Не получен, Зарегистрирован)\n");
        System.out.println(DBArrays.zapros8());
        System.out.println("==========================");
        System.out.println("9.  Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 0, у КБП, к которой относятся договоры, НЕ проставлен признак Требуется формирование описи (inventory_obligatory = N)");
        System.out.println(DBArrays.zapros9());
        System.out.println("==========================");
        System.out.println("10. Договоры, по которым есть несколько документов, не включенных в реестр и/или опись, с атрибутом formCode = 3, у КБП, к которой относятся договоры, НЕ проставлен признак Требуется формирование описи (inventory_obligatory = N)");
        System.out.println(DBArrays.zapros10());
        System.out.println("==========================");
        System.out.println("11. Договоры, по которым нет документов, не включенных в реестр и/или опись ");
        System.out.println(DBArrays.zapros11());
        System.out.println("==========================");
        System.out.println("12. Обязательные документы в статусе Загружен, не добавленные в реестры и описи, имеющиу связки с договорами.");
        System.out.println(DBArrays.zapros12());
    }
}
