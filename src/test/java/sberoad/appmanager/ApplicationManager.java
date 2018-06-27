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
    private HelperBase helperBase;

    private StringBuffer verificationErrors = new StringBuffer();



    public void init() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        subdivisionhelper = new Subdivisionhelper(driver);
        archiveHelper = new ArchiveHelper(driver);
        buisnessUnitHelper = new BuisnessUnitHelper(driver);
        navigation = new Navigation(driver);
        findDocument = new FindDocumentHelper(driver);
        dailyBindingHelper = new DailyBindingHelper(driver);
        registryHelper = new RegistryHelper(driver);
        documentsDossierHelper = new DocumentsDossierHelper(driver);
        catalogregistryTypeHelper = new CatalogRegistryTypeHelper(driver);
        helperBase = new HelperBase(driver);


        driver.manage().window().maximize();
        Auth(null, null);

    }

    private void Auth(String login, String password) throws InterruptedException {

        driver.get("http://sb-oad-test:8050/login");
        Thread.sleep(500);
        HelperBase ispravit = new HelperBase(driver);
        ispravit.type(login,By.xpath("//input"));
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

    public HelperBase getHelperBase() { return helperBase; }
}