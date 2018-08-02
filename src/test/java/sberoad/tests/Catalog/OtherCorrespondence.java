package sberoad.tests.Catalog;


import org.testng.annotations.Test;
import sberoad.tests.TestBase;

public class OtherCorrespondence extends TestBase {
    @Test
    private void addCorrespondence() throws InterruptedException {
        application.getNavigation().startPage();
        application.getNavigation().toOthercorrespondence();

    }
}
