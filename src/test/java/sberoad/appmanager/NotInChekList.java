package sberoad.appmanager;

import java.io.*;
import java.util.ArrayList;

public class NotInChekList {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\BChertok\\Desktop\\bugs\\jira.txt"),
                "utf-8");
        Reader reader2 = new InputStreamReader(new FileInputStream("C:\\Users\\BChertok\\Desktop\\bugs\\bugs.txt"),
                "utf-8");
        ArrayList<String> jiraFile = new ArrayList<>();
        ArrayList<String> avtosravn1 = new ArrayList<>();
        ArrayList<String> avtosravn2 = new ArrayList<>();
        BufferedReader jiraBufferedReader = new BufferedReader(reader);
        jiraBufferedReader.lines().forEach(s -> {
            jiraFile.add(s);
        });
        jiraFile.forEach(System.out::println);

        System.out.println("====================");
        ArrayList<String> bugsFile = new ArrayList<>();
        BufferedReader bugsBufferedReader = new BufferedReader(reader2);
        bugsBufferedReader.lines().forEach(s -> {
            bugsFile.add(s);
        });
        bugsFile.forEach(System.out::println);


        for (String s : bugsFile) {
            for (int z = 0; z < jiraFile.size(); z++)
                if (s.contains(jiraFile.get(z))) {
                    avtosravn1.add(jiraFile.get(z));
                }
        }

        avtosravn2 = jiraFile;
        avtosravn2.removeAll(avtosravn1);

        System.out.println("\n======================================================================================");
        avtosravn2.forEach(System.out::println);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\BChertok\\Desktop\\bugs\\rezRaznicisJiravar1.txt"))) {
            for (String line : jiraFile) {

                bw.write(line + "\n");
                bw.newLine();

            }
        }
    }
}