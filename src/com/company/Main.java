package com.company;

import java.text.DecimalFormat;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Gui gui = new Gui(5, 5);
        gui.showGui();
        gui.printTable();

        System.out.println();
        gui.sortList();
        System.out.println();
        Collections.sort(gui.listAll, new CompareMineExpectancies());
        gui.sortList();
        gui.printTable();

    }
}
