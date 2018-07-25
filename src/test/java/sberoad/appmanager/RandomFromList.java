package sberoad.appmanager;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class RandomFromList {

    private ArrayList list;

    public RandomFromList(List<String> alist) {
        list = (ArrayList) alist;
    }

    public Object randomElementfromList() {
        Random rnd = new Random();
        int i = rnd.nextInt(list.size());
        return list.get(i);
    }
}
