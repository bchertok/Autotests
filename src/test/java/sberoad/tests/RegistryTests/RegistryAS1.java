package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.tests.TestBase;

public class RegistryAS1 extends TestBase {
    @Test
    public void registryAS1() throws InterruptedException {
        String subdivision = "г.Санкт-Петербург Доп.офис №9055/01108";
       // application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        Thread.sleep(2000);
//        application.getRegistryHelper().fillRegitryform("действующие", subdivision, null);
//        application.getRegistryHelper().openObjectSearch();
//        Thread.sleep(1000);
//        application.getRegistryHelper().openSubdivisionSearch();

        String podrazdeleniyeOtpravitel = application.getHelperBase().getTextContent(By.xpath("//span/div"));
        String sP = application.getHelperBase().getTextContent(By.xpath("//form/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/span/div"));
        Assert.assertEquals(sP,podrazdeleniyeOtpravitel);

    }
}
