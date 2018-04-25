package sberoad.tests;


import org.testng.annotations.Test;


public class Swagger extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {

        int docNumber = 20;


        application.getSwaggerHelper().goToSwagger();
        Thread.sleep(3000);
        application.getSwaggerHelper().autorize("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmdWxsX25hbWUiOiLQr9GA0LzQvtGIINCgLiDQmy4iLCJ1c2VyX2lkIjoxMCwidXNlcl9uYW1lIjoib2FkX3N1cGVyQWRtaW5Vc2VyIiwic2NvcGUiOlsid2ViY2xpZW50Il0sImV4cCI6MTUyNDI2ODY3OCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BZG1pbkluZm8iLCJST0xFX3Blcm1fQWRtaW5JbmZvIiwiUk9MRV9TdXBwb3J0VXNlciIsIlJPTEVfQXVkaXRJbmZvIiwiUk9MRV9wZXJtX0F1ZGl0SW5mbyIsIlJPTEVfcGVybV9UZXJiYW5rVXNlciIsIlJPTEVfQWRtaW5Vc2VyIiwiUk9MRV9wZXJtX0FkbWluVXNlciIsIlJPTEVfVGVyYmFua1VzZXIiLCJST0xFX1JlcG9ydCIsIlJPTEVfcGVybV9BcmNoaXZlVXNlciIsIlJPTEVfQXJjaGl2ZVVzZXIiLCJST0xFX3Blcm1fU3VwcG9ydFVzZXIiLCJST0xFX3Blcm1fUmVwb3J0Il0sImp0aSI6IjUyYzZhN2ExLWMzYTEtNDAwZS1hNzc0LWQwZGY0YzU1OWFiNiIsImNsaWVudF9pZCI6ImNhcnMifQ.evmYvfleKzz7I9c8_d7tbeMMdXWDSr1hh5Z2OTAb5bs");

        application.getSwaggerHelper().fillForm();
        application.getSwaggerHelper().accept();
        System.out.println(application.getSwaggerHelper().docnumber());


        application.getSwaggerHelper().newBarcodeFirsTime();
        application.getSwaggerHelper().accept();
        System.out.println(application.getSwaggerHelper().docnumber());

        for (int i = 0; i < docNumber; i++) {
            application.getSwaggerHelper().newBarcodeSecondTime();
            application.getSwaggerHelper().accept();
            System.out.println(application.getSwaggerHelper().docnumber());
        }

    }
}