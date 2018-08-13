package sberoad.tests.TEMLTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArraysTEML;
import sberoad.tests.TestBase;

public class TransportUnitAS5and6 extends TestBase {
    private String reg1;
    private String reg2;
    private String tebarcode;

    @BeforeTest
    public void before() throws InterruptedException {
        TransportUnit2reg tu2r = new TransportUnit2reg();
        tu2r.transportunit2R(false);
        reg1 = tu2r.getReg1();
        reg2 = tu2r.getReg2();
        tebarcode = tu2r.getTEbarcode();
    }

    @Test
    public void as5and5() throws InterruptedException {
        Thread.sleep(500);
        application.getTransportunitHelper().deleteItem();
        application.getTransportunitHelper().deleteItem();
        Thread.sleep(1000);
        Assert.assertEquals(DBArraysTEML.reginTE(tebarcode), null);
        application.getTransportunitHelper().closeTab();
        Thread.sleep(1000);
        Assert.assertEquals(DBArraysTEML.tefromTransportunit(tebarcode), null);

    }
}
