package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;


public class CatalogRegistryTypeHelper extends HelperBase{


    CatalogRegistryTypeHelper(WebDriver driver) {
        super(driver);

    }

    public void navigateToRegistryType() {
        click(By.linkText("Настройки"));
        click(By.xpath(""));
    }

    public void acceptRegistryType() {
        click(By.xpath("//button[@type='submit']"));

    }
    public void fillRegistryType(String name, String comment) {
        type(name, By.cssSelector("input.input"));
        type(comment, By.xpath("//input[@value='']"));
    }

    public void newRegistryType() throws InterruptedException {
        driver.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/subdivisions");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/a[4]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.add-link > span.label")).click();
    }



}
