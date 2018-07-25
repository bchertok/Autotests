package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

public class RegistryAS25 extends TestBase {

// ШК документа только что добавили в реестр, повторынй ввод
    @Test
    public void registryAS25var1() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Randoms rnd = new Randoms();
        application.getRegistryHelper().registryBarcode1();
        String barcodeReg = rnd.randomBarcode();
        application.getRegistryHelper().registryBarcode2(barcodeReg);
        application.getRegistryHelper().documentType("1");
        String document = DBArrays3random.documentBarcodeinstate("2");
        String dailyBinding = DBArrays3random.dailybindingBarcodeinstate("2");
        application.getRegistryHelper().addObject(document);
        Thread.sleep(400);
        application.getRegistryHelper().addObject(document);
      String  notification = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notification,"В реестре уже есть документ с таким штрих-кодом: "+document);
        Thread.sleep(3000);
        application.getRegistryHelper().chekBoxAll();
        application.getRegistryHelper().deleteButton();
        Thread.sleep(1000);
        application.getRegistryHelper().addObject(dailyBinding);
        Thread.sleep(400);
        application.getRegistryHelper().addObject(dailyBinding);
        notification = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notification,"В реестре уже есть сшив с таким штрих-кодом: "+dailyBinding);
    }


    // ШК только что добавили в опись которая в этом реестре, повторынй ввод
    @Test
    public void registryAS25var2() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        String document = DBArrays3random.documentFromInventorystatecode("01", "04");
        String inventory = DBArrays3random.selectFromBarcodeinfoWhereEntityPid(DBArrays2.ifDocumenthaveInventory(document));
        application.getRegistryHelper().documentType("1");
        application.getRegistryHelper().addObject(inventory);
        Thread.sleep(4000);
        application.getRegistryHelper().addObject(document);
        String notify = application.getRegistryHelper().getnotificationtext();
        Assert.assertEquals(notify,"В описи, включенной в данный реестр, уже имеется документ с таким ШК: "+document);
    }
}
