package sberoad.tests.RegistryTests;

import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.tests.TestBase;

public class RegistryAS11 extends TestBase {
    @Test
    public void AS11var1 () throws InterruptedException
    // для основного сценария документ ИЗ описи со статусом 1
    {
        Thread.sleep(250);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().documentType("1");
        String docfromInv1 = DBArrays3random.documentFromInventorystatecode1();
        application.getRegistryHelper().addObject(docfromInv1);
        Thread.sleep(100000);
    }
}
