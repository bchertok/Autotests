package sberoad.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class RegistryHelper extends HelperBase {

    RegistryHelper(WebDriver driver) {
        super(driver);
    }

    public void finishForming() {
        clickByCss("button.ant-btn.submit___3rLAN.button___2TQZM.ant-btn-primary");
    }

    public void registryBarcode1() {
        clickByCss("span.icon___3Af1N.cars-home-pen.icon___YR2gz");
    }

    public void registryBarcode2(String barcode) {
        typeAndEnter(barcode, By.cssSelector("input[name=\"registry.barcode\"]"));
    }

    public void documentType(String numberofDocumentType) {
        clickByCss("div.ant-select-selection__rendered");
        if (isElementPresent(By.xpath("//div[2]/div/div/div/ul/li[" + numberofDocumentType + "]"))) {
            spisokwithouttext(By.xpath("//div[2]/div/div/div/ul/li[" + numberofDocumentType + "]"));
        } else
            spisokwithouttext(By.xpath("//div[3]/div/div/div/ul/li[" + numberofDocumentType + "]"));
    }


    public void spisokdossierType() {
        // naimenovanie zagolovka dela
        clickByxpath("//div[3]/div/div/div[2]/div/span/div/div");
        clickByxpath("//div[3]/div/div/div/ul/li");
// tip ucheta
        spisokwithouttext(By.xpath("//div[@id='root']/div/div[2]/div/form/div[4]/div[2]/div/span/div/div/div/div"));
        spisokwithouttext(By.xpath("//div[4]/div/div/div/ul/li[2]"));
    }

    public void addLine() {
        clickByCss("div.ant-btn-group > button.ant-btn.button___2TQZM");
    }


    public String getdocumentType() {
        return getTextContent(By.xpath("//span/div/div/div/div[2]"));
    }

    public String getnotificationtext() {
        return getTextContent(By.cssSelector("div.ant-notification-notice-message"));
    }

    public String getToolteaptext() {
        return getTextContent(By.cssSelector("div.ant-form-explain"));
    }

    public void addObject(String barcode) {
        typeAndEnter(barcode, By.cssSelector("input[name=\"barcode\"]"));
    }

    public void noToNotyfication() {
        clickByCss("button.ant-btn.button___2TQZM.ant-btn-default");
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
        click(By.cssSelector("div.ant-notification-notice-message > button.ant-btn.button___2TQZM.ant-btn-primary"));
    }

    public void backFromRegitry() {
        click(By.linkText("Назад"));
    }

    public void chekBoxAll() {
        click(By.cssSelector("input.ant-checkbox-input"));
    }

    public void deleteButton() throws InterruptedException {
        clickByxpath("(//button[@type='button'])[5]");
        Thread.sleep(300);
        click(By.cssSelector("div.ant-notification-notice-message > button.ant-btn.button___2TQZM.ant-btn-primary"));

    }

    public void addDailybinding() throws InterruptedException {
        clickByxpath("(//button[@type='button'])[3]");
        Thread.sleep(300);
        clickByCss("#rcDialogTitle0 > div.headerControl___DJPWA > span.icon___3Af1N.cars-home-pen.icon___YR2gz");
        Randoms rnd = new Randoms();
        typeAndEnter(rnd.randomBarcode(), By.name("registry.barcode"));
        clickByxpath("//div[2]/form/div/div[2]/div/span/div/div/div/div");
        spisokwithouttext(By.cssSelector("li.ant-select-dropdown-menu-item.ant-select-dropdown-menu-item-active"));
        clickByxpath("//button[@type='submit']");
        Thread.sleep(500);
    }

    public void addothercorrespondence() throws InterruptedException {
        clickByxpath("//div[@id='root']/div/div[2]/div/form/div[3]/div[2]/div/span/div/div");
        clickByCss("li.ant-select-dropdown-menu-item.ant-select-dropdown-menu-item-active");
        Thread.sleep(300);
        type("3", By.name("documentsToAddCount"));
        clickByxpath("(//button[@type='button'])[2]");
        type("1", By.xpath("(//input[@value=''])[7]"));
        type("1", By.xpath("(//input[@value=''])[7]"));
        clickByCss("div.main___2j5X_");
    }

    public void addDossier() throws InterruptedException {
        spisok("кн", By.xpath("//div[@id='root']/div/div[2]/div/form/div[3]/div/div/div[2]/div/span/div/div"));
        clickByxpath("//div[@id='root']/div/div[2]/div/form/div[4]/div[2]/div/span/div/div/div/div");
        Thread.sleep(50);
        clickByxpath("//div[4]/div/div/div/ul/li");
        type("3", By.name("documentsToAddCount"));
        clickByxpath("(//button[@type='button'])[3]");
        type("1", By.xpath("(//input[@value=''])[12]"));
        clickByxpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div[4]/div/div/div/span/span/div/span");
        clickByxpath("//tr[2]/td[2]/div");
        clickByxpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div[5]/div/div/div/span/span/div/span");
        clickByxpath("//tr[2]/td[3]/div");
        clickByCss("div.main___2j5X_");
    }
}
