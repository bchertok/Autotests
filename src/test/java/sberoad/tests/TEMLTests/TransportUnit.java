package sberoad.tests.TEMLTests;

import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.DBArraysTEML;
import sberoad.appmanager.RandomFromList;
import sberoad.exception.FailedDocumentStateException;
import sberoad.tests.TestBase;

public class TransportUnit extends TestBase {

    @Test
    public void TransportUnitMain() throws InterruptedException, FailedDocumentStateException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewTransportUnit();
        String barcodeReg = DBArraysTEML.registryBarcodeinStatesAndNotinTEML("01,02");
//        System.out.println(DBArraysTEML.registryBarcodeinStatesInTEML("01,02"));
        System.out.println(barcodeReg);
        application.getTransportunitHelper().addItem(barcodeReg);
        Thread.sleep(5000);
        RandomFromList rnd = new RandomFromList(DBArraysTEML.TEinStatesWithorWithoutTE("1", "is null"));
        String id = (String) rnd.randomElementfromList();
        String barcodeTE = DBArrays3random.selectFromBarcodeinfoWhereEntityPid(id);
        System.out.println(barcodeTE);
        application.getTransportunitHelper().addItem(barcodeTE);
    }
}
