package sberoad.appmanager;

import java.util.*;
import java.util.stream.Collectors;


public class DocumentContractHelper {


    public static List<String> contractWithDoc() {
        DB db = new DB();

        List<String> docIdFromDoc_con = new ArrayList<>();
        List<String> contractWithDocuments = new ArrayList<>();

        List<String> docID = db.getAllValue("SELECT " +
                        "* FROM DOCUMENT WHERE FORMCODE != 01 AND FORMCODE != 02 AND STATECODE=02 AND INVENTORY_ID IS NULL "
                , "ID");

        System.out.println(docID);

        for (String s : docID) {
            String conID = db.getRandomValue("SELECT " +
                    "CONTRACT_ID FROM DOCUMENT_CONTRACT WHERE DOCUMENT_ID=" + s, "CONTRACT_ID");
            docIdFromDoc_con.add(conID);
        }
        docIdFromDoc_con = docIdFromDoc_con.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(docIdFromDoc_con);

        for (String z : docIdFromDoc_con) {

            String conNum = db.getRandomValue("SELECT " +
                    "DOCNUMBER FROM CONTRACT WHERE ID=" + z, "DOCNUMBER");
            contractWithDocuments.add(conNum);
            System.out.println(z);
            System.out.println(conNum);
        }
// превращаем лист в поток затем фильтруем на уникальность и превращаем обратно в коллекцию, а точнее лист
        return contractWithDocuments.stream().distinct().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static List<String> docID() {
        DB db = new DB();

        List<String> docID = db.getAllValue("SELECT " +
                        "uz.DOCNUMBER from DOCUMENT_CONTRACT u \n" +
                        "inner join DOCUMENT ud on u.DOCUMENT_ID=ud.ID\n" +
                        "inner join CONTRACT uz on uz.ID=u.CONTRACT_ID\n" +
                        "where ud.FORMCODE in (0, 3) and ud.STATECODE in (2) and ud.INVENTORY_ID is null"
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