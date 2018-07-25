package sberoad.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private Navigation navigation;
    private RegistryHelper registryHelper;
    private HelperBase helperBase;
    private TransportunitHelper transportunitHelper;
    private StringBuffer verificationErrors = new StringBuffer();


    public void init() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        navigation = new Navigation(driver);
        registryHelper = new RegistryHelper(driver);
        helperBase = new HelperBase(driver);
        transportunitHelper = new TransportunitHelper(driver);
        driver.manage().window().maximize();
        Auth(null, null);

    }

    private void Auth(String login, String password) throws InterruptedException {

        driver.get("http://sb-oad-test:8050/login");
        Thread.sleep(500);
        HelperBase ispravit = new HelperBase(driver);
        ispravit.type(login, By.xpath("//input"));
        ispravit.type(password, By.xpath("//div[2]/div/div/span/input"));
        driver.findElement(By.xpath("//button")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public Navigation getNavigation() {
        return navigation;
    }

    public RegistryHelper getRegistryHelper() {
        return registryHelper;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public TransportunitHelper getTransportunitHelper() {
        return transportunitHelper;
    }
}