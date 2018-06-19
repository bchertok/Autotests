package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistryHelper extends HelperBase {

    RegistryHelper(WebDriver driver) {
        super(driver);
    }

    public void finishForming() {
        clickByCss("button.ant-btn.submit___3rLAN.button___2TQZM.ant-btn-primary");
    }

    public void registryBarcode1() {
        clickByCss("i.anticon.anticon-edit");
    }

    public void registryBarcode2(String barcode) {
        typeAndEnter(barcode, By.cssSelector("input[name=\"registry.barcode\"]"));
    }

    public void documentType(String numberofDocumentType) {
        clickByCss("div.ant-select-selection__rendered");
        spisokwithouttext(By.xpath("//div[2]/div/div/div/ul/li[" + numberofDocumentType + "]"));
    }

    public String getdocumentType() {
        String textcontent = getTextContent(By.xpath("//span/div/div/div/div[2]"));
        return textcontent;
    }

    public String getnotificationtext() {
        String text = getTextContent(By.cssSelector("div.ant-notification-notice-message"));
        return text;
    }

    public void addObject(String barcode) {
        typeAndEnter(barcode, By.cssSelector("input[name=\"barcode\"]"));
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

    public void chekBoxAll() {
        click(By.cssSelector("input.ant-checkbox-input"));
    }

    public void deleteButton() {
        clickByxpath("(//button[@type='button'])[6]");
    }


}
