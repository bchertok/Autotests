package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentsDossierHelper extends HelperBase{
    public DocumentsDossierHelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToDossierDocument() throws InterruptedException {
        click(By.linkText("Настройки"));
        click(By.xpath("//div[2]/div/div/div/div/span"));
    }

    public void newDossierDocument() throws InterruptedException {
        Thread.sleep(1000);
        click(By.linkText("Создать"));
    }

    public void fillDossierDocument(String documentType, String name) throws InterruptedException {
        Thread.sleep(2000);
        spisok(documentType, By.xpath("//span/div") );
        type(name, By.xpath("//div[7]/div[2]/input"));
        // date
        //date
        click(By.cssSelector("label.f-label"));
    }

    public void acceptDossierDocument() {
        click(By.cssSelector("button.g-button.success"));
        String i = text(By.cssSelector("div.item.success"));
        System.out.println(i);
    }
    public String textnotification(){
        String i =text(By.cssSelector("div.item.success"));
        return i;
    }


}


