package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends HelperBase {

    Navigation(WebDriver driver) {
        super(driver);
    }

    public void startPage() throws InterruptedException {
        Thread.sleep(200);
        driver.get("http://sb-oad-test:8050/");
    }

    public void ToRegistryList() {
        click(By.linkText("Функции системы"));
        click(By.linkText("Реестр"));
    }

    public void toNewRegistry() throws InterruptedException {
        click(By.linkText("Сдать документы в архив"));
        Thread.sleep(1000);
        click(By.cssSelector("button.ant-btn.button___2TQZM"));
    }

    public void toNewTransportUnit() throws InterruptedException {
        click(By.linkText("Сдать документы в архив"));
        Thread.sleep(600);
        click(By.linkText("ТЕ"));
        Thread.sleep(600);
        clickByCss("button.ant-btn.groupCreate___2QaCr.button___2TQZM");
        Thread.sleep(800);
    }

    public void toNewWaybill() throws InterruptedException {
        click(By.linkText("Сдать документы в архив"));
        Thread.sleep(600);
        click(By.linkText("МЛ"));
        Thread.sleep(600);
        clickByCss("button.ant-btn.button___2TQZM");
        Thread.sleep(800);
    }

    public void toOthercorrespondence() throws InterruptedException {
        click(By.linkText("Справочники"));
        Thread.sleep(600);
       clickByxpath("//div[@id='root']/div/div[2]/div/div[2]/div/div[2]/div/div/div[3]/div");
        Thread.sleep(600);
        clickByxpath("//div[3]/a/span");
        Thread.sleep(600);
    }

    public void toBuisnessunit() {


    }

    public void toTPFS() {


    }

}
