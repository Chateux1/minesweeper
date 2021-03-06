package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class CompareMineExpectancies implements Comparator<ArrayList<String>> {

    private ArrayList<ArrayList<String>> listExpectancies;

    public CompareMineExpectancies() {
        listExpectancies = new ArrayList<>();
    }

    @Override
    public int compare(ArrayList<String> list1, ArrayList<String> list2) {
        return list2.get(1).compareTo(list1.get(1));
    }
}
