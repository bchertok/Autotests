package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

public class Registry extends TestBase {
    @Test
    public void RegistryV1() throws InterruptedException {
        // Действующие документы
        Randoms rnd = new Randoms();
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().documentType("1");
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        Thread.sleep(1000);
        String barcodeDoc = DBArrays3random.documentBarcodeinstate("02");
        application.getRegistryHelper().addObject(barcodeDoc);
        Thread.sleep(3200);
        String regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate,"1");
        String docstate = DBArrays2.documentStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate,"5");

Thread.sleep(100000);
        application.getRegistryHelper().finishForming();
       regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate,"2");
        docstate = DBArrays2.documentStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate,"5");
    }
    // Сшивы
    // Описи

}
