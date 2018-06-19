package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

public class RegistryAS24 extends TestBase{
    @Test public void registryAs24var1() throws InterruptedException {
        // Добавляем действующий документ и пытаемся добавить по ШК Сшив
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Randoms rnd = new Randoms();
        Thread.sleep(300);
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("2"));
        Thread.sleep(2560);
        application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("2"));
        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),"Тип документа не соответствует типу документов реестра и добавлен не будет");
    }
    @Test public void registryAs24var2() throws InterruptedException {
        // Добавляем сшив и пытаемся добавить по ШК действующий док и опись
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Randoms rnd = new Randoms();
        Thread.sleep(300);
        application.getRegistryHelper().documentType(rnd.randomNumberOfDocumentType());
        application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("2"));
        Thread.sleep(2560);
        application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("2"));
        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                "Тип документа не соответствует типу документов реестра и добавлен не будет");
        application.getRegistryHelper().addObject(DBArrays3random.inventoryBarcodeinstate("4"));
        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                "Тип документа не соответствует типу документов реестра и добавлен не будет");
    }
//    @Test public void registryAs24var3() throws InterruptedException {
//        // Добавляем зав. делопр. и пытаемся добавить по ШК действующий док, опись и сшив
//        Thread.sleep(200);
//        application.getNavigation().startPage();
//        application.getNavigation().ToNewRegistry();
//        Randoms rnd = new Randoms();
//        Thread.sleep(300);
//        application.getRegistryHelper().documentType("2");
//        application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("2"));
//        Thread.sleep(2560);
//        application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("2"));
//        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
//                "Тип документа не соответствует типу документов реестра и добавлен не будет");
//        application.getRegistryHelper().addObject(DBArrays3random.inventoryBarcodeinstate("4"));
//        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
//                "Тип документа не соответствует типу документов реестра и добавлен не будет");
//    }

    // надо прямо писать сценарий со всеми ти пами доков
}

