package sberoad.learning;

import java.util.ArrayList;

public class ForEach {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 23; i++) {
            list.add(i);
            if (i == 7) break;
        }
        for (int z : list) {
            System.out.println(z);
            if (z == 5) break;
        }

        for (int i = 0; i < 10; i++) {
            for (int z = i; z < 10; z++) {
                System.out.print("z");
            }
            System.out.println();
        }

        outer:
        for (int i = 0; i < 3; i++) {
            System.out.print("Пpoxoд " + i + ": ");
            for (int j = 0; j < 100; j++) {

                if (j == 10) break outer; // выход из обоих циклов
                System.out.print(j + " ");
            }
            System.out.println(" Этa строка не буде т выводиться ");
        }
            System.out.println(" Циклы завершены . ");

    }
}