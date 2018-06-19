package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends HelperBase {

    Navigation(WebDriver driver) {
        super(driver);
    }

    public void startPage() {
        driver.get("http://sb-oad-test:8050/");
    }


    public void ToRegistryList (){
        click(By.linkText("Функции системы"));
        click(By.linkText("Реестр"));
    }
    public void ToNewRegistry () throws InterruptedException {
        click(By.linkText("Сдать документы в архив"));
//        click(By.linkText("Реестры"));
        Thread.sleep(1000);
        click(By.cssSelector("button.ant-btn.button___2TQZM"));
    }

}
