package sberoad.tests.TEMLTests;

import sberoad.appmanager.DBArraysTEML;
import sberoad.tests.TestBase;

public class TransportUnit2reg extends TestBase {
    private String reg1;
    private String reg2;
    private String TEbarcode;

    void transportunit2R(boolean finishform) throws InterruptedException {
        application.getNavigation().startPage();
        application.getNavigation().toNewTransportUnit();
        reg1 = DBArraysTEML.registryBarcodeinStatesAndNotinTEML("02");
        reg2 = DBArraysTEML.registryBarcodeinStatesAndNotinTEML("02");
        application.getTransportunitHelper().addItem(reg1);
        Thread.sleep(400);
        application.getTransportunitHelper().addItem(reg2);
        Thread.sleep(400);
        TEbarcode = application.getTransportunitHelper().copyTeBarcode();
        if (finishform) {
            application.getTransportunitHelper().finishForm();
        }
    }

    String getReg1() {
        return reg1;
    }

    String getReg2() {
        return reg2;
    }

    String getTEbarcode() {
        return TEbarcode;
    }
}
