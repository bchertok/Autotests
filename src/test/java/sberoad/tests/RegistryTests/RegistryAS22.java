package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.exception.FailedDocumentStateException;
import sberoad.tests.TestBase;

import java.util.List;

public class RegistryAS22 extends TestBase {
    private Randoms rnd = new Randoms();

    @Test
    public void RegistryAS22var1() throws InterruptedException {
        // удаление документа загруженного из АБС
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        // ШК документа в статусе 2
        String docabs1 = DBArrays3random.documentBarcodeinstate("02");
        application.getRegistryHelper().addObject(docabs1);
        Thread.sleep(4000);
        String docstate = DBArrays2.documentStateFromDB(docabs1);
        Assert.assertEquals(docstate, "05");
        // Смотрим регестриитем
        String registry = DBArrays2.registryPIDFromRegItem(docabs1, "DOCUMENT_PID");
        Assert.assertNotEquals(registry, null);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(500);
        docstate = DBArrays2.documentStateFromDB(docabs1);
        Assert.assertEquals(docstate, "02");
        registry = DBArrays2.registryPIDFromRegItem(docabs1, "DOCUMENT_PID");
        Assert.assertEquals(registry, null);
    }

    @Test
    public void RegistryAS22var2() throws InterruptedException {
        // Удаление документа добавленного вручную
// zhdem 5 AS
    }

    @Test
    public void RegistryAS22var3() throws InterruptedException {
        // Удаление Сшива загруженного из АБС
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        // ШК документа в статусе 2
        String docabs1 = DBArrays3random.dailybindingBarcodeinstate("02");
        application.getRegistryHelper().addObject(docabs1);
        Thread.sleep(4000);
        String docstate = DBArrays2.dailybindingStateFromDB(docabs1);
        Assert.assertEquals(docstate, "05");
        // Смотрим регестриитем
        String registry = DBArrays2.registryPIDFromRegItem(docabs1, "DAILYBINDING_PID");
        Assert.assertNotEquals(registry, null);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(500);
        docstate = DBArrays2.dailybindingStateFromDB(docabs1);
        Assert.assertEquals(docstate, "02");
        registry = DBArrays2.registryPIDFromRegItem(docabs1, "DAILYBINDING_PID");
        Assert.assertEquals(registry, null);
    }

    @Test
    public void RegistryAS22var4() throws InterruptedException {
        // Удаление Сшива добавленного вручную
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("3");
        application.getRegistryHelper().addDailybinding();
        Thread.sleep(1000);
        // получаем айди сшива в этом реестре через regestryitem
        List<String> dailybindingID = DBArrays2.registryItemEntityID(barcodeReg, "DAILYBINDING_PID");
        System.out.println(dailybindingID);

        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(900);
        // Смотрим регестриитем
        List<String> regitem = DBArrays2.registryItemEntityID(barcodeReg, "DAILYBINDING_PID");
        for (String z : regitem) {
            Assert.assertEquals(z, null);
        }
        // Смотрим Баркодинфо
        for (String s : dailybindingID) {
            Assert.assertEquals(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s), null);
            // Смотри в сам сшив
            Assert.assertEquals(DBArrays3random.selectFromTABLEWhereEntityPid("DAILYBINDING", s), null);
        }
    }

    @Test
    public void RegistryAS22var5() throws InterruptedException {
        // Удаление корреспонденции добавленной вручную
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("4");
        application.getRegistryHelper().addothercorrespondence();
        Thread.sleep(4000);
        // получаем айди correspondence в этом реестре
        List<String> correspondenceID = DBArrays2.registryItemEntityID(barcodeReg, "OTHERCORRESPONDENCE_PID");
        System.out.println(correspondenceID);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(1000);
        // Смотрим регестриитем
        List<String> regitem = DBArrays2.registryItemEntityID(barcodeReg, "OTHERCORRESPONDENCE_PID");
        for (String z : regitem) {
            Assert.assertEquals(z, null);
        }
        // Смотрим Баркодинфо
        for (String s : correspondenceID) {
            Assert.assertEquals(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s), null);
            // Смотри в сам correspondence
            Assert.assertEquals(DBArrays3random.selectFromTABLEWhereEntityPid("OTHERCORRESPONDENCE", s), null);
        }

    }

    @Test
    public void RegistryAS22var6() throws InterruptedException {
        // Удаление делопроизводства добавленной вручную
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("2");
        Thread.sleep(200);
        application.getRegistryHelper().addDossier();
        Thread.sleep(4000);
        // получаем айди correspondence в этом реестре
        List<String> correspondenceID = DBArrays2.registryItemEntityID(barcodeReg, "DOSSIER_PID");
        System.out.println(correspondenceID);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(1000);
        // Смотрим регестриитем
        List<String> regitem = DBArrays2.registryItemEntityID(barcodeReg, "DOSSIER_PID");
        for (String z : regitem) {
            Assert.assertEquals(z, null);
        }
        // Смотрим Баркодинфо
        for (String s : correspondenceID) {
            Assert.assertEquals(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s), null);
            // Смотри в сам correspondence
            Assert.assertEquals(DBArrays3random.selectFromTABLEWhereEntityPid("DOSSIER_PID", s), null);
        }
    }

    @Test
    public void RegistryAS22var7() throws InterruptedException, FailedDocumentStateException {
        // Удаление описи загруженной из АБС
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        String invabs1 = DBArrays3random.inventoryFromAbs("04");
        System.out.println("шк описи" + invabs1);
        application.getRegistryHelper().addObject(invabs1);
        Thread.sleep(4000);
        // id этой описи
        String invID = DBArrays3random.selectFromBarcodeinfoWhereBARCODE(invabs1);
        // статус самой описи
        String invstate = DBArrays2.inventoryStateFromDB(invabs1);
        Assert.assertEquals(invstate, "05");
        // Статус документов в описи
        List<String> docsates = DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println(docsates);
        boolean z = docsates.stream().allMatch(s -> s.equals("05"));
        Assert.assertEquals(z, true);
        Thread.sleep(200);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(3000);
        // Смотрим регестриитем
        Assert.assertEquals(DBArrays2.registryPIDFromRegItem(invabs1, "INVENTORY_PID"), null);
        // статус описи
        invstate = DBArrays2.inventoryStateFromDB(invabs1);
        Assert.assertEquals(invstate, "04");
        // статус документов в описи
        docsates = DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println(docsates);
        for (Object s : docsates) {
            if (!s.equals("01") && !s.equals("02")) {
                throw new FailedDocumentStateException("не тот статус документов");
            }
        }
    }

    @Test
    public void RegistryAS22var8() throws InterruptedException, FailedDocumentStateException {
        // Удаление описи добавленной вручную
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().toNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        String invabs1 = DBArrays3random.inventoryNotFromAbs("04");
        System.out.println("шк описи" + invabs1);
        application.getRegistryHelper().addObject(invabs1);
        Thread.sleep(4000);
        // id этой описи
        String invID = DBArrays3random.selectFromBarcodeinfoWhereBARCODE(invabs1);
        // статус самой описи
        String invstate = DBArrays2.inventoryStateFromDB(invabs1);
        Assert.assertEquals(invstate, "05");
        // Статус документов в описи
        List<String> docsates = DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println(docsates);
        boolean z = docsates.stream().allMatch(s -> s.equals("05"));
        Assert.assertEquals(z, true);
        Thread.sleep(200);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(3000);
        // Смотрим регестриитем
        Assert.assertEquals(DBArrays2.registryPIDFromRegItem(invabs1, "INVENTORY_PID"), null);
        // статус описи
        invstate = DBArrays2.inventoryStateFromDB(invabs1);
        Assert.assertEquals(invstate, "04");
        // статус документов в описи
        docsates = DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println(docsates);
        for (Object s : docsates) {
            if (!s.equals("01") && !s.equals("02")) {
                throw new FailedDocumentStateException("не тот статус документов");
            }
        }
    }
}
