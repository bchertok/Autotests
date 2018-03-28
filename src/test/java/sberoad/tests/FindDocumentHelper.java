package sberoad.tests;

import org.testng.annotations.Test;

public class FindDocumentHelper extends TestBase {
    @Test
    public void testUntitledTestCase() throws Exception {
        application.getNavigation().startPage();

        application.getFindDocument().navigateToDocumentSearch();
        application.getFindDocument().fillSearchForm("Бумажный документ без ЭГО", "201");
        application.getFindDocument().searchInBase();
        Thread.sleep(2000);
    }
}
