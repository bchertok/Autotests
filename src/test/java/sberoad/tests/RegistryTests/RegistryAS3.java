package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import static oracle.net.aso.C11.s;
import static oracle.net.aso.C11.z;

public class RegistryAS3 extends TestBase {
    // случайный ШК в поле ШК реестра АС3
    @Test
    public void registryAS3var1() throws InterruptedException {
        Thread.sleep(300);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Randoms random = new Randoms();
        Thread.sleep(1000);
        application.getRegistryHelper().registryBarcode1();
        int z = 1;
        while (z < 100) {
            String barcode = random.randomForBarcodeCrash(z);
            System.out.println(barcode);
            application.getRegistryHelper().registryBarcode2(barcode);
            String notification = application.getHelperBase().getinnerText(By.cssSelector("div.ant-form-explain"));
            Assert.assertEquals(notification, "Неверный формат штрих-кода.");
            z++;
        }
    }

    // Случайный ШК в поле Шк объекта АС 10
    @Test
    public void registryAS3var2() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Randoms random = new Randoms();
        Thread.sleep(1000);
        application.getRegistryHelper().documentType("1");
        int z = 1;
        while (z < 50) {
            String barcode = random.randomForBarcodeCrash(z);
            System.out.println(barcode);
            System.out.println(barcode.length());
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(500);
            String notification = application.getHelperBase().getinnerText(By.xpath("//div[3]/div/div[2]/div/div"));
            Thread.sleep(500);
            Assert.assertEquals(notification, "Неверный формат штрих-кода.");
            z++;
        }
        z = 78;
        while (z <= 100) {
            String barcode = random.randomForBarcodeCrash(z);
            System.out.println(barcode);
            System.out.println(barcode.length());
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(500);
            String notification = application.getHelperBase().getinnerText(By.xpath("//div[3]/div/div[2]/div/div"));
            Thread.sleep(500);
            Assert.assertEquals(notification, "Неверный формат штрих-кода.");
            z++;
        }
    }


    //  Корректный ШК в поле Шк объекта АС 12
    @Test
    public void registryAS3var3() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().documentType("1");
        Randoms random = new Randoms();
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            String barcode = random.randomBarcode();
            System.out.println(barcode);
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(500);
            String notification = application.getRegistryHelper().getnotificationtext();
            Thread.sleep(1500);
            Assert.assertEquals(notification, "Документ с таким штрих-кодом не найден в системе. Добавьте документ вручную.");
        }
        int z = 50;
        while (z < 78) {
            String barcode = random.randomForBarcodeCrash(z);
            System.out.println(barcode);
            System.out.println(barcode.length());
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(500);
            String notification = application.getRegistryHelper().getnotificationtext();
            Thread.sleep(1500);
            Assert.assertEquals(notification, "Документ с таким штрих-кодом не найден в системе. Добавьте документ вручную.");
            z++;
        }
    }

    //  ШК electronnogo doca в поле Шк объекта АС 13
    @Test
    public void registryAS3var4() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().documentType("1");
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            application.getRegistryHelper().addObject(DBArrays3random.electronicdocumentBarcodeinstate("2"));
            Thread.sleep(500);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Добавление электронного документа невозможно");
        }
    }


}
