package sberoad.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sberoad.appmanager.DB;



public class CatalogArchive extends TestBase{

    @BeforeTest
    public void testBase() throws Exception {

    }


    @Test
    public void testUntitledTestCase() throws Exception {
            DB db = new DB();
            String barcode = db.getRandomValue("SELECT " +
                    "BARCODE FROM DOCUMENT WHERE STATECODE=02 AND FORMCODE = 0", "BARCODE");
            System.out.println(barcode);


        application.getNavigation().startPage();
        application.getArchiveHelper().navigateToArchive();
        application.getArchiveHelper().newArchive();
        application.getArchiveHelper().fillArchive("код", "наменование", "адрес");
        application.getArchiveHelper().acceptArchive();

    }

}
