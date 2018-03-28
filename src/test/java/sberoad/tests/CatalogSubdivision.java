package sberoad.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogSubdivision extends TestBase{

    @Test
    public void testUntitledTestCase() throws Exception {
   application.getSubdivisionhelper().navigateToSubdivision();
        application.getSubdivisionhelper().newSubdivision();
        application.getSubdivisionhelper().fillSubdivision("02","03", "Pushkina","Поволжский",
                "007","new","new","mail.@mail");
        application.getSubdivisionhelper().acceptSubdivision();
     String i = application.getSubdivisionhelper().textnotification();
        Assert.assertEquals(i,"Запись успешно создана\nСкрыть");
    }
}
