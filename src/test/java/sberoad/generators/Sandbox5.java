package sberoad.generators;

import jdk.nashorn.internal.ir.Terminal;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.smartcardio.TerminalFactory;
import javax.smartcardio.TerminalFactorySpi;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Sandbox5 {


    public void auth(String login, String password) throws InterruptedException {

        System.out.println(login);
        System.out.println(password);

//        driver.get("");
//        Thread.sleep(500);
//        HelperBase ispravit = new HelperBase(driver);
//        ispravit.type(login, By.xpath("//input"));
//        ispravit.type(password, By.xpath("//div[2]/div/div/span/input"));
//        driver.findElement(By.xpath("//button")).click();
    }

    @Test

    public void tryyy() throws InterruptedException, IOException {

        auth(Auth.getDboAdminlog(), Auth.getDboAdminpas());

        auth(Auth.getSecurityAdminlog(), Auth.getSecurityAdminpas());


    }
}