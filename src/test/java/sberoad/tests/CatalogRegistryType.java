package sberoad.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.HelperBase;
import sberoad.appmanager.Random;

public class CatalogRegistryType extends TestBase{

    @Test
    public void createNewNote() throws Exception {
        application.getNavigation().startPage();
        application.getRegistryTypeHelper().navigateToRegistryType();
        application.getRegistryTypeHelper().newRegistryType();

        Random random = new Random();
        String randomKod = String.valueOf(random.randomchar());

        application.getRegistryTypeHelper().fillRegistryType(randomKod,"test");



        application.getSubdivisionhelper().newSubdivision();
        application.getSubdivisionhelper().fillSubdivision("02","03", "Pushkina","Поволжский",
                "007","new","new","mail.@mail");
        application.getSubdivisionhelper().acceptSubdivision();
        String i = application.getSubdivisionhelper().textnotification();
        Assert.assertEquals(i,"Запись успешно создана\nСкрыть");
    }
}
