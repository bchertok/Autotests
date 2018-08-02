package sberoad.appmanager;

import sberoad.exception.FailedDocumentStateException;

import java.util.ArrayList;
import java.util.List;

public class DBArraysTEML {
    private static DB db1 = new DB();


    public static String registryBarcodeinStatesAndNotinTEML(String states) {
        //и не связаны с ТЕ или МЛ
        return db1.getRandomValue("select z.CODE from BARCODEINFO z\n" +
                "inner join REGISTRY u on u.pid = z.ENTITY_PID\n" +
                "inner join REGISTRYSTATE ub on u.STATECODE_PID = ub.PID\n" +
                "left join TRANSPORTUNITITEM ud on u.PID=ud.REGISTRY_PID\n" +
                "left join WAYBILLITEM uz on u.pid=uz.REGISTRY_PID\n" +
                "where ud.PID is null\n" +
                "and uz.PID is null\n" +
                "and ub.CODE in (" + states + ")", "CODE");
    }

    public static String registryBarcodeinStatesInTEML(String states) {
        //связаны с ТЕ или МЛ
        return db1.getRandomValue("select z.CODE from BARCODEINFO z\n" +
                "inner join REGISTRY u on u.pid = z.ENTITY_PID\n" +
                "inner join REGISTRYSTATE ub on u.STATECODE_PID = ub.PID\n" +
                "left join TRANSPORTUNITITEM ud on u.PID=ud.REGISTRY_PID\n" +
                "left join WAYBILLITEM uz on u.pid=uz.REGISTRY_PID\n" +
                "where ud.PID is not null and ub.CODE in (" + states + ") or\n" +
                "uz.PID is not null\n" +
                "and ub.CODE in (" + states + ")", "CODE");
    }

    public static List<String> listWithRegistryInTE(String teid) {
        //реестры включенные в ТЕ
        return db1.getAllValue("    Select t.REGISTRY_PID from TRANSPORTUNITITEM t\n" +
                "    Where t.TRANSPORTUNIT_PID = '" + teid + "'\n" +
                "  AND t.REGISTRY_PID is not null", "REGISTRY_PID");
    }

    public static String TransportUnitState(String teid) {
        //реестры включенные в ТЕ
        return db1.getRandomValue("select o.STATECODE_PID from \n" +
                "    (select * from TRANSPORTUNITSTATEHISTORY\n" +
                "    where TRANSPORTUNIT_PID = '" + teid + "'\n" +
                "    order by DT desc) o\n" +
                "WHERE rownum = 1", "STATECODE_PID");
    }

    public static List<String> TEinStatesWithorWithoutTE(String states, String nullornot, boolean inWaybill) throws FailedDocumentStateException {
        // надо написать статус одной цифрой "2" и is null или is not null на дочерние ТЕ
        String zzz;
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> state1 = new ArrayList<>();
        ArrayList<String> state2 = new ArrayList<>();
        ArrayList<String> state3 = new ArrayList<>();
        ArrayList<String> state4 = new ArrayList<>();
        ArrayList<String> state5 = new ArrayList<>();
        ArrayList<String> state6 = new ArrayList<>();
        ArrayList<String> state7 = new ArrayList<>();
        //ТЕ в определенном статусе и с дочерними и недочерними ТЕ
        List<String> pid = db1.getAllValue("select DISTINCT u.pid from TRANSPORTUNIT u\n" +
                "INNER join TRANSPORTUNITITEM t on t.TRANSPORTUNIT_PID = u.PID\n" +
                "WHERE t.SUBTRANSPORTUNIT_PID " + nullornot, "PID");

        if (inWaybill) {
            // все элементы которые есть в waybill
            pid.removeIf((s) -> !inWaybill().contains(s));

        } else {
            // все элементы которых нет в waybill
            pid.removeAll(inWaybill());
        }


        for (String s : pid) {
            zzz = db1.getRandomValue("select o.STATECODE_PID from \n" +
                    "    (select * from TRANSPORTUNITSTATEHISTORY\n" +
                    "    where TRANSPORTUNIT_PID = '" + s + "'\n" +
                    "    order by DT desc) o\n" +
                    "WHERE rownum = 1", "STATECODE_PID");
            result.add(zzz);
            if (zzz.equals("178250")) {
                state1.add(s);
            }
            if (zzz.equals("178251")) {
                state2.add(s);
            }
            if (zzz.equals("178252")) {
                state3.add(s);
            }
            if (zzz.equals("178253")) {
                state4.add(s);
            }
            if (zzz.equals("178254")) {
                state5.add(s);
            }
            if (zzz.equals("178255")) {
                state6.add(s);
            }
            if (zzz.equals("178256")) {
                state7.add(s);
            }
        }
        if (states.equals("1")) {
            return state1;
        }
        if (states.equals("2")) {
            return state2;
        }
        if (states.equals("3")) {
            return state3;
        }
        if (states.equals("4")) {
            return state4;
        }
        if (states.equals("5")) {
            return state5;
        }
        if (states.equals("6")) {
            return state6;
        }
        if (states.equals("7")) {
            return state7;
        }
        System.out.println(result);
        System.out.println(pid);
        throw new FailedDocumentStateException("Неверно указан аргумент");
    }

    private static List<String> inWaybill() {

        return db1.getAllValue("select TRANSPORTUNIT_PID from WAYBILLITEM ", "TRANSPORTUNIT_PID");
    }
}

