package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindDocumentHelper extends ArchiveHelper {


    public FindDocumentHelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToDocumentSearch() {
        click(By.linkText("Поиск по параметрам"));
        click(By.linkText("Документ"));
    }

    public void fillSearchForm(String documentForm, String ID) {
        spisok(documentForm, By.xpath("//span[@id='react-select-2--value']/div"));
        type(ID, By.xpath("//input[@value='']"));
    }

    public void searchInBase() throws InterruptedException {
        clickByxpath("//button[@type='button']");
        Thread.sleep(1000);
        clickByxpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div/div");
    }

}
