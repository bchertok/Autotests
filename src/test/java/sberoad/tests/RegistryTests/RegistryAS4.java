package sberoad.tests.RegistryTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.tests.TestBase;
import java.util.Random;

public class RegistryAS4 extends TestBase {
// АС 4 и 19
    @Test
    public void registryAS4new() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            Random rnd = new Random();
            int z = rnd.nextInt(3);
            if (z == 0) {
                application.getRegistryHelper().documentType("1");
                application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("02"));
                Thread.sleep(4500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Сшивы документов дня");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
                Thread.sleep(2500);
            }
            if (z == 1) {
                application.getRegistryHelper().documentType("3");
                application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("02"));
                Thread.sleep(4500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Действующие документы");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
                Thread.sleep(2500);
            }
            if (z == 2) {
                application.getRegistryHelper().documentType("3");
                String barcode = DBArrays3random.inventoryBarcodeinstate("04");
                System.out.println("ШК описи"+barcode);
                application.getRegistryHelper().addObject(barcode);
                Thread.sleep(4500);
                System.out.println(application.getRegistryHelper().getdocumentType());
                Assert.assertEquals(application.getRegistryHelper().getdocumentType(), "Действующие документы");
                application.getRegistryHelper().chekBoxAll();
                application.getRegistryHelper().deleteButton();
                Thread.sleep(2500);
            }
        }
    }
}
