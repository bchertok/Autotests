package sberoad.appmanager;


import sberoad.exception.FailedDocumentStateException;


import java.util.Random;

public class Sandbox2 {
    private static Random randomGenerator;

    public static void main(String[] args) throws FailedDocumentStateException {
//        System.out.println(DBArraysTEML.registryBarcodeinStatesAndNotinTEML("04"));
//        System.out.println(DBArraysTEML.registryBarcodeinStatesInTEML("01,02"));
//        regstate = DBArrays2.registryStateFromDB(barcodeReg);
//        Assert.assertEquals(regstate, "02");


       System.out.println(DBArraysTEML.TEinStatesWithorWithoutTE("2", "is null", false));
        RandomFromList rnd = new RandomFromList(DBArraysTEML.TEinStatesWithorWithoutTE("2", "is null", false));
        System.out.println(rnd.randomElementfromList());
        String id = (String) rnd.randomElementfromList();
        System.out.println(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(id));
        System.out.println(DBArraysTEML.listWithRegistryInTE(id));

        // транспортаня единица с дочерними ТЕ
        // без дочерних те
        // в составе больше 1 объекта
        // меньше 1 объекта
    }
}
