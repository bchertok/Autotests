package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransportunitHelper extends HelperBase {

    TransportunitHelper(WebDriver driver) {
        super(driver);
    }

    public void addItem(String barcode) {
        typeAndEnter(barcode, By.cssSelector("input.ant-input"));
    }

    public String copyTeBarcode() throws InterruptedException {
        clickByCss("div.ant-row-flex.ant-row-flex-middle > span.icon___sQbDW.cars-copy.icon___YR2gz");
        Thread.sleep(100);
        clickByCss("input.ant-input");
        Thread.sleep(500);
        ctrlV();
        Thread.sleep(500);
        Thread.sleep(500);
        Thread.sleep(500);
        return getTextValue(By.cssSelector("input.ant-input"));
    }

    public void finishForm() {
        clickByCss("button.ant-btn.button___2TQZM.ant-btn-primary");
    }

    public void deleteItem() {
        clickByxpath("//div[2]/div/div/div[2]/div[3]");
        clickByxpath("//div[5]/i");
    }

    public void closeTab(){
        clickByCss("button.ant-modal-close");
    }
}
