package sberoad.tests.TEMLTests;

import org.testng.annotations.Test;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

public class RegistryGenerator extends TestBase{
    private Randoms rnd = new Randoms();

    @Test
    public void registryhenerator() throws InterruptedException {
        for (int i=0; i<100; i++) {
            Thread.sleep(200);
            application.getNavigation().startPage();
            application.getNavigation().toNewRegistry();
            application.getRegistryHelper().registryBarcode1();
            String barcodeReg = rnd.randomBarcode();
            application.getRegistryHelper().registryBarcode2(barcodeReg);
            application.getRegistryHelper().documentType("3");
            application.getRegistryHelper().addDailybinding();
            Thread.sleep(1000);
            application.getRegistryHelper().finishForming();
            Thread.sleep(2000);
        }
    }
}
