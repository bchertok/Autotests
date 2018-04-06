package sberoad.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperBase {
    final WebDriver driver;

    HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    // переменная для закрытия уведомления
    private boolean acceptNextAlert = true;


    void type(String text, By locator) {
        driver.findElement(locator).click();
        if (text != null) {
            String existingtext = driver.findElement(locator).getAttribute("value");
            if (!existingtext.equals(text)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }

    }

    void spisok(String text, By locator) {
        if (text != null) {
        Actions actions = new Actions(driver);
        WebElement we = driver.findElement(locator);
        actions.moveToElement(we);
        actions.click();
        actions.sendKeys(text);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }}

    void click(By locator) {
        driver.findElement(locator).click();
    }

    String text(By locator) {
        String text = driver.findElement(locator).getText();
        return text;
    }

    void clickByxpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }


    // текст ошибки если он виден; нужно исправит перехват исключений

    public String getText(By locator) {
        String txt = "не найдено";
        boolean elementPresent = isElementPresent(locator);

        if (elementPresent) {

            if
                    (driver.findElement(locator).isDisplayed()) {
                txt = driver.findElement(locator).getText();
            } else {
                System.out.println("");
            }

            System.out.println(txt);
            return txt;
        } else {
            System.out.println("Element not found");
        }

        return txt;
    }

    public String getTextContent(By locator) {
        String txt = "не найдено";
        boolean elementPresent = isElementPresent(locator);

        if (elementPresent) {

            txt = driver.findElement(locator).getAttribute("textContent");

           // System.out.println(txt);
            return txt;
        } else {
            System.out.println("Element not found");
        }

        return txt;
    }
    public String getTextValue(By locator) {
        String txt = "не найдено";
        boolean elementPresent = isElementPresent(locator);

        if (elementPresent) {

            txt = driver.findElement(locator).getAttribute("value");

            // System.out.println(txt);
            return txt;
        } else {
            System.out.println("Element not found");
        }

        return txt;
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


}


