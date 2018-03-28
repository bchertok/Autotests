package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ArchiveHelper extends HelperBase {


    public ArchiveHelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToArchive() throws InterruptedException {
        click(By.linkText("Настройки"));
        click(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/a[17]/div"));
    }

    public void newArchive() throws InterruptedException {

        Thread.sleep(1000);
        click(By.linkText("Создать"));
    }

    public void fillArchive(String kod, String name, String adress) {
        type(kod, By.cssSelector("input.input"));
        type(name, By.xpath(("//div[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/input")));
        type(adress, By.xpath("//div[3]/div[2]/input"));
    }

    public void acceptArchive() {
        click(By.cssSelector("div.p-content"));
        click(By.cssSelector("button.g-button.success"));
    }


}