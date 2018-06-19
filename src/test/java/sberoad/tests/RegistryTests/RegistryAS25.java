package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.tests.TestBase;

public class RegistryAS25 extends TestBase {

// ШК только что добавили в реестр, повторынй ввод
    @Test
    public void registryAS25var1() throws InterruptedException {
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().documentType("1");
        String barcode = DBArrays3random.documentBarcodeinstate("2");
        application.getRegistryHelper().addObject(barcode);
        Thread.sleep(400);
        application.getRegistryHelper().addObject(barcode);
//      String  notification = application.getRegistryHelper().getTextContent(By.xpath());
//        Assert.assertEquals(notification,"");
    }


    // ШК только что добавили в опись которая в этом реестре, повторынй ввод
    @Test
    public void registryAS25var2() throws InterruptedException {
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
    }
}
