package sberoad.tests;


import org.testng.annotations.Test;



public class CatalogArchive extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {


        application.getNavigation().startPage();
        application.getArchiveHelper().navigateToArchive();
        application.getArchiveHelper().newArchive();
        application.getArchiveHelper().fillArchive("код", "наменование", "адрес");
        application.getArchiveHelper().acceptArchive();

    }

}
