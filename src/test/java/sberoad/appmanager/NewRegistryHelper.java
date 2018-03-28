package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRegistryHelper extends HelperBase{

    NewRegistryHelper(WebDriver driver) {super(driver);
    }

    public void fillRegitryform(String documentType) {


        spisok(documentType, By.xpath("//span[@id='react-select-8--value']/div"));
    }

public void backFromRegitry(){
        click(By.linkText("Назад"));
}





}
