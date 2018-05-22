package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends HelperBase {

    Navigation(WebDriver driver) {
        super(driver);
    }

    public void startPage() {
        driver.get("http://sb-oad-demo.reksoft.ru/app1/system_functions");
    }


    public void ToRegistryList (){
        click(By.linkText("Функции системы"));
        click(By.linkText("Реестр"));
    }
    public void ToNewRegistry () throws InterruptedException {
        click(By.linkText("Функции системы"));
        click(By.linkText("Реестр"));
        Thread.sleep(1000);
        click(By.linkText("Создать реестр"));
    }

}
