package sberoad.tests.RegistryTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.ArrayList;
import java.util.List;


public class RegistryAS2 extends TestBase {
    // введен шк реестра в статусе 1 или 2 и пользователь выбрал нет
    @Test
    public void registryAS2var1() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        application.getRegistryHelper().registryBarcode1();
        String s = DBArrays2.registryBarcodeinStates("01,02");
        System.out.println(s);
        Thread.sleep(500);
        application.getRegistryHelper().registryBarcode2(s);
        Thread.sleep(300);
        String notification = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notification, "В системе уже имеется реестр с таким штрих-кодом. Открыть реестр на редактирование?ДаОтмена");
        Thread.sleep(300);
        application.getRegistryHelper().noToNotyfication();

    }

    // реестры которые должны быть открыты на просмотр
    @Test
    public void registryAS2var2() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        application.getRegistryHelper().registryBarcode1();
        String barcode = DBArrays2.registryBarcodeinStates("03,04,05,06,07");
        System.out.println(barcode);
        application.getRegistryHelper().registryBarcode2(barcode);
        Thread.sleep(200);
        String notification = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notification, "В системе уже имеется реестр с таким штрих-кодом. Открыть реестр на просмотр?ДаОтмена");
        application.getRegistryHelper().okeyToNotyfication();
        Thread.sleep(300);
        Thread.sleep(10000000);
    }


    // реестры которые должны быть открыты на редактирование
    @Test
    public void registryAS2var3() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        application.getRegistryHelper().registryBarcode1();
        String barcode = DBArrays2.registryBarcodeinStates("01,02");
        System.out.println(barcode);
        application.getRegistryHelper().registryBarcode2(barcode);
        Thread.sleep(200);
        String notification = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notification, "В системе уже имеется реестр с таким штрих-кодом. Открыть реестр на редактирование?ДаОтмена");
        application.getRegistryHelper().okeyToNotyfication();
        Thread.sleep(300);

        Thread.sleep(10000000);
    }

    // Шк Описи
    @Test
    public void registryAS2var4() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.inventoryBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Thread.sleep(2300);
            Assert.assertEquals(notification, "Данный штрих-код принадлежит описи. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // Шк Документа
    @Test
    public void registryAS2var5() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.documentBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит документу. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);

        }
    }

    // ШК МЛ
    @Test
    public void registryAS2var6() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.waybillBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит МЛ. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК ТЕ
    @Test
    public void registryAS2var7() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.transportUnitBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит ТЕ. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК ЗАВ. ДЕЛОПР
    @Test
    public void registryAS2var8() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.dossierBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит документу. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК СШИВА
    @Test
    public void registryAS2var9() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.dailybindingBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит документу. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК Файлового бокса
    @Test
    public void registryAS2var10() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.fileboxBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит ФБ. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }

    // ШК Архивного короба
    @Test
    public void registryAS2var11() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        Thread.sleep(100);
        application.getNavigation().ToNewRegistry();
        Thread.sleep(1000);
        Randoms rnd = new Randoms();
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().registryBarcode1();
        for (String s : DBArrays2.boxBarcode()) {
            System.out.println(s);
            application.getRegistryHelper().registryBarcode2(s);
            Thread.sleep(200);
            String notification = application.getRegistryHelper().getnotificationtext();
            Assert.assertEquals(notification, "Данный штрих-код принадлежит АК. Введите другое значение");
//            application.getRegistryHelper().okeyToNotyfication();
//            application.getRegistryHelper().okeyToNotyfication();
            Thread.sleep(300);
        }
    }
}