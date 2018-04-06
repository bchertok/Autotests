package sberoad.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;

import java.util.ArrayList;
import java.util.List;


public class RegistryAS2 extends TestBase {
    // введен шк реестра и пользователь выбрал нет
    @Test
    public void registryAS2var1() throws InterruptedException {

        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM REGISTRY", "BARCODE");
        List<String> notificationList = new ArrayList<>();

        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);

        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "В системе уже имеется реестр с таким штрих-кодом. Открыть реестр на редактирование/просмотр?");
            Thread.sleep(300);
            application.getRegistryHelper().noToNotyfication();
            application.getRegistryHelper().noToNotyfication();
            Thread.sleep(300);

            String fieldForRegistryBarcode = application.getHelperBase().getTextValue(By.cssSelector("div.f-element.f-element-text.inline.f-element-barcode > div.f-control > input.input"));
            System.out.println(fieldForRegistryBarcode);

            notificationList.add(notification);
        }

        Assert.assertEquals(barcode.size(), notificationList.size());
    }


    // реестры которые должны быть открыты на просмотр
    @Test(enabled = false)
    public void registryAS2var2() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM REGISTRY WHERE STATECODE=03 OR STATECODE=04 OR STATECODE=05 OR STATECODE= 06 OR STATECODE=07", "BARCODE");

        for (String s : barcode) {
            System.out.println(s);
            application.getNavigation().startPage();
            Thread.sleep(100);
            application.getNavigation().ToNewRegistry();
            Thread.sleep(500);
            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            application.getRegistryHelper().yesToNotyfication();
            Thread.sleep(50000);

        }
    }

    // реестры которые должны быть открыты на редактирование
    @Test(enabled = false)
    public void registryAS2var3() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM REGISTRY WHERE STATECODE=01 OR STATECODE=02", "BARCODE");

        for (String s : barcode) {
            System.out.println(s);
            application.getNavigation().startPage();
            Thread.sleep(100);
            application.getNavigation().ToNewRegistry();
            Thread.sleep(500);
            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            application.getRegistryHelper().yesToNotyfication();
            Thread.sleep(50000);
        }
    }

    // Шк Описи
    @Test
    public void registryAS2var4() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM INVENTORY", "BARCODE");
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        for (String s : barcode) {
            System.out.println(s);
            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит описи. Введите другое значение");
application.getRegistryHelper().okeyToNotyfication();
            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);


        }
    }

    // Шк Документа
    @Test
    public void registryAS2var5() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOCUMENT", "BARCODE");
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит документу. Введите другое значение");
            application.getRegistryHelper().okeyToNotyfication();
            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);

        }
    }

    // ШК МЛ
    @Test
    public void registryAS2var6() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM WAYBILL", "BARCODE");
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит сущности типа Маршрутный лист");
            application.getRegistryHelper().okeyToNotyfication();
            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК ТЕ
    @Test
    public void registryAS2var7() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM TRANSPORTUNIT", "BARCODE");
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит сущности типа Транспортная единица");

        }
    }

    // ШК ЗАВ. ДЕЛОПР
    @Test
    public void registryAS2var8() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DOSSIER", "BARCODE");
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит сущности типа Досье");
            application.getRegistryHelper().okeyToNotyfication();
            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК СШИВА
    @Test
    public void registryAS2var9() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM DAILYBINDING", "BARCODE");
        System.out.println(barcode.size());
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        for (String s : barcode) {
            System.out.println(s);

            application.getRegistryHelper().fillRegitryform(null, null, s);
            Thread.sleep(300);
            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "Данный штрих-код принадлежит сущности типа Сшив");
            application.getRegistryHelper().okeyToNotyfication();
            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

}