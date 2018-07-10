package sberoad.appmanager;


import java.util.ArrayList;

public class Sandbox2 {
    public static void main(String[] args) {
        String invabs1 = DBArrays3random.inventoryFromAbs("04");
        String invID = DBArrays3random.selectFromBarcodeinfoWhereBARCODE(invabs1);

        ArrayList docsates = (ArrayList) DBArrays2.documentStatewithINVENTORY(invID);
        System.out.println(docsates);
    }
}
