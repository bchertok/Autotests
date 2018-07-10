package sberoad.tests.RegistryTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays3random;
import sberoad.tests.TestBase;

import java.util.Arrays;
import java.util.List;

public class RegistryAS16 extends TestBase {
    private List<String> statesForDocument = Arrays.asList("07", "09", "10", "11");
    private List<String> statesForInventory = Arrays.asList("03","07", "09", "10", "11");
    private List<String> texts = Arrays.asList("Добавление объекта в статусе «Не подтвержден» невозможно",
            "Добавление объекта в статусе «Получен» невозможно",
            "Добавление объекта в статусе «Зарегистрирован» невозможно",
            "Добавление объекта в статусе «До выяснения (регистрация)» невозможно",
            "Добавление объекта в статусе «Отправлен в логистику» невозможно");
    @Test
    public void registryAddObjectVar1() throws InterruptedException {
        Thread.sleep(200);
        application.getNavigation().startPage();
        application.getNavigation().ToNewRegistry();
        Thread.sleep(2000);
        application.getRegistryHelper().documentType("1");
        int i = 1;
        for (String s : statesForDocument) {
            Thread.sleep(3000);
          String barcode = DBArrays3random.documentBarcodeinstate(s);
            System.out.println(barcode);
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(200);
            String txt =  application.getRegistryHelper().getToolteaptext();
            Assert.assertEquals(txt, texts.get(i));
            i++;
        }
        int z = 1;
        for (String s : statesForDocument) {
            Thread.sleep(3000);
            String barcode =DBArrays3random.dailybindingBarcodeinstate(s);
            System.out.println(barcode);
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(200);
            String txt =  application.getRegistryHelper().getToolteaptext();
            Assert.assertEquals(txt, texts.get(z));
            z++;
        }
        int x = 0;
        for (String s : statesForInventory) {
            Thread.sleep(3000);
            String barcode =DBArrays3random.inventoryBarcodeinstate(s);
            System.out.println(barcode);
            application.getRegistryHelper().addObject(barcode);
            Thread.sleep(200);
            String txt =  application.getRegistryHelper().getToolteaptext();
            Assert.assertEquals(txt, texts.get(x));
            x++;
        }

    }
}

