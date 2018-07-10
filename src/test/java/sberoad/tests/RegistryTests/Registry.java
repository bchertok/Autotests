package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Registry extends TestBase {
    @Test
    public void RegistryV1() throws InterruptedException {
        // основной сценарий Действующие документы
        Randoms rnd = new Randoms();
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        String barcodeDoc = DBArrays3random.documentBarcodeinstate("02");
        System.out.println(barcodeDoc + "  barcode documenta");
        application.getRegistryHelper().addObject(barcodeDoc);
        Thread.sleep(5500);
        System.out.println(barcodeReg + "  barcode reestra");
        String regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "01");
        String docstate = DBArrays2.documentStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate, "05");
        List<String> regitem;
        regitem = DBArrays2.registryItemEntityID(barcodeReg, "DOCUMENT_PID");
        for (String s : regitem) {
            System.out.println(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s));
            Assert.assertEquals(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s), barcodeDoc);
        }
        application.getRegistryHelper().finishForming();
        Thread.sleep(2000);
        regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "02");
        docstate = DBArrays2.documentStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate, "05");
    }

    @Test
    public void RegistryV2() throws InterruptedException {
        // основной сценарий сшивы
        Randoms rnd = new Randoms();
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("3");
        String barcodeDoc = DBArrays3random.dailybindingBarcodeinstate("02");
        System.out.println(barcodeDoc + "  barcode sshiva");
        application.getRegistryHelper().addObject(barcodeDoc);
        Thread.sleep(5500);
        System.out.println(barcodeReg + "  barcode reestra");
        String regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "01");
        String docstate = DBArrays2.dailybindingStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate, "05");
        List<String> regitem;
        regitem = DBArrays2.registryItemEntityID(barcodeReg, "DAILYBINDING_PID");
        for (String s : regitem) {
            System.out.println(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s));
            Assert.assertEquals(DBArrays3random.selectFromBarcodeinfoWhereEntityPid(s), barcodeDoc);
        }
        application.getRegistryHelper().finishForming();
        Thread.sleep(2000);
        regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "02");
        docstate = DBArrays2.dailybindingStateFromDB(barcodeDoc);
        Assert.assertEquals(docstate, "05");
    }

    @Test
    public void RegistryV3() throws InterruptedException {
        // основной сценарий Описи
        Randoms rnd = new Randoms();
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        String barcodeInventory = DBArrays3random.inventoryBarcodeinstate("04");
        System.out.println(barcodeInventory + "  barcode inv");
        application.getRegistryHelper().addObject(barcodeInventory);
        Thread.sleep(5500);
        System.out.println(barcodeReg + "  barcode reestra");
        String regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "01");
        String invstate = DBArrays2.inventoryStateFromDB(barcodeInventory);
        Assert.assertEquals(invstate, "05");
        // проверка документов в описи
        String invID = DBArrays3random.selectFromBarcodeinfoWhereBARCODE(barcodeInventory);
        List<String> docsates = DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println("статусы документов описи включенной в реестр      " +docsates);
        boolean z = docsates.stream().allMatch(s -> s.equals("05"));
        Assert.assertEquals(z, true);
        Thread.sleep(200);
        application.getRegistryHelper().finishForming();
        Thread.sleep(2000);
        regstate = DBArrays2.registryStateFromDB(barcodeReg);
        Assert.assertEquals(regstate, "02");
        invstate = DBArrays2.inventoryStateFromDB(barcodeInventory);
        Assert.assertEquals(invstate, "05");
    }


}
