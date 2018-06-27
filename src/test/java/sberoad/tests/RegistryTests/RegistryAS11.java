package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

public class RegistryAS11 extends TestBase {
    @Test
    public void AS11var1() throws InterruptedException {
        // перепривязка в реестр из описи документа в статусе 1
        Thread.sleep(300);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        application.getRegistryHelper().registryBarcode1();
        Randoms rnd = new Randoms();
        String barcodeReg = rnd.randomBarcode();
        System.out.println("Шк реестра      " + barcodeReg);
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        Thread.sleep(100);
        application.getRegistryHelper().documentType("1");
        String document = DBArrays3random.documentFromInventorystatecode1();
        System.out.println("ШК документа в описи в статусе 1      " + document);
        application.getRegistryHelper().addObject(document);
        Thread.sleep(1500);
        String noty = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(noty, "Данный документ добавлен в неотправленную опись. Осуществить привязку данного документа к текущему реестру?ДаОтмена");
        application.getRegistryHelper().okeyToNotyfication();
        Thread.sleep(3000);
        System.out.println("Статус документа, должен стать 5      " + DBArrays2.documentStateFromDB(document));
        Assert.assertEquals(DBArrays2.documentStateFromDB(document), "05");
        System.out.println("есть ли у документа опись, должно быть null        " + DBArrays2.ifDocumenthaveInventory(document));
//     Assert.assertEquals(DBArrays2.ifDocumenthaveInventory(document),"null");
        System.out.println("документ находящийся в этом реестре, должен быть тот, который мы добавили       " + DBArrays2.registryItemDoc(barcodeReg));
        Assert.assertEquals(DBArrays2.registryItemDoc(barcodeReg), document);
    }

    @Test
    public void AS11var2() throws InterruptedException {
        // из реестра 01-02 в реестр документ со статусом 05
        Thread.sleep(300);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(500);
        application.getRegistryHelper().registryBarcode1();
        Randoms rnd = new Randoms();
        String barcodeReg = rnd.randomBarcode();
        System.out.println("Шк реестра      " + barcodeReg);
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        Thread.sleep(100);
        application.getRegistryHelper().documentType("1");
        String document = DBArrays3random.documentBarcodeinstate("5");
        System.out.println("ШК документа в статусе 5 из реестра 1-2      " + document);
        String regWhereDocWas = DBArrays2.registryWhereDocWas(document);
        System.out.println("Реестр где был документ раньше" + regWhereDocWas);
        String docpid = DBArrays2.documentPid(document);
        System.out.println("Pid Документа, который мы перепривязываем        " + docpid);
        application.getRegistryHelper().addObject(document);
        Thread.sleep(1500);
        String noty = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(noty, "Данный документ добавлен в неотправленный реестр. Осуществить привязку данного документа к текущему реестру?ДаОтмена");
        application.getRegistryHelper().okeyToNotyfication();
        Thread.sleep(3000);
        System.out.println("Статус документа, должен стать 5      " + DBArrays2.documentStateFromDB(document));
        Assert.assertEquals(DBArrays2.documentStateFromDB(document), "05");
        System.out.println("есть ли у документа опись, должно быть null        " + DBArrays2.ifDocumenthaveInventory(document));
        Assert.assertEquals(DBArrays2.ifDocumenthaveInventory(document), null);
        System.out.println("документ находящийся в этом реестре, должен быть тот, который мы добавили       " + DBArrays2.registryItemDoc(barcodeReg));
        Assert.assertEquals(DBArrays2.registryItemDoc(barcodeReg), document);
        String isoldRegistryitemclear = DBArrays2.documentFromRegestryWhereDocWas(regWhereDocWas);
        System.out.println("в старом реестре не должно быть этой записи в registryitem      " + isoldRegistryitemclear);
    }

}