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
if (isElementPresent(By.xpath("//div[2]/div/div/div/ul/li[" + numberofDocumentType + "]"))) {
    spisokwithouttext(By.xpath("//div[2]/div/div/div/ul/li[" + numberofDocumentType + "]"));
}
else
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
    public void editDossierDocument(String text){
        clickByCss("button.ant-btn.edit-button.ant-btn-circle.ant-btn-icon-only");
        type(text,By.cssSelector("div.rt-td > div.ant-row.ant-form-item.textInput___U6pTh > div.ant-form-item-control-wrapper > div.ant-form-item-control > span.ant-form-item-children > input.ant-input"));
        clickByCss("button.ant-btn.edit-button.edit-button_save.ant-btn-circle.ant-btn-icon-only");
    }
public void spisokOtherCorrespondenceType(){
        clickByxpath("//div[3]/div[2]/div/span/div/div/div");
        clickByxpath("//div[3]/div/div/div/ul/li");
}
    public void addLine(){
       clickByCss("div.ant-btn-group > button.ant-btn.button___2TQZM");
    }

    /////
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



}
