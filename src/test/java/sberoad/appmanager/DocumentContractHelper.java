package sberoad.appmanager;

import java.util.*;
import java.util.stream.Collectors;


public class DocumentContractHelper {
    public static List<String> docID() {
        DB db = new DB();

        List<String> docID = db.getAllValue("SELECT " +
                        "uz.DOCNUMBER from DOCUMENT_CONTRACT u \n" +
                        "inner join DOCUMENT ud on u.DOCUMENT_ID=ud.ID\n" +
                        "inner join CONTRACT uz on uz.ID=u.CONTRACT_ID\n" +
                        "where ud.FORMCODE in (0,3) and ud.STATECODE in (2) and ud.INVENTORY_ID is null"
                , "DOCNUMBER");
        return docID;
    }

    public static List<String> contractWithManyDoc() {
        List<String> docID = docID();
        List<String> contractWithManyDoc = new ArrayList<>();
        docID = docID.stream().sorted().collect(Collectors.toList());
        for (int i = 1; i < docID.size(); i++) {
            if (docID.get(i - 1).equals(docID.get(i))) {
                contractWithManyDoc.add(docID.get(i));
            }
        }
        contractWithManyDoc = contractWithManyDoc.stream().distinct().collect(Collectors.toList());
        return contractWithManyDoc;
    }

    public static List<String> contractWithOneDoc() {
        List<String> contractWithOneDoc = new ArrayList<>();
        List<String> zzz = new ArrayList<>();

        contractWithOneDoc.addAll(docID());
        zzz.addAll(contractWithManyDoc());

        contractWithOneDoc.removeAll(zzz);

        return contractWithOneDoc;
    }
}