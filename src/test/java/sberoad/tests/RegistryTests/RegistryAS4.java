package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.List;
import java.util.Random;

public class RegistryAS4 extends TestBase {
// АС 4 и 19
    @Test
    public void registryAS4new() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        Randoms random = new Randoms();
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            Random rnd = new Random();
            int z = rnd.nextInt(3);
            if (z == 0) {
                application.getRegistryHelper().documentType(random.randomNumberOfDocumentType());
                application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("02"));
                Thread.sleep(3500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Сшивы документов дня");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
            }
            if (z == 1) {
                application.getRegistryHelper().documentType(random.randomNumberOfDocumentType());
                application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("02"));
                Thread.sleep(3500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Действующие документы");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
            }
            if (z == 2) {
                application.getRegistryHelper().documentType(random.randomNumberOfDocumentType());
                application.getRegistryHelper().addObject(DBArrays3random.inventoryBarcodeinstate("04"));
                Thread.sleep(3500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Действующие документы");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
            }
        }
    }
}
