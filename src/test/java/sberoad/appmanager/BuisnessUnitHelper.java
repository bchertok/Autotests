package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuisnessUnitHelper extends HelperBase {


    BuisnessUnitHelper(WebDriver driver) {
        super(driver);


    }

    public void navigateToBuisnessUnit() {
        click(By.linkText("Настройки"));
        click(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/span"));
    }

    public void acceptBuisnessUnit() {
        click(By.xpath("//button[@type='submit']"));

    }

    public void fillBuisnessUnit(String name, String comment) {
        type(name, By.cssSelector("input.input"));
        click(By.cssSelector("label.f-label"));
        type(comment, By.xpath("//input[@value='']"));
    }

    public void newBuisnessUnit() throws InterruptedException {
        driver.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/subdivisions");
        driver.findElement(By.linkText("Бизнес-блоки")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.add-link > span.label")).click();
    }
}
