package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class RegistryHelper extends HelperBase {

    RegistryHelper(WebDriver driver) {
        super(driver);
    }

    public void fillRegitryform(String documentType, String subdivisionout, String registryBarcode) {
        spisok(subdivisionout, By.cssSelector("div.Select-control"));
        spisok(documentType, By.xpath("//div[3]/div[2]/div/div"));
        type(registryBarcode, By.cssSelector("div.f-element.f-element-text.inline.f-element-barcode > div.f-control > input.input"));
        if (registryBarcode != null) {
            driver.findElement(By.cssSelector("div.f-element.f-element-text.inline.f-element-barcode > div.f-control > input.input")).sendKeys(Keys.ENTER);
        }
    }

    public void fillRegitryform2(String documentType, String subdivisionout, String registryBarcode) {
// без нажатия enter после ввода ШК
        spisok(subdivisionout, By.cssSelector("div.Select-control"));
        spisok(documentType, By.xpath("//span[@id='react-select-8--value']/div"));
        type(registryBarcode, By.cssSelector("div.f-element.f-element-text.inline.f-element-barcode > div.f-control > input.input"));

    }

    public void fillObjectBarcode(String text) {
        typeAndEnter(text, By.cssSelector("form.input-group > div.f-element.f-element-text.inline > div.f-control > input.input"));
    }

    public void openObjectSearch() {
        clickByxpath("//div[2]/div[4]/div/div");
    }

    public void openSubdivisionSearch() {
        clickByxpath("//form/div[2]/div");
    }

    public void noToNotyfication() {
        // если не на все уведомления будет такой локатор то сделать локатор параметром и в helperbase
        Actions actions = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div[3]/button[2]"));
        actions.moveToElement(we);
        actions.click();
        actions.perform();
    }

    public void yesToNotyfication() {
        // если не на все уведомления будет такой локатор то сделать локатор параметром и в helperbase

        Actions actions = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div[3]/button"));
        actions.moveToElement(we);
        actions.click();
        actions.perform();
    }

    public void okeyToNotyfication() {
        // если не на все уведомления будет такой локатор то сделать локатор параметром и в helperbase
        click(By.cssSelector("div.modal-footer > button.g-button"));
    }

    public void backFromRegitry() {
        click(By.linkText("Назад"));
    }
public void chekBoxAll(){
        click(By.cssSelector("label.f-label"));
}
public void deleteButton(){
    clickByCss("div.controls > button.g-button");
}



}
