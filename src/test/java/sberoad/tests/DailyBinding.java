package sberoad.tests;

import org.testng.annotations.Test;

public class DailyBinding extends TestBase{

    @Test
    public void DaylyBinding() throws Exception {
        application.getNavigation().startPage();

    application.getNavigation().ToNewRegistry();
    Thread.sleep(2000);
//    application.getRegistryHelper().fillRegitryform("Сшивы документов дня", null, null);
    Thread.sleep(3000);
    application.getDailyBindingHelper().addDailyBinding();
    Thread.sleep(1000);
    application.getDailyBindingHelper().fillDailyBindingForm("за");
    application.getDailyBindingHelper().finishForm();
    Thread.sleep(1000);
    application.getRegistryHelper().backFromRegitry();
    }
}
