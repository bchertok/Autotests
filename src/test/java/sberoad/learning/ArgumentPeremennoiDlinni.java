package sberoad.learning;

import java.util.ArrayList;
import java.util.Arrays;

class ArgumentPeremennoiDlinni {
    private ArrayList<String> j = new ArrayList<>();

    ArgumentPeremennoiDlinni(String... i) {

        j.addAll(Arrays.asList(i));
    }

    void zzz() {
        System.out.println(j);

    }
}

class ArgumentPeremennoiDlinnitest {

    public static void main(String[] args) {
        ArgumentPeremennoiDlinni test = new ArgumentPeremennoiDlinni("125", "7588", "34646", "hntghr");
        test.zzz();
    }
}