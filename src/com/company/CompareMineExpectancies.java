package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class CompareMineExpectancies implements Comparator<Button> {

    private ArrayList<Button> buttonList;

    public CompareMineExpectancies() {
        buttonList = new ArrayList<Button>();
    }

    @Override
    public int compare(Button b1, Button b2) {
        if (b1.getMineExpectancy() >= b2.getMineExpectancy())
            return 1;
        else
            return -1;
    }
}
