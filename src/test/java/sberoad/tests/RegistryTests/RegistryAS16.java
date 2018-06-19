package sberoad.tests.RegistryTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.List;

public class RegistryAS16 extends TestBase {

    // АС 16 Добавляем ШК дока со статусом 03
    @Test
    public void registryAddObjectVar1() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(2000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        for (int i = 0; i < 20; i++) {
            application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("3"));
            Assert.assertEquals("","");
        }
        for (int i = 0; i < 20; i++) {
            application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("3"));
            Assert.assertEquals("","");
        }
        for (int i = 0; i < 20; i++) {
            application.getRegistryHelper().addObject(DBArrays3random.inventoryBarcodeinstate("3"));
            Assert.assertEquals("","");
        }
// 3 7 9 10 11
        Thread.sleep(100);
    }

}

