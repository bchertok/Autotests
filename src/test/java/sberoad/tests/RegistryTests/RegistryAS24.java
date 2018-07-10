package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RegistryAS24 extends TestBase {
    private List<String> statesForDocument = Arrays.asList("02", "05", "06", "07", "08", "09", "10", "11");
    private List<String> statesForInventory = Arrays.asList("03", "04", "05", "06", "07", "08", "09", "10", "11");

    @Test
    public void registryAs24var1() throws InterruptedException {
        // Добавляем действующий документ и пытаемся добавить по ШК Сшив
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(300);
        application.getRegistryHelper().documentType("1");
        application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate("2"));
        Thread.sleep(5560);

        for (String s : statesForDocument) {
            application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate(s));
            Thread.sleep(2000);
            Assert.assertEquals(application.getRegistryHelper().getnotificationtext(), "Тип документа не соответствует типу документов реестра и добавлен не будет");
        }
    }


    @Test
    public void registryAs24var2() throws InterruptedException {
        // Добавляем сшив и пытаемся добавить по ШК действующий док и опись
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(300);
        application.getRegistryHelper().documentType("3");
        application.getRegistryHelper().addObject(DBArrays3random.dailybindingBarcodeinstate("2"));
        Thread.sleep(4560);
        for (String s : statesForDocument) {
            application.getRegistryHelper().addObject(DBArrays3random.documentBarcodeinstate(s));
            Thread.sleep(2000);
            Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                    "Тип документа не соответствует типу документов реестра и добавлен не будет");
        }
        for (String s : statesForInventory) {
            application.getRegistryHelper().addObject(DBArrays3random.inventoryBarcodeinstate(s));
            Thread.sleep(2000);
            Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                    "Тип документа не соответствует типу документов реестра и добавлен не будет");
        }
    }
}

