package sberoad.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogDossierDocument extends TestBase{


        @Test
        public void testUntitledTestCase() throws Exception {
            application.getDocumentsDossierHelper().navigateToDossierDocument();
            application.getDocumentsDossierHelper().newDossierDocument();
            application.getDocumentsDossierHelper().fillDossierDocument("Действующие", "imya");
            application.getDocumentsDossierHelper().acceptDossierDocument();
            String i = application.getSubdivisionhelper().textnotification();
            Assert.assertEquals(i,"Запись успешно создана\nСкрыть");
        }
}


