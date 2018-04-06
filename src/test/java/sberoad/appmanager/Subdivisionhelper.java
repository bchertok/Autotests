package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Subdivisionhelper extends HelperBase{
    Subdivisionhelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToSubdivision() throws InterruptedException {
        click(By.linkText("Настройки"));
        click(By.xpath("//div[2]/div/div/div/div/span"));
    }

    public void newSubdivision() throws InterruptedException {
        Thread.sleep(1000);
        click(By.linkText("Создать"));
    }

    public void fillSubdivision(String vsb, String osb, String adress,
                                String index, String kod, String name,String shortname, String mail) throws InterruptedException {
        clickByxpath("//div[2]/label");
        type(vsb, By.xpath("//div[2]/input"));
        type(osb, By.xpath(("//div[4]/div[2]/input")));
        Thread.sleep(2000);
        spisok(index, By.cssSelector("div.Select-control") );
        type(kod, By.xpath("//div[7]/div[2]/input"));
        type(name, By.xpath("//div[8]/div[2]/input"));
        type(shortname, By.xpath("//div[9]/div[2]/input"));
        type(mail, By.xpath("//div[10]/div[2]/input"));
        clickByxpath("//div[11]/label");
    }

    public void acceptSubdivision() {
        click(By.cssSelector("button.g-button.success"));
        String i = text(By.cssSelector("div.item.success"));
        System.out.println(i);
    }
public String textnotification(){
    String i =text(By.cssSelector("div.item.success"));
    return i;
}


}
