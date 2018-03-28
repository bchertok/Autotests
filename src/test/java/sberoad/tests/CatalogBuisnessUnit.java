package sberoad.tests;


import org.testng.annotations.Test;


public class CatalogBuisnessUnit extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {

       application.getNavigation().startPage();

        application.getBuisnessUnitHelper().navigateToBuisnessUnit();
        application.getBuisnessUnitHelper().newBuisnessUnit();
        application.getBuisnessUnitHelper().fillBuisnessUnit("name", "comment");
        application.getBuisnessUnitHelper().acceptBuisnessUnit();
    }


}


