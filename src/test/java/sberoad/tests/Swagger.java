package sberoad.tests;


import org.testng.annotations.Test;


public class Swagger extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {

        int docNumber = 20;


        application.getSwaggerHelper().goToSwagger();
        application.getSwaggerHelper().autorize("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmdWxsX25hbWUiOiLQr9GA0LzQvtGIINCgLiDQmy4iLCJ1c2VyX2lkIjoxMCwidXNlcl9uYW1lIjoib2FkX3N1cGVyQWRtaW5Vc2VyIiwic2NvcGUiOlsid2ViY2xpZW50Il0sImV4cCI6MTUyMjg1Njc3MywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BZG1pbkluZm8iLCJST0xFX3Blcm1fQWRtaW5JbmZvIiwiUk9MRV9TdXBwb3J0VXNlciIsIlJPTEVfQXVkaXRJbmZvIiwiUk9MRV9wZXJtX0F1ZGl0SW5mbyIsIlJPTEVfcGVybV9UZXJiYW5rVXNlciIsIlJPTEVfQWRtaW5Vc2VyIiwiUk9MRV9wZXJtX0FkbWluVXNlciIsIlJPTEVfVGVyYmFua1VzZXIiLCJST0xFX3Blcm1fQXJjaGl2ZVVzZXIiLCJST0xFX1JlcG9ydCIsIlJPTEVfQXJjaGl2ZVVzZXIiLCJST0xFX3Blcm1fU3VwcG9ydFVzZXIiLCJST0xFX3Blcm1fUmVwb3J0Il0sImp0aSI6IjJjMzdmYzNkLTcyOGMtNGQyNi05ZjM5LTQ1MjZjNTU5NGFlYyIsImNsaWVudF9pZCI6ImNhcnMifQ.19oFtis2ltWXiYFpSDDghzjRSKgGzw-VleIeHy1vTAg");

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