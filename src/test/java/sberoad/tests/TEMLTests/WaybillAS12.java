package sberoad.tests.TEMLTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sberoad.appmanager.DBArrays2;
import sberoad.appmanager.RandomFromList;
import sberoad.appmanager.Randoms;
import sberoad.tests.TestBase;

import java.util.List;

public class WaybillAS12 extends TestBase {
    private Randoms rnd = new Randoms();
    @Test
    public void AS12() throws InterruptedException {
        application.getNavigation().toNewTransportUnit();
        as12help(DBArrays2.dailybindingBarcode());
        as12help(DBArrays2.inventoryBarcode());
        as12help(DBArrays2.documentBarcode());
        as12help(DBArrays2.waybillBarcode());
        as12help(DBArrays2.dossierBarcode());
        as12help(DBArrays2.fileboxBarcode());
        as12help(DBArrays2.boxBarcode());
        as12help(rnd.randomBarcode());
        as12help(rnd.randomForBarcodeCrash(55));
    }

    private void as12help(List<String> alist) throws InterruptedException {
        RandomFromList rnd = new RandomFromList(alist);
        Thread.sleep(2500);
        application.getTransportunitHelper().addItem((String) rnd.randomElementfromList());
        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                "Для добавления в транспортную еденицу доступны только реестры и транспортные единицы");
    }


    private void as12help(String s) throws InterruptedException {
        Thread.sleep(2500);
        application.getTransportunitHelper().addItem(s);
        Assert.assertEquals(application.getRegistryHelper().getnotificationtext(),
                "Для добавления в маршрутный лист доступны только реестры и транспортные единицы");
    }
}
