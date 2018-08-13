package sberoad.tests.TEMLTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sberoad.tests.TestBase;

public class TransportUnitAS14 extends TestBase {
    private String reg1;
    private String reg2;
    private String te;

    @BeforeTest
    public void before() throws InterruptedException {
        TransportUnit2reg transportUnit2reg = new TransportUnit2reg();
        transportUnit2reg.transportunit2R(true);
        reg1 = transportUnit2reg.getReg1();
        reg2 = transportUnit2reg.getReg2();
        te = transportUnit2reg.getTEbarcode();
    }

    @Test
    public void var1() throws InterruptedException {
        System.out.println(reg1);
        System.out.println(reg2);
        System.out.println(te);
    }
}
