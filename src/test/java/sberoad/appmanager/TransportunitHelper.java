package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransportunitHelper extends HelperBase {

    TransportunitHelper(WebDriver driver) {
        super(driver);
    }
public void addItem(String barcode){
        typeAndEnter(barcode,By.cssSelector("input.ant-input"));
}

}
