package sberoad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SwaggerHelper extends HelperBase {
    SwaggerHelper(WebDriver driver) {
        super(driver);
    }

    public void goToSwagger() {
        driver.get("http://192.168.140.199:10050/api/v1/document/swagger-ui.html#/document-controller/createDocumentUsingPOST");
    }

    public void autorize(String token) {
        clickByxpath("//button");

        type("Bearer " + token, By.xpath("//input"));
        clickByxpath("//button[@type='submit']");
        clickByxpath("//div[2]/button");
    }

    private Randoms random = new Randoms();


    private String barcode = "11111-22222-33333-44444-55555-66666-77777-" + random.randomNumber(5);


    private String request = "\n" +
            "  \"customer\": {\n" +
            "    \"code\": \"45/4441\",\n" +
            "    \"type\": \"Ф\",\n" +
            "    \"temporary\": false,\n" +
            "    \"name\": \"Заявкин Андрей Петрович\",\n" +
            "    \"pprbRegDate\": \"2017-12-01 03:00:00\",\n" +
            "    \"pprbEndDate\": null,\n" +
            "    \"pprbStatus\": null,\n" +
            "    \"firstName\": \"Андрей\",\n" +
            "    \"lastName\": \"Заявкин\",\n" +
            "    \"middleName\": \"Петрович\",\n" +
            "    \"birthdayDate\": \"2011-08-21 04:00:00\",\n" +
            "    \"identityDocumentType\": {\n" +
            "      \"code\": \"21\",\n" +
            "      \"name\": \"Паспорт гражданина РФ\",\n" +
            "      \"description\": \"Паспорт гражданина РФ, действующий на территории РФ с 1 октября 1997 года\"\n" +
            "    },\n" +
            "    \"identityDocSeries\": \"4114\",\n" +
            "    \"identityDocNumber\": \"114466\",\n" +
            "    \"identityDocDate\": \"2006-11-12 03:00:00\",\n" +
            "    \"identityDocEndDate\": null,\n" +
            "    \"orgForm\": null,\n" +
            "    \"shortName\": null,\n" +
            "    \"inn\": null,\n" +
            "    \"kpp\": null,\n" +
            "    \"okpo\": null,\n" +
            "    \"orgn\": null,\n" +
            "    \"regDate\": null,\n" +
            "    \"linkedClientId\": null,\n" +
            "    \"parentClientId\": null,\n" +
            "    \"phone\": null,\n" +
            "    \"vip\": false,\n" +
            "    \"mass\": false,\n" +
            "    \"mvs\": false,\n" +
            "    \"pmvs\": false,\n" +
            "    \"createDate\": \"2018-03-16 03:00:00\",\n" +
            "    \"modifyDate\": \"2018-03-16 03:00:00\",\n" +
            "    \"archiveDate\": null,\n" +
            "    \"absId\": null,\n" +
            "    \"hasChild\": true,\n" +
            "    \"id\": 20\n" +
            "  },\n" +
            "  \"dossierDocument\": {\n" +
            "    \"id\": 1,\n" +
            "    \"name\": \"ЗАВЕЩАТЕЛЬНОЕ РАСПОРЯЖЕНИЕ\",\n" +
            "    \"createdDate\": \"2000-01-01 00:00:00\",\n" +
            "    \"modifiedDate\": \"2000-01-01 00:00:00\",\n" +
            "    \"validFrom\": \"2011-08-21\",\n" +
            "    \"validTo\": \"1999-12-31\",\n" +
            "    \"multicontract\": false,\n" +
            "    \"type\": {\n" +
            "      \"name\": \"Действующие документы\",\n" +
            "      \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"id\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  \"documentForm\": {\n" +
            "    \"code\": \"0\",\n" +
            "    \"name\": \"Бумажный документ без ЭГО\"\n" +
            "  },\n" +
            "  \"absId\": \"VKLOYILEAHEZAPPRQBLI\",\n" +
            "  \"inventory\": null,\n" +
            "  \"indexInInventory\": null,\n" +
            "  \"registry\": {\n" +
            "    \"id\": 424,\n" +
            "    \"barcode\": \"55700-20025-11751-19437-46928-37108-00909-54690\",\n" +
            "    \"registryType\": {\n" +
            "      \"code\": \"DR\",\n" +
            "      \"name\": \"Передача документов из СП в СКД\"\n" +
            "    },\n" +
            "    \"registryStatus\": {\n" +
            "      \"code\": \"03\",\n" +
            "      \"name\": \"Отправлен\",\n" +
            "      \"orderField\": 3\n" +
            "    },\n" +
            "    \"documentType\": {\n" +
            "      \"name\": \"Действующие документы\",\n" +
            "      \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"id\": 1\n" +
            "    },\n" +
            "    \"transferType\": null,\n" +
            "    \"otherCorrespondenceType\": null,\n" +
            "    \"fromSubdivision\": {\n" +
            "      \"id\": 7,\n" +
            "      \"parent\": null,\n" +
            "      \"name\": \"г.Санкт-Петербург Доп.офис №9055/0434\",\n" +
            "      \"shortName\": \"Доп.офис №9055/0434\",\n" +
            "      \"code\": \"05590550434\",\n" +
            "      \"email\": \"noreply@this.mail.address\",\n" +
            "      \"osb\": \"05590550434\",\n" +
            "      \"vsp\": 90550434,\n" +
            "      \"oad\": true,\n" +
            "      \"active\": true,\n" +
            "      \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "      \"hasChild\": false\n" +
            "    },\n" +
            "    \"toSubdivision\": null,\n" +
            "    \"author\": {\n" +
            "      \"login\": \"oad_superAdminUser\",\n" +
            "      \"blocked\": false,\n" +
            "      \"active\": true,\n" +
            "      \"system\": true,\n" +
            "      \"employee\": {\n" +
            "        \"id\": 10,\n" +
            "        \"personnelNumber\": \"179\",\n" +
            "        \"firstName\": \"Руслан\",\n" +
            "        \"lastName\": \"Ярмош\",\n" +
            "        \"middleName\": \"Леонидович\",\n" +
            "        \"phone\": \"338\",\n" +
            "        \"contactPhone\": null,\n" +
            "        \"dismissed\": null,\n" +
            "        \"dismissDate\": \"2017-11-02 00:00:00\",\n" +
            "        \"subdivision\": {\n" +
            "          \"id\": 7,\n" +
            "          \"parent\": null,\n" +
            "          \"name\": \"г.Санкт-Петербург Доп.офис №9055/0434\",\n" +
            "          \"shortName\": \"Доп.офис №9055/0434\",\n" +
            "          \"code\": \"05590550434\",\n" +
            "          \"email\": \"noreply@this.mail.address\",\n" +
            "          \"osb\": \"05590550434\",\n" +
            "          \"vsp\": 90550434,\n" +
            "          \"oad\": true,\n" +
            "          \"active\": null,\n" +
            "          \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "          \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "          \"hasChild\": false\n" +
            "        },\n" +
            "        \"gender\": \"M\",\n" +
            "        \"email\": null,\n" +
            "        \"position\": null,\n" +
            "        \"sap\": null,\n" +
            "        \"user\": null,\n" +
            "        \"birthDate\": null\n" +
            "      },\n" +
            "      \"roles\": null,\n" +
            "      \"createdDate\": null,\n" +
            "      \"id\": 10\n" +
            "    },\n" +
            "    \"sender\": null,\n" +
            "    \"storageUnitAmount\": 1,\n" +
            "    \"createdDate\": \"2018-03-28 14:03:09\",\n" +
            "    \"sendDate\": \"2018-03-28 14:10:37\",\n" +
            "    \"verifyDate\": null,\n" +
            "    \"nomenclatureCase\": null,\n" +
            "    \"transportWaybill\": {\n" +
            "      \"id\": 127,\n" +
            "      \"barCode\": \"33290-31417-14788-19541-48292-30835-19896-34941\",\n" +
            "      \"stateCode\": {\n" +
            "        \"name\": \"Сверен\",\n" +
            "        \"code\": \"4\"\n" +
            "      },\n" +
            "      \"fromDept\": {\n" +
            "        \"id\": 1,\n" +
            "        \"parent\": null,\n" +
            "        \"name\": \"Поволжский банк\",\n" +
            "        \"shortName\": \"Поволжский банк\",\n" +
            "        \"code\": \"01\",\n" +
            "        \"email\": \"noreply@this.mail.address\",\n" +
            "        \"osb\": \"001\",\n" +
            "        \"vsp\": 1,\n" +
            "        \"oad\": false,\n" +
            "        \"active\": true,\n" +
            "        \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "        \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "        \"hasChild\": true\n" +
            "      },\n" +
            "      \"fromDeptId\": 1,\n" +
            "      \"toDept\": {\n" +
            "        \"id\": 4,\n" +
            "        \"type\": {\n" +
            "          \"code\": \"D\",\n" +
            "          \"name\": \"Структурное подразделение\"\n" +
            "        },\n" +
            "        \"subdivision\": null,\n" +
            "        \"state\": {\n" +
            "          \"code\": \"ACT\",\n" +
            "          \"name\": \"Действующий\"\n" +
            "        },\n" +
            "        \"name\": \"ВСП 7980\",\n" +
            "        \"address\": \"Москва\",\n" +
            "        \"phone\": \"444-444\",\n" +
            "        \"createdDate\": \"2018-03-16 00:00:00\",\n" +
            "        \"modifiedDate\": \"2018-03-16 00:00:00\",\n" +
            "        \"modifiedBy\": 6\n" +
            "      },\n" +
            "      \"toDeptId\": 4,\n" +
            "      \"createDate\": \"2018-03-28 14:12:30\",\n" +
            "      \"author\": {\n" +
            "        \"login\": \"system\",\n" +
            "        \"blocked\": false,\n" +
            "        \"active\": true,\n" +
            "        \"system\": true,\n" +
            "        \"employee\": {\n" +
            "          \"id\": 1,\n" +
            "          \"personnelNumber\": \"001\",\n" +
            "          \"firstName\": \"Василий\",\n" +
            "          \"lastName\": \"Пупкин\",\n" +
            "          \"middleName\": null,\n" +
            "          \"phone\": \"666-666\",\n" +
            "          \"contactPhone\": null,\n" +
            "          \"dismissed\": null,\n" +
            "          \"dismissDate\": \"2026-03-26 10:51:00\",\n" +
            "          \"subdivision\": {\n" +
            "            \"id\": 1,\n" +
            "            \"parent\": null,\n" +
            "            \"name\": \"Поволжский банк\",\n" +
            "            \"shortName\": \"Поволжский банк\",\n" +
            "            \"code\": \"01\",\n" +
            "            \"email\": \"noreply@this.mail.address\",\n" +
            "            \"osb\": \"001\",\n" +
            "            \"vsp\": 1,\n" +
            "            \"oad\": false,\n" +
            "            \"active\": null,\n" +
            "            \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "            \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "            \"hasChild\": true\n" +
            "          },\n" +
            "          \"gender\": \"M\",\n" +
            "          \"email\": null,\n" +
            "          \"position\": null,\n" +
            "          \"sap\": null,\n" +
            "          \"user\": null,\n" +
            "          \"birthDate\": null\n" +
            "        },\n" +
            "        \"roles\": null,\n" +
            "        \"createdDate\": null,\n" +
            "        \"id\": 1\n" +
            "      },\n" +
            "      \"authorId\": 1,\n" +
            "      \"sentDate\": \"2018-03-28 14:10:37\",\n" +
            "      \"recieveDate\": null,\n" +
            "      \"reciever\": null,\n" +
            "      \"recievedEmployeeId\": null,\n" +
            "      \"verifier\": null,\n" +
            "      \"verifiedEmployeeId\": null\n" +
            "    },\n" +
            "    \"transportUnit\": null\n" +
            "  },\n" +
            "  \"regNumber\": \"55011267\",\n" +
            "  \"name\": \"Документ\",\n" +
            "  \"regDate\": null,\n" +
            "  \"numberOfPages\": 0,\n" +
            "  \"ecmUrl\": null,\n" +
            "  \"barcode\": \"" + barcode + "\",\n" +
            "  \"documentStatus\": {\n" +
            "    \"code\": \"06\",\n" +
            "    \"name\": \"Отправлен\"\n" +
            "  },\n" +
            "  \"comments\": null,\n" +
            "  \"documentDefect\": null,\n" +
            "  \"nomenclatureCase\": null,\n" +
            "  \"createDate\": \"2018-03-16 03:00:00\",\n" +
            "  \"modifyDate\": \"2018-03-28 14:10:49\",\n" +
            "  \"archiveDate\": null,\n" +
            "  \"contracts\": [\n" +
            "    {\n" +
            "      \"id\": 201,\n" +
            "      \"absId\": null,\n" +
            "      \"customer\": {\n" +
            "        \"code\": \"45/4441\",\n" +
            "        \"type\": \"Ф\",\n" +
            "        \"temporary\": false,\n" +
            "        \"name\": \"Заявкин Андрей Петрович\",\n" +
            "        \"pprbRegDate\": \"2017-12-01 03:00:00\",\n" +
            "        \"pprbEndDate\": null,\n" +
            "        \"pprbStatus\": null,\n" +
            "        \"firstName\": \"Андрей\",\n" +
            "        \"lastName\": \"Заявкин\",\n" +
            "        \"middleName\": \"Петрович\",\n" +
            "        \"birthdayDate\": \"2011-08-21 04:00:00\",\n" +
            "        \"identityDocumentType\": {\n" +
            "          \"code\": \"21\",\n" +
            "          \"name\": \"Паспорт гражданина РФ\",\n" +
            "          \"description\": \"Паспорт гражданина РФ, действующий на территории РФ с 1 октября 1997 года\"\n" +
            "        },\n" +
            "        \"identityDocSeries\": \"4114\",\n" +
            "        \"identityDocNumber\": \"114466\",\n" +
            "        \"identityDocDate\": \"2006-11-12 03:00:00\",\n" +
            "        \"identityDocEndDate\": null,\n" +
            "        \"orgForm\": null,\n" +
            "        \"shortName\": null,\n" +
            "        \"inn\": null,\n" +
            "        \"kpp\": null,\n" +
            "        \"okpo\": null,\n" +
            "        \"orgn\": null,\n" +
            "        \"regDate\": null,\n" +
            "        \"linkedClientId\": null,\n" +
            "        \"parentClientId\": null,\n" +
            "        \"phone\": null,\n" +
            "        \"vip\": false,\n" +
            "        \"mass\": false,\n" +
            "        \"mvs\": false,\n" +
            "        \"pmvs\": false,\n" +
            "        \"createDate\": \"2018-03-16 03:00:00\",\n" +
            "        \"modifyDate\": \"2018-03-16 03:00:00\",\n" +
            "        \"archiveDate\": null,\n" +
            "        \"absId\": null,\n" +
            "        \"hasChild\": true,\n" +
            "        \"id\": 20\n" +
            "      },\n" +
            "      \"bankProduct\": {\n" +
            "        \"businessUnit\": null,\n" +
            "        \"productCategory\": {\n" +
            "          \"id\": 108,\n" +
            "          \"businessUnit\": null,\n" +
            "          \"code\": \"211\",\n" +
            "          \"name\": \"Смартполис –  Доп. соглашение\",\n" +
            "          \"shortName\": \"Смартполис –  Доп. соглашение\",\n" +
            "          \"validFrom\": \"2011-08-21\",\n" +
            "          \"validUntil\": \"1999-12-31\",\n" +
            "          \"validUntilFact\": null,\n" +
            "          \"setCheck\": null,\n" +
            "          \"verification\": null,\n" +
            "          \"inventory\": null,\n" +
            "          \"noOpening\": null,\n" +
            "          \"scanRequired\": null,\n" +
            "          \"createdDate\": \"2018-03-16 00:00:00\",\n" +
            "          \"createdBy\": null,\n" +
            "          \"modifiedDate\": \"2018-03-16 00:00:00\",\n" +
            "          \"modifiedBy\": null\n" +
            "        },\n" +
            "        \"productGroup\": null,\n" +
            "        \"code\": \"7644/2616\",\n" +
            "        \"name\": \"Смартполис - Рубли\",\n" +
            "        \"shortName\": \"Смартполис - Рубли\",\n" +
            "        \"validFrom\": \"2011-08-21\",\n" +
            "        \"validUntil\": \"1999-12-31\",\n" +
            "        \"validUntilFact\": null,\n" +
            "        \"storageTime\": null,\n" +
            "        \"nomenclatureCase\": null,\n" +
            "        \"sendTime\": null,\n" +
            "        \"notificationLimit\": null,\n" +
            "        \"setCheck\": null,\n" +
            "        \"verification\": null,\n" +
            "        \"inventory\": null,\n" +
            "        \"asCars\": null,\n" +
            "        \"noOpening\": null,\n" +
            "        \"scanRequired\": null,\n" +
            "        \"createdDate\": \"2018-03-16 00:00:00\",\n" +
            "        \"createdBy\": null,\n" +
            "        \"modifiedDate\": \"2018-03-16 00:00:00\",\n" +
            "        \"modifiedBy\": null,\n" +
            "        \"id\": 3131\n" +
            "      },\n" +
            "      \"documentNumber\": \"002СБ214 1495418\",\n" +
            "      \"openingDate\": \"2017-08-15 03:00:00\",\n" +
            "      \"closingDate\": null,\n" +
            "      \"checkDate\": \"2017-08-30 03:00:00\",\n" +
            "      \"subdivision\": {\n" +
            "        \"id\": 10015355,\n" +
            "        \"parent\": null,\n" +
            "        \"name\": \"Специализированный по обслуживанию физических лиц дополнительный офис № 9038/01305\",\n" +
            "        \"shortName\": \"С по ОФЛ ДО № 9038/01305\",\n" +
            "        \"code\": \"СпОФЛДО№9038\",\n" +
            "        \"email\": null,\n" +
            "        \"osb\": null,\n" +
            "        \"vsp\": null,\n" +
            "        \"oad\": false,\n" +
            "        \"active\": true,\n" +
            "        \"createdDate\": \"2011-08-21 00:00:00\",\n" +
            "        \"modifiedDate\": \"2011-08-21 00:00:00\",\n" +
            "        \"hasChild\": false\n" +
            "      },\n" +
            "      \"contractRukState\": {\n" +
            "        \"code\": \"001\",\n" +
            "        \"name\": \"Статус РУК Договора 001\"\n" +
            "      },\n" +
            "      \"documents\": null,\n" +
            "      \"createdDate\": \"2018-03-16 03:00:00\",\n" +
            "      \"modifiedDate\": \"2018-03-16 03:00:00\",\n" +
            "      \"archivedDate\": null\n" +
            "    }\n" +
            "  ],\n" +
            "  \"inventoryObligatory\": null,\n" +
            "  \"author\": {\n" +
            "    \"login\": \"system\",\n" +
            "    \"blocked\": false,\n" +
            "    \"active\": true,\n" +
            "    \"system\": true,\n" +
            "    \"employee\": {\n" +
            "      \"id\": 1,\n" +
            "      \"personnelNumber\": \"001\",\n" +
            "      \"firstName\": \"Василий\",\n" +
            "      \"lastName\": \"Пупкин\",\n" +
            "      \"middleName\": null,\n" +
            "      \"phone\": \"666-666\",\n" +
            "      \"contactPhone\": null,\n" +
            "      \"dismissed\": null,\n" +
            "      \"dismissDate\": \"2026-03-26 10:51:00\",\n" +
            "      \"subdivision\": {\n" +
            "        \"id\": 1,\n" +
            "        \"parent\": null,\n" +
            "        \"name\": \"Поволжский банк\",\n" +
            "        \"shortName\": \"Поволжский банк\",\n" +
            "        \"code\": \"01\",\n" +
            "        \"email\": \"noreply@this.mail.address\",\n" +
            "        \"osb\": \"001\",\n" +
            "        \"vsp\": 1,\n" +
            "        \"oad\": false,\n" +
            "        \"active\": null,\n" +
            "        \"createdDate\": \"2017-11-04 00:00:00\",\n" +
            "        \"modifiedDate\": \"2017-11-04 00:00:00\",\n" +
            "        \"hasChild\": true\n" +
            "      },\n" +
            "      \"gender\": \"M\",\n" +
            "      \"email\": null,\n" +
            "      \"position\": null,\n" +
            "      \"sap\": null,\n" +
            "      \"user\": null,\n" +
            "      \"birthDate\": null\n" +
            "    },\n" +
            "    \"roles\": null,\n" +
            "    \"createdDate\": null,\n" +
            "    \"id\": 1\n" +
            "  },\n" +
            "  \"required\": null,\n" +
            "  \"severalDocumentsFromContractInRegistry\": null,\n" +
            "  \"id\": 201\n" +
            "}";


    public void fillForm() throws InterruptedException {
        click(By.cssSelector("button.btn.try-out__btn"));
        click(By.cssSelector("textarea.body-param__text"));
        driver.findElement(By.cssSelector("textarea.body-param__text")).sendKeys(Keys.LEFT_CONTROL, "a");
        driver.findElement(By.cssSelector("textarea.body-param__text")).sendKeys(Keys.DELETE);
        driver.findElement(By.cssSelector("textarea.body-param__text")).sendKeys(Keys.ARROW_LEFT);
        driver.findElement(By.cssSelector("textarea.body-param__text")).sendKeys(request);
        driver.findElement(By.cssSelector("textarea.body-param__text")).sendKeys(Keys.DELETE);
        Thread.sleep(1000);
    }

    public void accept() {
        click(By.cssSelector("button.btn.execute.opblock-control__btn"));
    }

    public String docnumber() {
        return driver.findElement(By.xpath("//td[2]/div/pre")).getText();
    }

    public void newBarcodeFirsTime() {
         Actions actions = new Actions(driver);
         WebElement we = driver.findElement(By.cssSelector("textarea.body-param__text"));
        actions.moveToElement(we);
        actions.click();

        for (int i = 0; i < 169; i++) {
            actions.sendKeys(Keys.ARROW_UP);
        }
        for (int i = 0; i < 62; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.BACK_SPACE);
        }
        actions.sendKeys(random.randomNumber(5));
        actions.perform();
  }

    public void newBarcodeSecondTime() {
        Actions actions = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector("textarea.body-param__text"));
        actions.moveToElement(we);
        actions.click();
        for (int i = 0; i < 24; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 9; i++) {
            actions.sendKeys(Keys.ARROW_UP);
        }
        for (int i = 0; i < 38; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.DELETE);
        }
        actions.sendKeys(random.randomNumber(5));
        actions.perform();
    }


}
