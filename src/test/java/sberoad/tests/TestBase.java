package sberoad.tests;



import org.testng.annotations.*;
import sberoad.appmanager.ApplicationManager;


public class TestBase {

    protected static final ApplicationManager application = new ApplicationManager();
    // protected  final ApplicationManager application = new ApplicationManager();

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        application.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        application.stop();
    }
}
