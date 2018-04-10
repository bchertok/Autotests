package sberoad.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.Randoms;

public class RegistryAS3 extends TestBase {
    // случайный ШК в поле ШК реестра
    @Test
    public void registryAS3var1() throws InterruptedException {
        application.getNavigation().ToNewRegistry();
        Randoms random = new Randoms();
        Thread.sleep(500);
        for (int i=0;i<20;i++ ) {

            application.getRegistryHelper().fillRegitryform(null, null, random.randomBarcodeCrash());
            String errorText = application.getHelperBase().getText(By.cssSelector("div.f-error"));
            System.out.println(random.randomBarcodeCrash());
            Assert.assertEquals(errorText, "Неверный формат штрих-кода.");
        }
    }
    // Случайный ШК в поле Шк объекта
    @Test
    public void registryAS3var2() throws InterruptedException {
        application.getNavigation().ToNewRegistry();
        Randoms random = new Randoms();
        Thread.sleep(500);
        for (int i=0;i<20;i++ ) {
            System.out.println(random.randomBarcodeCrash());
            application.getRegistryHelper().fillObjectBarcode(random.randomBarcodeCrash());
            String errorText = application.getHelperBase().getText(By.cssSelector("form.input-group > div.f-element.f-element-text.has-error.inline > div.f-error"));
            Assert.assertEquals(errorText, "Неверный формат штрих-кода");
        }
    }







}
