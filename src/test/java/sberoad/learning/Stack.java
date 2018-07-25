package sberoad.learning;

import java.util.Arrays;

public class Stack {
    int stck[] = new int[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void add(int item) {
        if (tos == 9) {
            System.out.println("стек заполнен");
        } else {
            stck[++tos] = item;
        }
    }

    int del(int i) {
        if (tos < 0) {
            System.out.println("stack pustoui");
            return 0;
        } else {
            return stck[tos--];
        }

    }
}

class TestStack {
    public static void main(String[] args) {


        Stack stc1 = new Stack();
        Stack stc2 = new Stack();

        for (int i = 0; i < 10; i++) {
            stc1.add(i);
            System.out.println(i);
        }
        for (int i = 10; i < 20; i++) {
            stc2.add(i);
            System.out.println(i);
        }


for (int i=20;i>10;i--){
stc1.del(i);
    System.out.println(i);
}
    }
}