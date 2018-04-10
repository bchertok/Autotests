package sberoad.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;
import sberoad.appmanager.Randoms;

import java.util.List;

public class RegistryAddObject extends TestBase{
    // Добавление валидных значений
    @Test
    public void registryAddObjectVar() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT WHERE STATECODE = 01 AND ID > 1293 AND FORMCODE != 01 AND FORMCODE != 02", "BARCODE");

        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);
            application.getRegistryHelper().fillObjectBarcode(s);
            String errorText = application.getHelperBase().getText(By.cssSelector("form.input-group > div.f-element.f-element-text.has-error.inline > div.f-error"));
            System.out.println(errorText);
            Thread.sleep(350);
        }
    }

// АС 16 Добавляем ШК дока со статусом 03
    @Test
    public void registryAddObjectVar1() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT WHERE STATECODE = 03 AND FORMCODE != 01 AND FORMCODE != 02", "BARCODE");


        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);
            application.getRegistryHelper().fillObjectBarcode(s);
            String errorText = application.getHelperBase().getText(By.cssSelector("form.input-group > div.f-element.f-element-text.has-error.inline > div.f-error"));
            Assert.assertEquals(errorText,"Добавление объекта в статусе «Не подтвержден» невозможно");
            Thread.sleep(350);
        }
    }

    // АС 16 Добавляем ШК дока со статусом 07
    @Test
    public void registryAddObjectVar2() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT WHERE STATECODE = 07 AND FORMCODE != 01 AND FORMCODE != 02", "BARCODE");

        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);
            application.getRegistryHelper().fillObjectBarcode(s);
            String errorText = application.getHelperBase().getText(By.cssSelector("form.input-group > div.f-element.f-element-text.has-error.inline > div.f-error"));
            Assert.assertEquals(errorText,"Добавление объекта в статусе «Получен» невозможно");
            Thread.sleep(350);
        }
    }
    // АС 16 Добавляем ШК дока со статусом 09
    @Test
    public void registryAddObjectVar3() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT WHERE STATECODE = 09 AND FORMCODE != 01 AND FORMCODE != 02", "BARCODE");

        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);
            application.getRegistryHelper().fillObjectBarcode(s);
            String errorText = application.getHelperBase().getText(By.cssSelector("form.input-group > div.f-element.f-element-text.has-error.inline > div.f-error"));
            Assert.assertEquals(errorText,"Добавление объекта в статусе «Зарегистрирован» невозможно");
            Thread.sleep(350);
        }
    }
}

