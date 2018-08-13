package sberoad.tests.TEMLTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.DBArraysTEML;
import sberoad.appmanager.RandomFromList;
import sberoad.exception.FailedDocumentStateException;
import sberoad.tests.TestBase;


public class TransportunitAS9 extends TestBase{
    @Test public void AS9() throws InterruptedException, FailedDocumentStateException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewTransportUnit();
        String barcodeReg = DBArraysTEML.registryBarcodeinStatesAndNotinTEML("01");
        System.out.println(barcodeReg);
        application.getTransportunitHelper().addItem(barcodeReg);
        Thread.sleep(1000);
        String regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "02");
        RandomFromList rnd = new RandomFromList(DBArraysTEML.TEinStatesWithorWithoutTE("1", "is null",false,false));
        String id = (String) rnd.randomElementfromList();
        String barcodeTE = DBArrays3random.selectFromBarcodeinfoWhereEntityPid(id);
        System.out.println(barcodeTE);
        application.getTransportunitHelper().addItem(barcodeTE);
        Thread.sleep(1000);
        String testate = DBArraysTEML.TransportUnitState(id);
        Assert.assertEquals(testate, "178251");
    }
}
