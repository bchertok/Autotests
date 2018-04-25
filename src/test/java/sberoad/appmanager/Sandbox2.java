package sberoad.appmanager;


public class Sandbox2 {
    public static void main(String[] args) {
        Sandbox sandbox = new Sandbox();
        System.out.println(DocumentContractHelper.docID());
        System.out.println(DocumentContractHelper.contractWithManyDoc());
        System.out.println(DocumentContractHelper.contractWithOneDoc());

//        sandbox.documentWithoutBarcodeinfo();
       // sandbox.normalDocuments();
    }
}
