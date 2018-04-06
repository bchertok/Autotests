package sberoad.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private BuisnessUnitHelper buisnessUnitHelper;
    private ArchiveHelper archiveHelper;
    private Navigation navigation;
    private FindDocumentHelper findDocument;
    private DailyBindingHelper dailyBindingHelper;
    private RegistryHelper registryHelper;
    private Subdivisionhelper subdivisionhelper;
    private DocumentsDossierHelper documentsDossierHelper;
    private CatalogRegistryTypeHelper catalogregistryTypeHelper;
    private SwaggerHelper swaggerHelper;
    private HelperBase helperBase;

    private StringBuffer verificationErrors = new StringBuffer();



    public void init() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        subdivisionhelper = new Subdivisionhelper(driver);
        archiveHelper = new ArchiveHelper(driver);
        buisnessUnitHelper = new BuisnessUnitHelper(driver);
        navigation = new Navigation(driver);
        findDocument = new FindDocumentHelper(driver);
        dailyBindingHelper = new DailyBindingHelper(driver);
        registryHelper = new RegistryHelper(driver);
        documentsDossierHelper = new DocumentsDossierHelper(driver);
        catalogregistryTypeHelper = new CatalogRegistryTypeHelper(driver);
        swaggerHelper = new SwaggerHelper(driver);
        helperBase = new HelperBase(driver);



        Auth(null, null);

    }

    private void Auth(String login, String password) throws InterruptedException {

        driver.get("http://sb-oad-test/app1/login");
        Thread.sleep(500);
        HelperBase ispravit = new HelperBase(driver);
        ispravit.type(login,By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div[2]/input"));
        ispravit.type(password, By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div[2]/div[2]/span/input"));
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    }
    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public ArchiveHelper getArchiveHelper() {
        return archiveHelper;
    }

    public BuisnessUnitHelper getBuisnessUnitHelper() {
        return buisnessUnitHelper;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public FindDocumentHelper getFindDocument() {
        return findDocument;
    }

    public DailyBindingHelper getDailyBindingHelper() {
        return dailyBindingHelper;
    }

    public Subdivisionhelper getSubdivisionhelper() {return subdivisionhelper;}

    public RegistryHelper getRegistryHelper() {
        return registryHelper;
    }

    public DocumentsDossierHelper getDocumentsDossierHelper() { return documentsDossierHelper;}

    public CatalogRegistryTypeHelper getcatalogRegistryTypeHelper() {return catalogregistryTypeHelper;}

    public SwaggerHelper getSwaggerHelper(){return swaggerHelper;}

    public HelperBase getHelperBase() { return helperBase; }
}