package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.List;

public class RegistryAS4 extends TestBase {
    // Меняем случайное на действующие документы
    @Test
    public void registryAS4var1() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT WHERE FORMCODE != 01 AND FORMCODE != 02 AND STATECODE=02 AND INVENTORY_ID IS NULL OR STATECODE=04 AND FORMCODE != 01 AND FORMCODE != 02 AND INVENTORY_ID IS NULL", "BARCODE");
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            int i = 0;
            System.out.println(s);
            Thread.sleep(1000);
            Randoms randomType = new Randoms();
            String randomDocumentType = randomType.randomDocumentType();
            application.getRegistryHelper().fillRegitryform(randomDocumentType, null, null);
            System.out.println(randomDocumentType);
            application.getRegistryHelper().fillObjectBarcode(s);
            // текст с выпадающего списка
            Thread.sleep(1500);
            String txt = application.getHelperBase().getTextContent(By.xpath("//div[3]/div[2]/div/div"));
            Assert.assertEquals(txt, "Действующие документы");
            application.getRegistryHelper().chekBoxAll();
            application.getRegistryHelper().deleteButton();
            i++;
            if (i == 20) {
                return;
            }
        }
    }

    // Меняем случайное на ЗАВ.ДЕЛОПР.
    @Test
    public void registryAS4var2() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOSSIER", "BARCODE");
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            int i = 0;
            System.out.println(s);
            Thread.sleep(1000);
            Randoms randomType = new Randoms();
            String randomDocumentType = randomType.randomDocumentType();
            application.getRegistryHelper().fillRegitryform(randomDocumentType, null, null);
            System.out.println(randomDocumentType);
            application.getRegistryHelper().fillObjectBarcode(s);
            // текст с выпадающего списка
            Thread.sleep(1000);
            String txt = application.getHelperBase().getTextContent(By.xpath("//div[3]/div[2]/div/div"));
            Assert.assertEquals(txt, "Документы завершенного делопроизводства");
            application.getRegistryHelper().chekBoxAll();
            application.getRegistryHelper().deleteButton();
            i++;
            if (i == 20) {
                return;
            }
        }

    }

    // Меняем случайное на СШИВЫ
    @Test
    public void registryAS4var3() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING", "BARCODE");
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            int i = 0;
            System.out.println(s);
            Thread.sleep(1000);
            Randoms randomType = new Randoms();
            String randomDocumentType = randomType.randomDocumentType();
            application.getRegistryHelper().fillRegitryform(randomDocumentType, null, null);
            System.out.println(randomDocumentType);
            application.getRegistryHelper().fillObjectBarcode(s);
            // текст с выпадающего списка
            Thread.sleep(1000);
            String txt = application.getHelperBase().getTextContent(By.xpath("//div[3]/div[2]/div/div"));
            Assert.assertEquals(txt, "Сшивы документов дня");
            application.getRegistryHelper().chekBoxAll();
            application.getRegistryHelper().deleteButton();
            i++;
            if (i == 20) {
                return;
            }
        }

    }
}
