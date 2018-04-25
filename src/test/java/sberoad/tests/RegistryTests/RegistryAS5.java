package sberoad.tests.RegistryTests;

import org.testng.annotations.Test;
import sberoad.appmanager.DocumentContractHelper;
import sberoad.tests.TestBase;

public class RegistryAS5 extends TestBase {
    @Test
    public void registryAS5var1() throws InterruptedException {
// контракты с доступными действующими доками
System.out.println(DocumentContractHelper.contractWithDoc());
    }
}