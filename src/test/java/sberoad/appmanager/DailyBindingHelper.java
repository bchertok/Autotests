package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DailyBindingHelper extends HelperBase {

    DailyBindingHelper(WebDriver driver){super(driver);}

public void addDailyBinding() {
        clickByxpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[5]/div/button");
        clickByxpath("(//button[@type='button'])[7]");
}

public void fillDailyBindingForm(String bindingType) {

        spisok(bindingType, By.xpath("//span[@id='react-select-14--value']/div"));

}

public void finishForm () throws InterruptedException {
        clickByxpath("//button[@type='button']");
        Thread.sleep(500);
        clickByxpath("(//button[@type='button'])[4]");
    }







}


