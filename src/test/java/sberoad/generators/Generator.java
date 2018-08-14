package sberoad.generators;

import sberoad.appmanager.Randoms;

import java.io.*;
import java.util.ArrayList;


public class Generator {

    public static void main(String[] args) throws IOException {
        // аргумент количества строк
        int count = Integer.parseInt(args[0]);
        // аргумент путь к файлу, куда писать
        BufferedWriter bw = new BufferedWriter(new FileWriter((args[1])));
        ArrayList testData =  generategroups(count);
        save (testData,bw);
    }

    // запись листа в файл
    private static void save(ArrayList zz, BufferedWriter bw) throws IOException {
        System.out.println(zz.size());

        // тут скрыт кусок через сколько слов переходить на следующую строку
        int i = 0;
        for (Object line : zz) {
            bw.write(line + " ");
            i++;
            if (i==5){
                bw.newLine();
                i = 0;
            }
        }
        bw.close();
    }

    private static ArrayList generategroups(int count) {
        // генерация и запись в лист
        ArrayList<String> list = new ArrayList<>();
        Randoms rnd = new Randoms();
        for (int i = 0;i<count;i++){
            list.add(rnd.randomString(10));
            list.add(rnd.randomString(7));
            list.add(rnd.randomString(3));
            list.add(rnd.randomString(9));
            list.add(rnd.randomString(1));
        }
        System.out.println(list);

return list;
    }


}
