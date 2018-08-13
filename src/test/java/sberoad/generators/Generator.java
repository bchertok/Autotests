package sberoad.generators;

import sberoad.appmanager.Randoms;

import java.io.*;
import java.util.ArrayList;


public class Generator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        BufferedWriter bw = new BufferedWriter(new FileWriter((args[1])));
        ArrayList testData =  generategroups(count);
        save (testData,bw);
        System.out.println(testData);
    }

    private static void save(ArrayList zz, BufferedWriter bw) throws IOException {
        for (Object line : zz) {
            System.out.println(line);
            bw.write(line + "\n");
        }
        bw.close();
    }

    private static ArrayList generategroups(int count) {
        ArrayList<String> list = new ArrayList<>();
        Randoms rnd = new Randoms();
        for (int i = 0;i<count;i++){
            list.add(rnd.randomString(10));
        }
return list;
    }


}
