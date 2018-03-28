package sberoad.tests;

import org.testng.annotations.Test;

public class DailyBinding extends TestBase{

    @Test
    public void testUntitledTestCase() throws Exception {
        application.getNavigation().startPage();

    application.getNavigation().ToNewRegistry();
    Thread.sleep(2000);
    application.getNewRegistryHelper().fillRegitryform("Сшивы документов дня");
    Thread.sleep(1000);
    application.getDailyBindingHelper().addDailyBinding();
    Thread.sleep(1000);
    application.getDailyBindingHelper().fillDailyBindingForm("за");
    application.getDailyBindingHelper().finishForm();
    Thread.sleep(1000);
    application.getNewRegistryHelper().backFromRegitry();
    }
}
