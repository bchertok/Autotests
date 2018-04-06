package sberoad.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;

import java.util.ArrayList;
import java.util.List;


public class RegistryAS2 extends TestBase {
    // введен шк реестра и пользователь выбрал нет
    @Test (enabled = false)
    public void registryAS2var1() throws InterruptedException {

        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM REGISTRY", "BARCODE");

        List<String> notificationList = new ArrayList<>();

        for (String s : barcode) {
             System.out.println(s);

            application.getNavigation().startPage();
            Thread.sleep(100);
            application.getNavigation().ToNewRegistry();
            Thread.sleep(500);
            application.getRegistryHelper().fillRegitryform(null, null, s);


            String notification = application.getHelperBase().getTextContent(By.cssSelector("div.modal-body"));
            Assert.assertEquals(notification, "В системе уже имеется реестр с таким штрих-кодом. Открыть реестр на редактирование/просмотр?");
            Thread.sleep(300);
            application.getRegistryHelper().declaineNotyfication(By.xpath("//div[3]/button[2]"));
            application.getRegistryHelper().declaineNotyfication(By.xpath("//div[3]/button[2]"));
Thread.sleep(300);
            application.getRegistryHelper().fillRegitryform2(null, null, s);
            String fieldForRegistryBarcode = application.getHelperBase().getTextValue(By.cssSelector("div.f-element.f-element-text.inline.f-element-barcode > div.f-control > input.input"));
            System.out.println(fieldForRegistryBarcode);

            notificationList.add(notification);
        }

        Assert.assertEquals(barcode.size(), notificationList.size());
    }

    @Test(enabled = false)
    public void registryAS2var2() throws InterruptedException {

    }


    @Test
    public void registryAS2var3() throws InterruptedException {
        DB db = new DB();
        List<String> barcode = db.getAllValue("SELECT " +
                "BARCODE FROM REGISTRY WHERE STATECODE=03 OR STATECODE=04 OR STATECODE=05 OR STATECODE= 06 OR STATECODE=07", "BARCODE");

        for (String s : barcode) {
            System.out.println(s);

        

        }
    }

}